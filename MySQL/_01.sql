-- INSERT INTO ... VALUES(.., ..), (.., ..) -> şeklinde birden fazla satırı aynı anda ekleyebiliriz.

-- CREATE TABLE cats(name VARCHAR(50) DEFAULT 'unnamed', age INT NOT NULL);

-- CREATE TABLE cats(name VARCHAR(50) PRIMARY KEY AUTO_INCREMENT, age INT NOT NULL);

-- SELECT cat_Id AS id, name AS Cat_Name FROM cats;

-- UPDATE cats SET breed='Shorthair' WHERE cat_Id=3;

-- create table if not exists shirts_db(shirt_id INTEGER PRIMARY KEY AUTO_INCREMENT, article VARCHAR(50), color VARCHAR(30), shirt_size VARCHAR(5), last_worn INTEGER);
-- INSERT INTO shirts_db(article, color, shirt_size, last_worn) VALUES('t-shirt', 'white', 'S', 10),
-- ('t-shirt', 'green', 'S', 200),
-- ('polo shirt', 'black', 'M', 10),
-- ('tank top', 'blue', 'S', 50),
-- ('t-shirt', 'pink', 'S', 0),
-- ('polo shirt', 'red', 'M', 5),
-- ('tank top', 'white', 'S', 200),
-- ('tank top', 'blue', 'M', 15);
-- SELECT article, color FROM shirts_db;
-- SELECT article, color, shirt_size, last_worn FROM shirts_db WHERE shirt_size='M';


-- -------------- book_data.sql dosyasını çalıştırdıktan sonra buraya geç --------------

-- SELECT CONCAT("My", "S", "QL");
-- SELECT CONCAT_WS(', ', 'veri 1', 'veri 2', 'veri 3');

-- SELECT SUBSTR('Hello World', 1, 4);
-- SELECT SUBSTRING('Hello World', 7);
-- SELECT SUBSTRING('Hello World', -5);
-- SELECT SUBSTRING('Hello World' FROM 2 FOR 5);
-- SUBSTRING() == SUBSTR();
-- SELECT REPLACE('Hello World', 'Hell', '%$#@');
-- SELECT REVERSE('chicken nuggets');
-- SELECT CHAR_LENGTH('asdfghjkl'); -> char sayısını döner.
-- SELECT LENGTH('asdfghjkl') -> byte sayısını döner.
-- SELECT UPPER('hello');
-- UPPER() == UCASE();
-- SELECT LOWER('HELLO');
-- LOWER() == LCASE();
-- SELECT INSERT('Hello Bobby', 6, 0, 'There'); -> buradaki 0 replace edilecek char sayısı, 6 ise index
-- SELECT INSERT('Hello Bobby', 7, 6, 'There');
-- SELECT LEFT('omghahahlol', 3);
-- SELECT RIGHT('omghahalol', 3);
-- SELECT REPEAT('ha', 4);
-- SELECT TRIM('   ha   ');
-- SELECT TRIM(LEADING 'x' FROM 'xxxbarxxx');
-- SELECT TRIM(BOTH 'x' FROM 'xxxbarxxx');
-- SELECT TRIM(TRAILING 'x' FROM 'xxxbarxxx');


-- INSERT INTO books
--    (title, author_fname, author_lname, released_year, stock_quantity, pages)
--    VALUES ('10% Happier', 'Dan', 'Harris', 2014, 29, 256), 
--           ('fake_book', 'Freida', 'Harris', 2001, 287, 428),
--           ('Lincoln In The Bardo', 'George', 'Saunders', 2017, 1000, 367);

-- SELECT DISTINCT author_lname FROM books;
-- SELECT DISTINCT author_fname, author_lname FROM books;

-- SELECT book_id, author_fname, author_lname FROM books ORDER BY author_lname DESC;
-- SELECT book_id, author_fname, author_lname FROM books ORDER BY 2; -> select'te verilen 2. column'a göre sırala demek.
-- SELECT book_id, author_fname, author_lname, released_year FROM books ORDER BY author_lname, released_year;
-- SELECT book_id, author_fname, author_lname, released_year FROM books ORDER BY author_lname DESC, released_year ASC;
-- SELECT CONCAT(author_fname, ' ', author_lname) AS author FROM books ORDER BY author;
-- SELECT book_id, author_fname, author_lname, released_year FROM books ORDER BY author_lname, released_year LIMIT 5;
-- SELECT book_id, author_fname, author_lname, released_year FROM books ORDER BY author_lname, released_year LIMIT 2,5;
-- SELECT title, author_fname, author_lname FROM books WHERE author_fname LIKE '%da%'; --> regEx karşılığı .*da.*
-- SELECT title, author_fname, author_lname FROM books WHERE author_fname LIKE 'da__'; --> regEx karşılığı da..

-- SELECT COUNT(*) AS total FROM books; -> null değerleri de sayar.
-- SELECT COUNT(author_fname) FROM books; -> null değerleri saymaz.
-- SELECT COUNT(DISTINCI author_fname) FROM books; 

-- SELECT author_lname FROM books group by author_lname; -> bellekte depolar ama bize göstermez.
-- SELECT author_lname, COUNT(title) FROM books group by author_lname;

-- SELECT MIN(released_year) FROM books;
-- SELECT MAX(author_lname) FROM books;

-- SELECT * FROM books WHERE pages = (SELECT MIN(pages) FROM books);

-- SELECT author_lname, author_fname, COUNT(title) FROM books GROUP BY author_fname, author_lname;

-- SELECT SUM(pages) FROM books;

-- SELECT AVG(pages) FROM books;


-- ---------------------------------------------
-- CREATE TABLE people (name VARCHAR(45), birthdate DATE, birthtime TIME, birthdt DATETIME);

-- DESC people;

-- INSERT INTO people(name, birthdate, birthtime, birthdt) values('Elton', '2000-12-25', '13:55:48', '2000-12-25 13:55:48');
-- INSERT INTO people (name, birthdate, birthtime, birthdt)
-- VALUES ('Lulu', '1985-04-11', '9:45:10', '1985-04-11 9:45:10');
 
-- INSERT INTO people (name, birthdate, birthtime, birthdt)
-- VALUES ('Juan', '2020-08-15', '23:59:00', '2020-08-15 23:59:00');

-- SELECT CURTIME();
-- CURTIME() == CURRENT_TIME()
-- SELECT CURDATE();
-- CURDATE() == CURRENT_DATE()
-- SELECT NOW();
-- NOW() == CURRENT_TIMESTAMP()

-- datetime ve date için --
-- SELECT name, DAY(birthdate) FROM people;
-- DAYOFMONTH() == DAY()
-- DAYOFYEAR()
-- DAYOFWEEK()
-- MONTHNAME()
-- WEEK()
-- YEAR()

-- datetime ve time için --
-- HOUR()
-- MINUTE()
-- SECOND()

-- datetime için --
-- DATE()
-- TIME()

-- SELECT DATE_FORMAT(birthdate, '%b') FROM people;
-- SELECT DATE_FORMAT(birthdate, '%W %b %D') FROM people;
-- SELECT TIME_FORMAT(birthtime, '%H.%i') FROM people;
-- SELECT birthdt, DATE_FORMAT(birthdt, 'BORN ON: %r') FROM people;

-- datetime ve date için --
-- SELECT DATEDIFF(CURDATE(), birthdate) FROM people;
-- SELECT DATE_ADD(birthdate, INTERVAL 2 DAY) from people;
-- SELECT DATE_SUB(birthdate, INTERVAL 3 YEAR) from people;

-- datetime ve time için --
-- SELECT TIMEDIFF(CURDATE(), birthtime) FROM people;
-- SELECT TIME_ADD(birthtime, INTERVAL 2 secons) from people;
-- SELECT TIME_SUB(birthtime, INTERVAL 3 hour) from people;

-- SELECT NOW() - INTERVAL 21 YEAR

-- CREATE TABLE captions(text varchar(150),
-- created_at DATETIME default CURRENT_TIMESTAMP, updated_at DATETIME ON UPDATE CURRENT_TIMESTAMP) -> update ile satırın herhangi bir column'unu değiştirdiğimizde otomatik olarak updated_at 
																																								-- column'u da güncellenir.

-- SELECT title, author_fname, author_lname FROM books WHERE author_fname NOT LIKE '%da%';

-- SELECT * FROM books WHERE author_lname='Eggers' AND released_year > 2010;
-- SELECT * FROM books WHERE author_lname='Eggers' && released_year > 2010;

-- SELECT * FROM books WHERE author_lname='Eggers' OR released_year > 2010;
-- SELECT * FROM books WHERE author_lname='Eggers' || released_year > 2010;

-- SELECT * FROM books WHERE  released_year BETWEEN 2000 AND 2015;
-- SELECT * FROM books WHERE  released_year NOT BETWEEN 2000 AND 2015;

-- SELECT * FROM people WHERE birthdate < '2005-01-01';
-- SELECT CAST('09:00:00' AS TIME);

-- SELECT title, author_lname FROM books WHERE author_lname IN ('Carver', 'Lahiri', 'Smith');
-- SELECT title, author_lname FROM books WHERE author_lname NOT IN ('Carver', 'Lahiri', 'Smith');

-- SELECT title, released_year, CASE
--					WHEN released_year >= 2000 THEN 'Modern Lit'
--                    ELSE '20th Century Lit'
--				END 
--               as GENRE
--			FROM books;

-- SELECT * FROM books WHERE author_lname IS NULL;
-- SELECT * FROM books WHERE author_lname IS NOT NULL;

-- CREATE TABLE contacts(name VARCHAR(45) NOT NULL, phone VARCHAR(15) NOT NULL UNIQUE);

-- CREATE TABLE partiers(name VARCHAR(45), age INT CHECK (age > 18));

-- CREATE TABLE partiers2(name VARCHAR(45), age INT, CONSTRAINT age_over_18 CHECK (age > 18));

-- CREATE TABLE companies(supplier_id INT AUTO_INCREMENT, name VARCHAR(45) NOT NULL, address VARCHAR(255) NOT NULL, PRIMARY KEY(supplier_id) CONSTRAINT name_address UNIQUE (name, address));

-- CREATE TABLE houses(purchase_price INT NOT NULL, sale_price INT NOT NULL, CONSTRAINT sprice_gt_pprice CHECK(sale_price >= purchase_price));

-- ALTER TABLE companies ADD COLUMN city VARCHAR(25);

-- ALTER TABLE companies RENAME COLUMN name TO biz_name;

-- ALTER TABLE companies DROP COLUMN city;
-- ALTER TABLE companies DROP city;

-- ALTER TABLE companies RENAME TO companies;
-- RENAME TABLE companies TO suppliers;

-- ALTER TABLE suppliers MODIFY biz_name VARCHAR(100);
-- ALTER TABLE suppliers MODIFY biz_name VARCHAR(100) DEFAULT 'unkown';

-- ALTER TABLE suppliers CHANGE biz_name name VARCHAR(50) NOT NULL;

-- ALTER TABLE houses ADD CONSTRAINT 'positive_pprice' CHECK (purchase_price >= 0);

-- ALTER TABLE houses DROP CONSTRAINT positive_pprice; -> constraint'i siler.

