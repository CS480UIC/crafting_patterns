-- Minimum N simple queries. 
-- A simple query searches data in one table using logic operators in the condition, and orders the result by a particular column.

-- SIMPLE QUERIES
SELECT* from knitting_patterns
  WHERE category = shawl
  ORDER BY pattern_id;
  
SELECT * from pattern_author
  WHERE date_joined >= '2002-01-02'
  ORDER BY author_id;
 
-- AGGREGATE QUERIES
-- Minimum N aggregate queries or queries with functions. 
--   An aggregate query groups data in one table and applies an aggregate function (https://go.uic.edu/cs480/chapter/3/section/18)
--   X From the N queries, at least one should use a numeric function.
--   From the N queries, at least one should use a string function.
--   X From the N queries, at least one should use a date and time function.
--   From the N queries, at least one should group rows with identical values into a set of summary rows and filter group results (GROUP BY and HAVING clauses).

SELECT COUNT(*) 
  FROM pattern_author 
  WHERE DAY(date_joined) = 30;

SELECT COUNT(*) from pattern_author
  WHERE date_joined >= '2010-01-01'
  ORDER BY author_id;
  
SELECT MAX(needle_size) from knitting_pattern
	where category = "Helicopter";

Select yarn_id, recommended_needle_size, fiber
	from yarn
    group by yarn_id
    having Sum(recommended_hook_size > 1);
  

-- COMPLEX QUERIES
-- Minimum N complex queries.
--   A complex query searches data in two or more tables.
--   X From the N queries, at least one should use a join (any type of join).
--   From the N queries, at least one should use a correlated subquery (without EXIST).
--   X From the N queries, at least one should use a correlated subquery that uses the EXIST clause

  
 SELECT * from knitting_pattern
    LEFT JOIN crochet_pattern
    ON knitting_pattern.author_id = crochet_pattern.author_id;
    
 
  
 SELECT * from crochet_pattern cp
    WHERE hook_size > 
      (SELECT AVG(hook_size)
      FROM crochet_pattern
      WHERE hook_size = cp.hook_size);
     
      
Select author_id, full_name
	from pattern_author p
    where EXISTS
    (Select *
    from knitting_pattern
    where author_id = p.author_id);
    
-- kiara my queen          
Select author_id, full_name
	from pattern_author p
    where NOT EXISTS
    (Select *
    from knitting_pattern
    where author_id = p.author_id);
  
