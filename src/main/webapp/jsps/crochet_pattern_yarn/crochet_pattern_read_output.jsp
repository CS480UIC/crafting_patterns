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
  <h1>Read crochet_pattern Output</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	pattern_link    :<input type="text" name="pattern_link" value="${crochet_pattern.pattern_link }" disabled/>
	<br/>
	pattern_id    :<input type="text" name="pattern_id" value="${crochet_pattern.pattern_id }" disabled/>
	<br/>
	hook_size：<input type="text" name="hook_size" value="${crochet_pattern.hook_size }" disabled/>
	<br/>
	pattern_author	：<input type="text" name="pattern_author" value="${crochet_pattern.pattern_author }" disabled/>
	<br/>
	category	：<input type="text" name="category" value="${crochet_pattern.pattern_author }" disabled/>
	<br/>
</form>

<button onclick="window.location.href='<c:url value='/jsps/main.jsp'/>'">Continue</button>
</body>
</html>
