
/* MENU ITEM DETAILS */
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('1', 'Sandwich', '99', '1', '2020-02-01', 'MainCourse', '1');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('2', 'Burger', '129', '1', '2019-12-23', 'MainCourse', '0');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('3', 'Pizza', '149', '1', '2020-01-04', 'MainCourse', '0');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('4', 'French Fries', '57', '0', '2021-02-12', 'Starter', '1');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('5', 'chocolate Brownie', '35', '1', '2022-09-21', 'Dessert', '1');


/* User Details */

insert into user(us_id,us_name) values (1,'Siva');
insert into user(us_id,us_name) values (2,'Ajay');




insert into cart(ct_us_id,ct_me_id) values ('1','1');
insert into cart(ct_us_id,ct_me_id) values ('1','3');
insert into cart(ct_us_id,ct_me_id) values ('1','5');


-- view Menu Item List Admin (TYUC001) 
select * from truyum.menu_item;


-- View Menu Item List Customer (TYUC002)
select * from truyum.menu_item where me_active='1' and me_date_of_launch  > (select(curdate()));


-- Edit Menu Item (TYUC003)

select * from truyum.menu_item where me_id='1';
update truyum.menu_item set 
me_name='Biryani',
 me_price='100',
 me_active='1',
 me_date_of_launch='2022-02-21',
 me_category='Meals',
 me_free_delivery='1'
 where me_id='1';
 
 -- Add to Cart (TYUC004)
 
 insert into cart(ct_us_id,ct_me_id) values ('1','1');
insert into cart(ct_us_id,ct_me_id) values ('1','3');
insert into cart(ct_us_id,ct_me_id) values ('1','5');
 
 
 -- View Cart (TYUC005)
 select me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery from truyum.menu_item
 inner join truyum.cart on ct_me_id=me_id
 where ct_us_id=1;
 
 select sum(me_price) as Total from truyum.menu_item
 inner join truyum.cart on ct_me_id=me_id
 where ct_us_id=1;
 
-- Remove Item from Cart (TYUC006)
 
delete from truyum.cart where ct_us_id=1 and ct_me_id=1;

 select sum(me_price) as Total from truyum.menu_item
 inner join truyum.cart on ct_me_id=me_id
 where ct_us_id=1;