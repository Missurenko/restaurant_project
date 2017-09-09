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

INSERT INTO product (name,description,price_for_sale,category,text)
VALUES ( 'Barbecue','100г свинина',300,2,'Дуже смачне м"ясо свини, зроблене з тазобедреної частини замочене в красному вині ');

INSERT INTO product (name,description,price_for_sale,category,text)
VALUES ( 'Soup with potatoes','110г',70,0,'Суп який приготвлений з овощів та курки. запралене картоплею');

INSERT INTO product (name,description,price_for_sale,category,text)
VALUES ( 'Vareniki','200г',100,1, 'Українські вареники з сметаною');

INSERT INTO product (name,description,price_for_sale,category,text)
VALUES ( 'ketchup','100g',10,1, 'Made on real tomatoes');

INSERT INTO product (name,description,price_for_sale,category,text)
VALUES ('Chicken cabbage rolls','118g',50,1, '%%');

INSERT INTO product (name,description,price_for_sale,category,text)
VALUES ( 'boiled rice','150g',50,1, '%%');

INSERT INTO product (name,description,price_for_sale,category,text)
VALUES ( 'Pilaf with mushrooms','150g',100,1, '%%');


INSERT INTO material_for_product (product_id, material_id) VALUES (1, 1);
INSERT INTO material_for_product (product_id, material_id) VALUES (2, 2);
INSERT INTO material_for_product (product_id, material_id) VALUES (3, 2);


INSERT INTO users ( email,password,name,role)
VALUES ( 'user@mail.com','$2a$10$PgBb/VbejOXpdopzGU3AquVu9LDr9PhQ0fcBiGIYsVQeKB.p/paQm',
'Username',1);
-- 10000,'2015-05-05 10:30:00',0

INSERT INTO users ( email,password,name,role)
VALUES ( 'admin@mail.com','$2a$10$8IHi8NJot3CY5BDlHrivr.cVMJwtznYTNli3p7GcgwOtsF8VxgMWK',
'Administrator',0);
-- ,15000,'2014-05-05 10:30:00',1

INSERT INTO checks ( position,date_pay,summa,email,name,phone,user_id)
VALUES ( 1,'2017-05-05 10:30:00',600,'user@mail.com','Bob','80675698654',1);

INSERT INTO checks ( position,date_pay,summa,email,name,phone,user_id)
VALUES ( 2,'2017-05-05 10:30:00',1000,'user@mail.com','Bob','80675698654',1);

INSERT INTO product_in_check (check_id, product_id) VALUES (1, 1);
INSERT INTO product_in_check (check_id, product_id) VALUES (1, 2);

INSERT INTO product_in_check (check_id, product_id) VALUES (2, 1);
INSERT INTO product_in_check (check_id, product_id) VALUES (2, 2);
INSERT INTO product_in_check (check_id, product_id) VALUES (2, 3);