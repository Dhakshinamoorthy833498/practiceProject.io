-- View Movie List Admin
select * from moviecruiser.movie_list;


-- View Movie List Customer 
select * from moviecruiser.movie_list where mo_active='1'and mo_date_of_launch < (select(curdate()));

-- Edit Movie List

select * from moviecruiser.movie_list where mo-id='1';


update moviecruiser.movie_list
set 
mo.title='Jumper',
mo_gross='4685123489',
mo_active='1',
mo_date_of_launch='2022-02-21',
mo_genre='Science Fiction',
mo_has_teaser='1';


-- Add to Favorites
INSERT INTO `moviecruiser`.`favorites` (`fv_us_id`, `fv_mo_id`) VALUES ('1', '1');
INSERT INTO `moviecruiser`.`favorites` (`fv_us_id`, `fv_mo_id`) VALUES ('1', '3');
INSERT INTO `moviecruiser`.`favorites` (`fv_us_id`, `fv_mo_id`) VALUES ('1', '2');

-- view Favorites
 
 select mo_title, mo_gross, mo_active, mo_date_of_launch, mo_genre, mo_has_teaser from moviecruiser.movie_list
 inner join moviecruiser.favorites on fv_mo_id=mo_id
 where fv_us_id=1;
 
 select count(mo_id) as Total_Favorites from moviecruiser.movie_list
inner join moviecruiser.favorites on fv_mo_id=mo_id
 where fv_us_id=1;
 
 -- Remove Movie from Faorites
 delete from moviecruiser.favorites where fv_us_id=1 and fv_mo_id=1;
 