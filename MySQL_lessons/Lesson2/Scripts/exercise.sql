 -- --------------------- 4 -- ------------------------------------------
/* 1) select distinct pr.maker from product pr where pr.maker not in 
(select pr.maker from product pr where pr.type = 'Laptop' ) and type = 'PC'; */

/* 2) select distinct pr.maker from product pr where  pr.maker >= all 
(select pr2.maker from product pr2 where not pr2.type = 'Laptop' ) and type = 'PC';  */

/* 3) select distinct maker from product where not maker = any (select maker from product where 
 type = 'Laptop') and type = 'PC'; */
 
/* 4)  select distinct maker from product where maker in (select maker from product 
where type = 'PC' ) and type = 'Laptop' order by maker; */

 /* 5) select distinct maker from product where not  maker != all (select maker from product 
where  type = 'PC' ) and type = 'Laptop' order by maker;  */

 /* 6) select distinct maker from product where maker = any (select maker from product 
where type = 'PC') and type = 'Laptop' order by maker; */

/* 7) -- select distinct maker from product where model in (select model from pc ) and type = 'PC'; 
 -- select distinct maker from product where model = any (select model from pc) and type = 'PC';
-- select distinct maker from product where not model = all (select model from pc) and type = 'PC';*/

/* 8) select cl.class, cl.country from classes cl where  class  in (select class from classes 
where cl.country = 'Ukraine') or cl.country = any (select country from classes); */

/* 9) select  outs.ship,outs.battle,bat.date from outcomes outs join battles bat on
bat.name = outs.battle and outs.ship in (select ship from outcomes where result = 'damaged')
and outs.ship in (select ship from outcomes where result = 'OK') order by outs.ship; */

/* 10) select count(pc.model) as counts from product pr ,pc pc where pc.model = pr.model and maker = 'A'; */
-- 11) select distinct pr.maker,pr.model  from product pr join pc pc where pr.type = 'PC' and pr.model not in (select model from pc );
-- 12) select distinct pr.model, lap.price from product pr join laptop lap on pr.model = lap.model and lap.price > all (select price from pc);


-- --------------------- 5 -- ------------------------------------------
-- 1) select distinct maker from product where exists (select pc.model from pc where pc.model = product.model) order by maker; 
-- 2) select pr.maker from product pr where exists (select pc.model from pc where pc.model = pr.model and pc.speed >= 750) order by maker;
/* 3) select distinct pr.maker from product pr where exists (select pc.model from pc where pc.model = pr.model and pc.speed >= 750) 
or exists (select lap.model from laptop lap where lap.model = pr.model and lap.speed >= 750) order by maker; */
 /* 4) select distinct pr.maker from product pr, printer  pt where pr.model = pt.model and  exists (select pc.model from pc, product pr2 where pc.model = pr2.model
 and pr.maker = pr2.maker having max(pc.speed)); */
/* 5) select distinct sh.name, sh.launched, cl.displacement from classes cl, ships sh where exists 
(select * from classes cl2 where cl2.class = sh.class and cl2.class = cl.class and cl.displacement > 35000 and type = 'bb' )
and  sh.launched >= 1922 order by sh.launched; */
-- 6) select sh.class from ships sh where exists (select outs.ship from outcomes outs where sh.name = outs.ship and outs.result = 'sunk');
-- 7) select distinct pr.maker from product pr where pr.type = 'Laptop' and exists (select pr.maker from product  pr2 where pr.maker = pr2.maker and pr2.type = 'Printer');
-- 8) select distinct pr.maker from product pr where pr.type = 'Laptop' and not exists (select pr.maker from product  pr2 where pr.maker = pr2.maker and pr2.type = 'Printer') order by pr.maker;


-- --------------------- 6 -- ------------------------------------------
-- 1) select 'Середня ціна', avg(lap.price) as AveragePrice from laptop lap; 
-- 2) select concat('Модель: ', pc.model) as Model, concat('Швидкість: ', pc.speed) as speed, concat('Оперативна память: ', pc.ram, ' Mb') as ram, concat('Жорсткий диск: ', pc.hd), concat('Дисковод: ', pc.cd) as cd, concat('Ціна: ', pc.price) as price from pc ;
-- 3) select inc.point,concat(year(inc.date), '.',month(inc.date),'.', day(inc.date)) as date, inc.inc from income inc;
-- 5) select pit.trip_no,pit.date,pit.ID_psg,concat('Ряд:',substring(pit.place,1,1)) as row, concat('Місце:',substring(pit.place,2)) as place from pass_in_trip pit;
-- 6) select tr.trip_no,tr.ID_comp,tr.plane, concat('from ',tr.town_from,' to ', tr.town_to) as plane_route,tr.time_out,tr.time_in from trip tr;

-- --------------------- 7 -- ------------------------------------------
-- 1) select pr.model,pr.price from  printer pr having max(pr.price);
-- 2) select lap.model,lap.speed from laptop lap where lap.speed < all (select pc.speed from pc );
-- 3) select pr.maker,pr.type, min(pt.price ) as MinPrice from product pr, printer pt where pr.model = pt.model and pt.color = 'y'; 
-- 4) select pr.maker, count(pr.model) as num from product pr where pr.type = 'PC' group by pr.maker having num >= 2;
-- 5) select avg(pc.hd) from product pr,pc where pc.model = pr.model and pr.maker in (select pr2.maker from product pr2 where pr.maker = pr2.maker and pr2.type = 'Printer');

-- 6) select count(tr.trip_no) as RoutesFromLondon, pit.date from trip tr, pass_in_trip pit where tr.town_from = 'London' and tr.trip_no = pit.trip_no group by pit.date;
-- 7) select  pit.date ,count(tr.trip_no) as RoutesToMoscow from trip tr, pass_in_trip pit where tr.town_to = 'Moscow'  and tr.trip_no = pit.trip_no group by date order by RoutesToMoscow desc;
/* 8) select a.country, a.numShips as ShipsNum, min(launched) as Year 
from (select country, count(*) as numShips, launched
 from classes join
 ships on classes.class = ships.class
 group by country, launched
 )as a join
 (select a.country, max(a.numShips) as numShips
from (select country, count(*) as numShips
 from classes  join
 ships on classes.class = ships.class
 group by country, launched
 ) as a
 group by country) as b
 on a.country = b.country and a.numShips = b.numShips
GROUP BY a.country, a.numShips;*/

 /* 9) select distinct bat.name, cl.country, count(sh.name) as num from classes cl join battles bat join ships sh join outcomes outs
where cl.class = sh.class and bat.name = outs.battle and sh.name = outs.ship group by cl.country, bat.name having num >= 2; */


-- --------------------- 8 -- ------------------------------------------
/* 1) select p1.maker, (select count(model) from product where type = 'pc' and maker = p1.maker) as PC,
(select count(model) from product where type = 'laptop' and maker = p1.maker) as Laptop,
(select count(model) from product where type = 'printer' and maker = p1.maker) as Printer from product p1 group by maker;*/
/* 2) select pr.maker, (select avg(lap.screen) from laptop lap, product pr2 where lap.model = pr2.model and pr2.maker = pr.maker) as Average 
from product pr, laptop where laptop.model = pr.model group by pr.maker ;*/
/* 3) select pr.maker , (select max(pc.price) from product pr2, pc where pc.model = pr2.model and pr.maker = pr2.maker) as MaxPrice
from product pr,pc where pc.model = pr.model group by pr.maker; */
/* 4) select pr.maker , (select min(pc.price) from product pr2, pc where pc.model = pr2.model and pr.maker = pr2.maker) as MaxPrice
from product pr,pc where pc.model = pr.model group by pr.maker; */
/* 5) select pc.speed, (select avg(pc2.price) from pc pc2 where pc.speed = pc2.speed) as AvgPrice
from pc where pc.speed > 600 group by pc.speed; */
/* 6) select distinct pr.maker, (select avg(pc.hd) from pc,product pr2 where pr2.model = pc.model and pr2.maker = pr.maker) as AvgHd
 from product pr, pc pc2 where pr.model = pc2.model and pr.maker in (select product.maker from product where product.type = 'Printer'); */

/* 7) select outs.ship, (select cl.displacement from classes cl, ships sh where cl.class = sh.class and sh.name = outs.ship ) as displacement,
(select cl2.numGuns from classes cl2, ships sh2 where cl2.class = sh2.class and sh2.name = outs.ship)  as numGuns
from outcomes outs where outs.battle = 'Guadalcanal'; */
/* 8) select outs.ship, (select cl.country from classes cl,ships sh where cl.class = sh.class and sh.name = outs.ship) as country,
(select cl2.numGuns from classes cl2, ships sh2 where cl2.class = sh2.class and sh2.name = outs.ship) as numGuns
from outcomes outs,ships  where outs.result = 'damaged' and outs.ship = ships.name; */

 -- --------------------- 9 -- ------------------------------------------
 use  labor_sql;
/* 1) select maker, model,  case type when 'PC' THEN CONCAT('yes (', cast((select count(*) from pc
join product pr2 using (model) where pr2.maker = pr.maker) as char), ')') else 'no' end as PC_Num from product pr;*/
-- 2) select o.point, o.date, inc, `out` from outcome_o o join income_o I using (point) where o.date = i.date;
/* 3) select distinct  cl.class,cl.type, cl.country, cl.numGuns, cl.bore, cl.displacement,
case when cl.numGuns = 8 then sh.name when cl.bore = 15 then sh.name when cl.displacement = 32000 then sh.name when cl.type = 'bb' then sh.name when cl.country = 'USA' then sh.name when sh.launched = 1915 then sh.name when cl.class = 'Kongo' then sh.name else 'No such ships' end as shipName 
 from classes cl, ships sh where sh.class = cl.class ; */
/* 4) select tr.trip_no, tr.ID_comp, tr.plane, tr.town_from, tr.town_to, case when timestampdiff(hour, tr.time_out, tr.time_in) < 0 
then 24 - hour(tr.time_out) + hour(tr.time_in) else timestampdiff(hour, tr.time_out, tr.time_in) end as TotalHours  from trip tr;*/

 -- --------------------- 10 -- ------------------------------------------
 /* 1) SELECT maker,product.model,product.type ,price FROM product, pc WHERE maker = 'B' UNION SELECT maker,product.model,product.type ,price FROM product, laptop WHERE maker = 'B' 
 UNION SELECT maker,product.model,product.type ,price FROM product, printer WHERE maker = 'B'*/
/* 2)select pr.type,pr.model, max(pc.price) as MaxPrice from product pr,pc where pr.model = pc.model 
union select pr.type,pr.model, max(lap.price) as MaxPrice from product pr,laptop lap where pr.model = lap.model
union select pr.type,pr.model, max(pt.price) as MaxPrice from product pr, printer pt where pr.model = pt.model; */
/* 3) select round(avg(price),2)from (select price from pc where model in (select model from product  where maker='A' and type='PC')
union all select price from laptop where model in (select model from product where maker='A' and type='Laptop') ) AS prod;*/
/* 4) select sh.name from ships sh union select o.ship from outcomes o where not exists (select name from ships where name = o.ship); */

/* 5) select class from ships sh  where not exists (select ship from outcomes where ship = sh.class) group by class having count(*) = 1 
union select ship from outcomes s  where exists(select class from Classes where class = s.ship )
and not exists (select class from ships where class = s.ship);*/

/* 6) select cl.class,count(sh.name) as numShips from ships sh, classes cl where cl.class = sh.class group by sh.class
union select o.ship, count(o.ship) from outcomes o where not exists (select name from ships where name = o.ship) group by 1; */

/* 7) select class from ships sh  where not exists (select ship from outcomes where ship = sh.class) group by class having count(*) = 1 or count(*) = 2
union select ship from outcomes s  where exists(select class from Classes where class = s.ship )
and not exists (select class from ships where class = s.ship); */

/* 8) select name from ships  where launched < 1942 union select ship from outcomes, battles  where name = battle
and year(date) < 1942 union select ship from outcomes where ship in (select class from ships where launched < 1942); */