<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>knitting_pattern_yarn Create</title>
    
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
  <h1>knitting_pattern_yarn Create</h1>
<form action="<c:url value='/Entity1ServletCreate'/>" method="post">
	pattern_id    :<input type="text" name="pattern_id" value="${form.pattern_id }"/>
	<span style="color: red; font-weight: 900">${errors.pattern_id }</span>
	<br/>

	yarn_id	：<input type="text" name="yarn_id" value="${form.yarn_id }"/>
	<span style="color: red; font-weight: 900">${errors.yarn_id }</span>
	<br/>
	<input type="submit" value="Create knitting_pattern_yarn"/>
</form>
  </body>
</html>
