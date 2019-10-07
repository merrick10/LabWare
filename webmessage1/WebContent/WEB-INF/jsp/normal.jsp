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
<title>NORMAL</title>
<script type="text/javascript">
 function templatemsg(){
	 var fm = document.createElement('form');
	 fm.method = 'post';
	 fm.target = '_self';
	 fm.action = 'http://' +window.location.host +'/webmessage1/templatemgsg';
	 document.body.appendChild(fm);
	 fm.submit();
 }

</script>
</head>
<body>
<br/>
<h1 style="color: RED;font-size: 20px;	">hello</h1>
<br/>
<input type="button" onclick="templatemsg()" value="TEST"/>

<br/>
<hr/>

</body>
</html>