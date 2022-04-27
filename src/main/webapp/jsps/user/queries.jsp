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
    
    <form action="<c:url value='/findAll'/>" method="post">

  	<p>Type an SQL statement:</p> <input type="text" id="textInput" name="JSPstatement"></div>
  	<input id="submit" type="submit"  value="Submit">
	</form>
    
        <h4>SIMPLE QUERIES</h4>
    
    <label id="01">SELECT * from knitting_pattern WHERE category = 'shawl' ORDER BY pattern_id;
</label>
    <br>    <br>
    

    <label id="02">SELECT * from pattern_author
  WHERE date_joined >= '2002-01-02'
  ORDER BY author_id;</label>
    <br>    <br>
    
    <h4>AGGREGATE QUERIES</h4>
    
    <label id="03">SELECT COUNT(*) 
  FROM pattern_author 
  WHERE DAY(date_joined) = 30;</label>

    <br>    <br>
        <label id="04">SELECT COUNT(*) from pattern_author
  WHERE date_joined >= '2010-01-01'
  ORDER BY author_id;</label>

    <br>    <br>
        <label id="05">SELECT MAX(needle_size) from knitting_pattern
	where category = "Helicopter";</label>

    <br>    <br>
        <label id="06">Select yarn_id, recommended_needle_size, fiber
	from yarn
    group by yarn_id
    having Sum(recommended_hook_size > 1);</label>

    <br>    <br>
        <h4>COMPLEX QUERIES</h4>
    
            <label id="07"> SELECT * from knitting_pattern
    LEFT JOIN crochet_pattern
    ON knitting_pattern.author_id = crochet_pattern.author_id;</label>

    <br>    <br>
 
 
         <label id="08"> SELECT * from crochet_pattern cp
    WHERE hook_size > 
      (SELECT AVG(hook_size)
      FROM crochet_pattern
      WHERE hook_size = cp.hook_size);</label>

    <br>    <br>
    
     
         <label id="09">Select author_id, full_name
	from pattern_author p
    where EXISTS
    (Select *
    from knitting_pattern
    where author_id = p.author_id);</label>

    <br>    <br>
    
     
         <label id="10">Select author_id, full_name
	from pattern_author p
    where NOT EXISTS
    (Select *
    from knitting_pattern
    where author_id = p.author_id);</label>

    <br>    <br>
 
 
    
  </body>
</html>
