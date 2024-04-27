-- CREATE VIEW full_reviews AS SELECT title, released_year, genre, rating, first_name, last_name FROM reviews 
-- 		JOIN series ON series.id = reviews.series_id JOIN reviewers ON reviewers.id = reviews.reviewer_id;

-- VIEW'lerde insert delete işlemi yapılabilir ancak asıl tabloya etki etmez ve asıl tablodaki satırları silemeyiz.

--  CREATE OR REPLACE VIEW full_reviews AS SELECT title, released_year, genre, rating, first_name, last_name FROM reviews 
-- 		JOIN series ON series.id = reviews.series_id JOIN reviewers ON reviewers.id = reviews.reviewer_id;


-- ALTER VIEW full_reviews AS SELECT * FROM series ORDER BY released_year;

-- DROP VIEW full_reviews;

-- SELECT title, AVG(rating) FROM full_reviews GROUP BY title HAVING title = 'Archer';

-- WHERE -> gruplamadan önce filtreler. HAVING -> grupladıktan sonra filtreler.

-- SELECT title, AVG(rating) FROM full_reviews GROUP BY title WITH ROLLUP; -- > son satırda hepsinin ortalamasını verir.
-- SELECT title, COUNT(rating) FROM full_reviews GROUP BY title WITH ROLLUP; -- > son satırda hepsinin toplamını verir.
-- SELECT released_year, genre, AVG(rating) FROM full_reviews GROUP BY released_year, genre WITH ROLLUP; -- > her bir grubun ve grupların bütününün ortalamalarını verir.
  