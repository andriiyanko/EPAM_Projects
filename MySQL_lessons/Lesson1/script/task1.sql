-- 1) select maker, type from product order by maker;
-- 2) select model, ram , screen, price from laptop lap where lap.price > 1000 order by lap.ram, lap.price desc; 
-- 3) select * from printer print where print.color like 'y' order by print.price desc; 
-- 4) select model,speed,hd,cd,price from pc pc where  (pc.cd like '12x' or pc.cd like '24x') and pc.price < 600;

-- 5) select sh.name,sh.class from ships sh  order by sh.name; 
-- 6) select * from pc pc where (pc.speed >= 500 and pc.price < 800) order by pc.price desc;
-- 7) select * from printer pr where (not pr.type = 'Matrix' and pr.price < 300) order by type desc; 
-- 8) select model,speed from pc pc where pc.price between 400 and 600 order by pc.hd; 
-- 9) select pc.model,pc.speed,pc.hd from pc pc join product pr where pc.model = pr.model and (pc.hd = 10 or pc.hd = 20) and pr.maker = 'A' order by pc.speed;  
-- 10)select model,speed,hd,price from laptop lap where lap.screen >= 12 order by lap.price desc;
-- 11) select model,type,price from printer pr where pr.price < 300 order by pr.type desc;
-- 12) select model,ram,price from laptop lap where lap.ram = 64 order by lap.screen;
-- 13) select model,ram,price from pc pc  where pc.ram > 64 order by pc.hd;
-- 14) select model,speed,price from pc pc where pc.speed between 500 and 750 order by pc.hd desc;

-- 15) select * from outcome_o out_o where out_o.out > 2000 order by out_o.date desc;
-- 16) select * from income_o in_o where in_o.inc between 5000 and 10000 order by in_o.inc;
-- 17) select * from income inc where inc.point = 1 order by inc.inc;
-- 18) select * from outcome outc where outc.point = 2 order by outc.out;

-- 19) select * from classes cl where cl.country = 'Japan' order by cl.type desc;
-- 20) select name,launched from ships sh where sh.launched between 1920 and 1942 order by sh.launched desc;
-- 21) select outc.ship, outc.battle, outc.result, bat.date from outcomes outc join battles bat where bat.name = outc.battle and outc.battle = 'Guadalcanal' and not outc.result = 'sunk' order by outc.ship;
-- 22) select * from outcomes outc where not outc.result = 'sunk' order by outc.ship desc;
-- 23) select cl.class,cl.displacement from classes cl where cl.displacement >= 40000 order by cl.type;

use aero;
-- 24) select tr.trip_no,tr.town_from,tr.town_to from trip tr where tr.town_to = 'London' order by tr.time_out;
-- 25) select tr.trip_no, tr.plane, tr.town_from, tr.town_to from trip tr where tr.plane = 'TU-134' order by tr.time_out desc;
-- 26) select tr.trip_no, tr.plane, tr.town_from, tr.town_to from trip tr where not tr.plane = 'IL-86' order by tr.plane;
-- 27) select tr.trip_no, tr.town_from, tr.town_to from trip tr where not tr.town_to = 'Rostov' order by tr.plane;
 