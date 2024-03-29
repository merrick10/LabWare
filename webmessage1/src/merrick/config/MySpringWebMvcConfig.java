package merrick.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"merrick.control"})
public class MySpringWebMvcConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
	
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	

	@Bean
	public ViewResolver internalViewResolver() {
		InternalResourceViewResolver  irrv = new InternalResourceViewResolver ();
		irrv.setSuffix(".jsp");
		irrv.setPrefix("/WEB-INF/jsp/");
		return irrv;
	}
	

}
