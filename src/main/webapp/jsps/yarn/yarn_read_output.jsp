<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Read Entity Output</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>Read Entity Output</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	yarn_id    :<input type="text" name="yarn_id" value="${form.yarn_id}"disabled/>
	<br/>
	weight：<input type="text" name="weight" value="${form.weight }"disabled/>
	<br/>
	yardage	：<input type="text" name="yardage" value="${form.yardage }"disabled/>
	<br/>
		fiber	：<input type="text" name="fiber" value="${form.fiber }"disabled/>
	<br/>
		recommended_hook_size	：<input type="text" name="recommended_hook_size" value="${form.recommended_hook_size }"disabled/>
	<br/>
		recommended_needle_size	：<input type="text" name="recommended_needle_size" value="${form.recommended_needle_size }"disabled/>
	<br/>
		name	：<input type="text" name="name" value="${form.name }"disabled/>
	<br/>
		manufacturer	：<input type="text" name="manufacturer" value="${form.manufacturer }"disabled/>
	<br/>
</form>

<button onclick="window.location.href='<c:url value='/jsps/main.jsp'/>'">Continue</button>
</body>
</html>
