package merrick.config;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebConfig extends AbstractAnnotationConfigDispatcherServletInitializer
		implements WebApplicationInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {

		return new Class<?>[] {MyWebSocketConfig.class,MyWebSocketStompConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {MySpringWebMvcConfig.class};

	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {		
		
		servletContext.addListener(org.apache.logging.log4j.web.Log4jServletContextListener.class);
		
		FilterRegistration.Dynamic fr = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
		Map<String,String> fmap = new HashMap<String,String>();
		fmap.put("encoding", String.valueOf(StandardCharsets.UTF_8));		
		fmap.put("forceEncoding", "true");
		fr.setInitParameters(fmap);	
		fr.addMappingForUrlPatterns(null, false, "/*");
		
		super.onStartup(servletContext);
	}

}
