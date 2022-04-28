<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Read crochet_pattern Output</title>
    
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
  <h1>Read Crochet Pattern Output</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	Pattern ID    :<input type="text" name="pattern_id" value="${crochet_pattern.pattern_id }" disabled/>
	<br/>
	Pattern Link   :<input type="text" name="pattern_link" value="${crochet_pattern.pattern_link }" disabled/>
	<br/>
	Hook Size ：<input type="text" name="hook_size" value="${crochet_pattern.hook_size }" disabled/>
	<br/>
	Author ID	：<input type="text" name="author_id" value="${crochet_pattern.author_id }" disabled/>
	<br/>
	Category	：<input type="text" name="category" value="${crochet_pattern.category }" disabled/>
	<br/>
</form>

<button onclick="window.location.href='<c:url value='/jsps/main.jsp'/>'">Continue</button>
</body>
</html>
