<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Create Pattern Author</title>
    
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
  <h1> Create Pattern Author</h1>
<form action="<c:url value='/PatternAuthorServletCreate'/>" method="post">
	Author ID    :<input type="text" name="author_id" value="${form.author_id }"/>
	<span style="color: red; font-weight: 900">${errors.author_id }</span>
	<br/>
	Full Name：<input type="text" name="full_name" value="${form.full_name }"/>
	<span style="color: red; font-weight: 900">${errors.full_name }</span>
	<br/>
	Language：<input type="text" name="language" value="${form.language }"/>
	<span style="color: red; font-weight: 900">${errors.language }</span>
	<br/>
	Date Joined：<input type="text" name="date_joined" value="${form.date_joined}"/>
	<span style="color: red; font-weight: 900">${errors.date_joined}</span>
	<br/>
	<input type="submit" value="Create pattern_author"/>
</form>
  </body>
</html>
