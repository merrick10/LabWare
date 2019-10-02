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
<title>STOMP_send_broadcaster</title>
<script type="text/javascript" src="js/sockjs.js"></script>
<script type="text/javascript" src="js/stomp.js"></script>
<script type="text/javascript">

	window.onload = function(){
		var url = 'http://' + window.location.host + '/webmessage1/stompsockjs';
		var sc = new SockJS(url, undefined, {transports: ['websocket']});
		var stomp = Stomp.over(sc);

		var payload_broadcast = JSON.stringify({'prop1':'Broadcast_third page.'});
		var headers = {username:'admin',password:'admin'};
		stomp.connect(headers,function(frame){
			
			
			/**
			发送消息，主动机制
			*/
			var tx = stomp.begin();
			
			stomp.send('/app/broadcast',{transaction:tx.id},payload_broadcast);
			
			tx.commit();
			
			
	
			
		});
		
		
	}



</script>
</head>
<body>
<h2>stomp broadcaster</h2>
<br/>
<h1 style="color: blue;font-size: 30px;	">Now:<c:out value="${msg}"></c:out></h1>
<br/>


<br/>
<hr/>

</body>
</html>