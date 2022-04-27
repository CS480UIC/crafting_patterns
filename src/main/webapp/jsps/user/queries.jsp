<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="">
    
    <title>body</title>
    
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
    <h1>Welcome to the Demo</h1>
    <br>    <br>
    
    <a href="<c:url value='/findAll'/>" target="body">Please list all the user in the table</a>&nbsp;&nbsp;
    <br>    <br>
    
    <a href="<c:url value='/patternAuthorServ'/>" target="body">SELECT * from pattern_author
  WHERE date_joined >= '2002-01-02'
  ORDER BY author_id;</a>&nbsp;&nbsp;
    <br>    <br>
    
    <a href="<c:url value='Yarnread'/>" target="body">Select yarn_id, recommended_needle_size, fiber
	from yarn
    group by yarn_id
    having Sum(recommended_hook_size > 1);</a>&nbsp;&nbsp;
    <br>    <br>
    
    <a href="<c:url value='/cp'/>" target="body"> SELECT * from crochet_pattern cp
    WHERE hook_size > 
      (SELECT AVG(hook_size)
      FROM crochet_pattern
      WHERE hook_size = cp.hook_size);</a>&nbsp;&nbsp;
    <br>    <br>
    
    <a href="<c:url value='/findAll'/>" target="body">Please list all the user in the table</a>&nbsp;&nbsp;
 
    
  </body>
</html>
