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
  <h1>Update Entity</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	author_id    :<input type="text" name="author_id" value="${pattern_author.author_id }" disabled/>
	<br/>
	
	full_name：<input type="text" name="full_name" value="${pattern_author.full_name }" disabled />
	<br/>
	language	：<input type="text" name="language" value="${pattern_author.language }" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/Entity1ServletCreate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="username" value="${pattern_author.author_id }"/>
	Password：<input type="password" name="password" value="${form.full_name }"/>
	<span style="color: red; font-weight: 900">${errors.full_name }</span>
	<br/>
	Email	：<input type="text" name="email" value="${form.language }"/>
	<span style="color: red; font-weight: 900">${errors.language }</span>
	<br/>
	<input type="submit" value="Update pattern_author"/>
</form>

</body>
</html>
