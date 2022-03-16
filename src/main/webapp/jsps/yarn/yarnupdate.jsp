<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update yarn</title>
    
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
  <h1>Update</h1>
<form action="<c:url value='/Entity1ServletCreate'/>" method="post">
	<input type="hidden" name="method" value="search"/>
	yarn_id    :<input type="text" name="yarn_id" value="${form.yarn_id}"/>
	<span style="color: red; font-weight: 900">${errors.yarn_id }</span>
	<br/>
	weight：<input type="text" name="weight" value="${form.weight }"/>
	<span style="color: red; font-weight: 900">${errors.weight }</span>
	<br/>
	yardage	：<input type="text" name="yardage" value="${form.yardage }"/>
	<span style="color: red; font-weight: 900">${errors.yardage }</span>
	<br/>
		fiber	：<input type="text" name="fiber" value="${form.fiber }"/>
	<span style="color: red; font-weight: 900">${errors.fiber }</span>
	<br/>
		recommended_hook_size	：<input type="text" name="recommended_hook_size" value="${form.recommended_hook_size }"/>
	<span style="color: red; font-weight: 900">${errors.recommended_hook_size }</span>
	<br/>
		recommended_needle_size	：<input type="text" name="recommended_needle_size" value="${form.recommended_needle_size }"/>
	<span style="color: red; font-weight: 900">${errors.recommended_needle_size }</span>
	<br/>
		name	：<input type="text" name="name" value="${form.name }"/>
	<span style="color: red; font-weight: 900">${errors.name }</span>
	<br/>
		manufacturer	：<input type="text" name="manufacturer" value="${form.manufacturer }"/>
	<span style="color: red; font-weight: 900">${errors.manufacturer }</span>
	<br/>
	<input type="submit" value="Update yarn"/>
</form>
  </body>
</html>
