<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Entity</title>
    
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
  <h1>Delete Entity</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/PatternAuthorServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
		<input type="hidden" name="author_id" value="${pattern_author.author_id }"/>
	Author ID    :<input type="text" name="author_id" value="${pattern_author.author_id }" disabled/>
	<br/>
	Full Name：<input type="text" name="full_name" value="${pattern_author.full_name }"disabled/>
	<br/>
	Language ：<input type="text" name="user_language" value="${pattern_author.user_language }"disabled/>
	<br/>
	Date Joined ：<input type="text" name="date_joined" value="${pattern_author.date_joined}"disabled/>
	<br/>
	<input type="submit" value="Delete Pattern Author"/>
</form>

</body>
</html>
