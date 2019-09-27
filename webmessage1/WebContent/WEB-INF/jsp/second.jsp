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
<title>STOMP</title>

<script type="text/javascript">
	

</script>
</head>
<body>
<br/>
<h1 style="color: blue;font-size: 30px;	">Now:<c:out value="${msg}"></c:out></h1>
<br/>


<br/>
<hr/>

</body>
</html>