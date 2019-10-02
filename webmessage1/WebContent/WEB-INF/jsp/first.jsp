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
<title>HI</title>

<script type="text/javascript" src="js/sockjs.js"></script>
<script type="text/javascript">
	
	window.onload = function(){

 		/* var url = 'ws://' + window.location.host + '/webmessage1/sock';
		var sock =  new WebSocket(url);  */
		
		var url = 'http://' + window.location.host + '/webmessage1/sockjs';
 		//var url = '/webmessage1/sockjs';
		var sock =  new SockJS(url);  

		
		sock.onopen = function(){
			console.log("Opening");
			saysth();
		}
		
		sock.onmessage = function(e) {
		     console.log('message', e.data);
		    // sock.close();
		    setTimeout(function(){saysth();},2000);
		 };
		
		sock.onclose = function(){
			console.log('Closing');
		}
		
		function saysth(){
			console.log("Sending");
			sock.send("Client!");
		}
		
	}

</script>
</head>
<body>
<br/>
<h1 style="color: blue;font-size: 20px;	">Now:<c:out value="${msg}"></c:out></h1>
<br/>


<br/>
<hr/>

</body>
</html>