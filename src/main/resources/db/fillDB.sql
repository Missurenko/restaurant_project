-- DELETE FROM comments;
-- ALTER SEQUENCE comments_id_seq RESTART WITH 1;
-- DELETE FROM orders_products;
-- DELETE FROM orders;
-- ALTER SEQUENCE orders_id_seq RESTART WITH 1;
-- DELETE FROM users;
-- ALTER SEQUENCE users_id_seq RESTART WITH 1;
-- DELETE FROM products;
-- ALTER SEQUENCE products_id_seq RESTART WITH 1;
--
-- INSERT INTO products (name, price, color, capacity, display, description)
-- VALUES ('iPhone 6', 650, 0, 64, '4,7 inch', NULL);
-- INSERT INTO products (name, price, color, capacity, display, description)
-- VALUES ('iPhone 7', 700, 1, 128, '4,7 inch', NULL);
-- INSERT INTO products (name, price, color, capacity, display, description)
-- VALUES ('iPhone 8', 750, 2, 256, '4,7 inch', NULL);
-- INSERT INTO products (name, price, color, capacity, display, description)
-- VALUES ('iPhone 6 Plus', 700, 0, 256, '5,5 inch', NULL);
-- INSERT INTO products (name, price, color, capacity, display, description)
-- VALUES ('iPhone 7 Plus', 800, 2, 64, '5,5 inch', NULL);
-- INSERT INTO products (name, price, color, capacity, display, description)
-- VALUES ('iPhone 8 Plus', 900, 1, 128, '5,5 inch', NULL);
--
-- INSERT INTO users (email, password, name, role)
-- VALUES ('admin@mail.com', '$2a$10$8IHi8NJot3CY5BDlHrivr.cVMJwtznYTNli3p7GcgwOtsF8VxgMWK', 'Administrator', 0);
-- INSERT INTO users (email, password, name, role)
-- VALUES ('user@mail.com', '$2a$10$PgBb/VbejOXpdopzGU3AquVu9LDr9PhQ0fcBiGIYsVQeKB.p/paQm', 'Username', 1);
--
-- INSERT INTO orders (total_amount, datetime, name, email, phone, address, user_id)
-- VALUES (1500, '2017-06-01 14:00:00', 'Олег', 'oleg@gmail.com', '095664356273', 'ул. Дорогожицкая, 1', 2);
-- INSERT INTO orders (total_amount, datetime, name, email, phone, address, user_id)
-- VALUES (2200, '2017-07-23 18:00:00', 'Аня', 'anya@gmail.com', '095664357685', 'ул. Артема, 30', null);
--
-- INSERT INTO orders_products (order_id, product_id) VALUES (1, 1);
-- INSERT INTO orders_products (order_id, product_id) VALUES (1, 5);
-- INSERT INTO orders_products (order_id, product_id) VALUES (2, 2);
-- INSERT INTO orders_products (order_id, product_id) VALUES (2, 3);
-- INSERT INTO orders_products (order_id, product_id) VALUES (2, 6);
--
-- INSERT INTO comments (product_id, author, datetime, text, rating)
-- VALUES (1, 'Сергей', '2016-12-28 13:00:00', 'Отличный девайс. Пользуюсь уже около года. Никаких замечаний', 5);
-- INSERT INTO comments (product_id, author, datetime, text, rating)
-- VALUES (4, 'Анна', '2017-03-12 15:00:00', 'Возникли проблемы на второй месяц использования. Пропадает зук в динамиках', 3);
-- INSERT INTO comments (product_id, author, datetime, text, rating)
-- VALUES (1, 'Инна', '2017-04-05 10:30:00', 'Хоший телефон. Единственный недостаток это цена :(', 4);


-- START


DELETE FROM material;
ALTER SEQUENCE material_id_seq RESTART WITH 1;

INSERT INTO material ( price,name,provider,date_buy)
VALUES ( 650,'meet','myCompany','2017-04-05 10:30:00');

INSERT INTO material ( price,name,provider,date_buy)
VALUES ( 50,'potato','myCompany','2017-04-05 10:30:00');

INSERT INTO material ( price,name,provider,date_buy)
VALUES ( 90,'tomato','myCompany','2017-04-05 10:30:00');

INSERT INTO material ( price,name,provider,date_buy)
VALUES ( 100,'orange','myCompany','2017-04-05 10:30:00');

INSERT INTO product (name,description,price_for_sale,category)
VALUES ( 'Шашлик','100г свинина',300,2);

INSERT INTO product (name,description,price_for_sale,category)
VALUES ( 'Суп с картошкай','110г',70,0);

INSERT INTO product (name,description,price_for_sale,category)
VALUES ( 'Вареники','200г',100,1);

INSERT INTO material_for_product (product_id, material_id) VALUES (1, 1);
INSERT INTO material_for_product (product_id, material_id) VALUES (2, 2);
INSERT INTO material_for_product (product_id, material_id) VALUES (3, 2);



INSERT INTO checks ( position,date_pay)
VALUES ( 1,'2017-05-05 10:30:00');

INSERT INTO checks ( position,date_pay)
VALUES ( 2,'2017-05-05 10:30:00');

INSERT INTO product_in_check (check_id, product_id) VALUES (1, 1);
INSERT INTO product_in_check (check_id, product_id) VALUES (1, 2);

INSERT INTO product_in_check (check_id, product_id) VALUES (2, 1);
INSERT INTO product_in_check (check_id, product_id) VALUES (2, 2);
INSERT INTO product_in_check (check_id, product_id) VALUES (2, 3);

INSERT INTO role (name) VALUES (0);
INSERT INTO role (name) VALUES (1);

INSERT INTO users ( email,password,name,salary,date_start_work,sex,role_id)
VALUES ( 'user@mail.com','$2a$10$PgBb/VbejOXpdopzGU3AquVu9LDr9PhQ0fcBiGIYsVQeKB.p/paQm',
'Username',10000,'2015-05-05 10:30:00',0,1);

INSERT INTO users ( email,password,name,salary,date_start_work,sex,role_id)
VALUES ( 'admin@mail.com','$2a$10$8IHi8NJot3CY5BDlHrivr.cVMJwtznYTNli3p7GcgwOtsF8VxgMWK',
'Administrator',15000,'2014-05-05 10:30:00',1,2);
