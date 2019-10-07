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
<title>STOMP_receiver2</title>
<script type="text/javascript" src="js/sockjs.js"></script>
<script type="text/javascript" src="js/stomp.js"></script>
<script type="text/javascript">

	window.onload = function(){
		var url = 'http://' + window.location.host + '/webmessage1/stompsockjs';
		var sc = new SockJS(url, undefined, {transports: ['websocket']});
		var stomp = Stomp.over(sc);
		var payload_subscribe2 = JSON.stringify({'prop1':'Need subscribe 2.'});
		var headers = {username:'admin',password:'admin'};
		stomp.connect(headers,function(frame){
			
			
			/**
			发送消息，主动机制
			*/
// 			var tx = stomp.begin();
// 			stomp.send('/app/msg2',{transaction:tx.id},payload_subscribe2);//会发送给APP
// 			tx.commit();
			
			

			/**
			订阅Topic，被动机制，消息可能来自web服务端或者来自Broker
			**/
			stomp.subscribe("/topic/msg2",function(data){//仅仅会发送给broker
				var obj=JSON.parse(data.body);
				console.log("received2:",obj['prop1']);
			},function(err){
				console.log(err.headers.message);
			});
			
		});
		
		
	}



</script>
</head>
<body>
<h2>stomp subscriber2</h2>
<br/>
<h1 style="color: blue;font-size: 30px;	">Now:<c:out value="${msg}"></c:out></h1>
<br/>


<br/>
<hr/>

</body>
</html>