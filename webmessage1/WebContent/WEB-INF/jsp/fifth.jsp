<%@ page language="java" import="java.util.*"  contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<head>
<title>STOMP_subscriber_templateMsg</title>
<script type="text/javascript" src="js/sockjs.js"></script>
<script type="text/javascript" src="js/stomp.js"></script>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="js/handlebars-v4.3.1.js"></script>
<script type="text/javascript">

	window.onload = function(){
		var url = 'http://' + window.location.host + '/webmessage1/stompsockjs';
		var sc = new SockJS(url, undefined, {transports: ['websocket']});
		var stomp = Stomp.over(sc);
		var headers = {username:'admin',password:'admin'};
		stomp.connect(headers,function(frame){

			/**
			订阅Topic，被动机制，消息可能来自web服务端或者来自Broker
			
			模板消息，订阅，订阅的消息模板展现
			
			**/
			stomp.subscribe("/topic/template1",function(data){
				var obj=JSON.parse(data.body);				
				console.log("received:",obj);
				var source = $('#templatesymb1').html();
				var template = Handlebars.compile(source);//前端库，Handlebars库
				var content = template(obj);//消息模板
				$('#lst1').prepend(content);
				
				
			},function(err){
				console.log(err.headers.message);
			});			
		});		
	}
</script>

<script id="templatesymb1" type="text/x-handlebars-template">
	<li id="preexist">
		<div style='color:blue;'>{{prop1}}</div>
	</li>
</script>


</head>
<body>
<h2>stomp subscriber template message</h2>
<br/>
<br/>
<ul id="lst1" ></ul>

<br/>
<hr/>

</body>
</html>