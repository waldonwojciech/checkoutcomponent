insert into product(name, price, id) values ('A',40.00,'1');
insert into product(name, price, id) values ('B',10.00,'2');
insert into product(name, price, id) values ('C',30.00,'3');
insert into product(name, price, id) values ('D',25.00,'4');

insert into discount(discount_amount, id) values (50.00, '1');
insert into discount(discount_amount, id) values (5.00, '2');
insert into discount(discount_amount, id) values (60.00, '3');
insert into discount(discount_amount, id) values (10.00, '4');

insert into discount_products(discount_id, id, products) values ('1', '1', 3);
insert into discount_products(discount_id, id, products) values ('2', '2', 2);
insert into discount_products(discount_id, id, products) values ('3', '3', 4);
insert into discount_products(discount_id, id, products) values ('4', '4', 2);