-- CREATE TABLE customers (
--    id INT PRIMARY KEY AUTO_INCREMENT,
--     first_name VARCHAR(50),
--     last_name VARCHAR(50),
--     email VARCHAR(50)
-- );

-- CREATE TABLE orders (
--     id INT PRIMARY KEY AUTO_INCREMENT,
--     order_date DATE,
--     amount DECIMAL(8 , 2 ),
--     customer_id INT,
--     FOREIGN KEY (customer_id)
--         REFERENCES customers (id)
-- );

-- INSERT INTO customers (first_name, last_name, email) 
-- VALUES ('Boy', 'George', 'george@gmail.com'),
--        ('George', 'Michael', 'gm@gmail.com'),
--        ('David', 'Bowie', 'david@gmail.com'),
--        ('Blue', 'Steele', 'blue@gmail.com'),
--        ('Bette', 'Davis', 'bette@aol.com');
--        
--        
-- INSERT INTO orders (order_date, amount, customer_id)
-- VALUES ('2016-02-10', 99.99, 1),
--        ('2017-11-11', 35.50, 1),
--        ('2014-12-12', 800.67, 2),
--        ('2015-01-03', 12.50, 2),
--        ('1999-04-11', 450.25, 5);

-- SELECT o.id, (SELECT c.email FROM customers c WHERE o.customer_id = c.id), o.order_date, o.amount FROM orders o;

-- SELECT o.id, c.email, c.first_name, c.last_name, order_date, amount FROM orders o INNER JOIN customers c ON o.customer_id = c.id;

-- INNER JOIN == JOIN
-- INNER JOIN demek küme kesişimi demektir.
-- LEFT JOIN hem soldaki hem de kesişimdekileri dahil eder.
-- RIGHT JOIN hem sağdaki hem de kesişimdekileri dahil eder.

-- ON kullanmazsak kartezyen çarpım olur (cross join)

-- SELECT c.email, COUNT(*) FROM orders o JOIN customers c ON o.customer_id = c.id GROUP BY o.customer_id;

-- SELECT 
--     first_name, last_name, SUM(amount) AS total
-- FROM
--     customers
--         JOIN
--     orders ON orders.customer_id = customers.id
-- GROUP BY first_name , last_name
-- ORDER BY total;

-- SELECT first_name, last_name, order_date, amount FROM customers LEFT JOIN orders ON orders.customer_id = customers.id;
--  SELECT first_name, last_name, order_date, amount FROM orders RIGHT JOIN customers ON orders.customer_id = customers.id;


-- CREATE TABLE customers (
--    id INT PRIMARY KEY AUTO_INCREMENT,
--     first_name VARCHAR(50),
--     last_name VARCHAR(50),
--     email VARCHAR(50)
-- );
-- CREATE TABLE orders (
--     id INT PRIMARY KEY AUTO_INCREMENT,
--     order_date DATE,
--     amount DECIMAL(8 , 2 ),
--     customer_id INT,
--     FOREIGN KEY (customer_id)
--         REFERENCES customers (id) ON DELETE CASCADE   -> müşteri silindiğinde siparişleri de silinir.
-- );