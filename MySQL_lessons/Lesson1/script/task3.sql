
-- 1) select pr.maker,pr.type,pc.speed,pc.hd from pc pc join product pr where pr.model = pc.model and pc.hd <= 8 ;
-- 2) select distinct pr.maker from pc pc join product pr where pr.model = pc.model and pc.speed >= 600;
-- 3) select distinct pr.maker from laptop lap join product pr where pr.model = lap.model and lap.speed <= 500;
-- 4) select distinct lap.model, lap2.model, lap.hd, lap.ram from laptop lap, laptop lap2 where lap.hd = lap2.hd and  lap.ram = lap2.ram;
 

/* -- 5) SELECT distinct c1.country FROM classes c1 join  classes c2 ON c1.country = c2.country 
WHERE c1.type = 'bb' AND  c2.type = 'bc' OR  c2.type = 'bb' AND  c1.type = 'bc';*/

-- 6) select pc.model,pr.maker from pc pc join product pr where pr.model = pc.model and pc.price >= 600;
-- 7) select pr.model,pd.maker from printer pr join product pd where pd.model = pr.model and pr.price > 300;
use computer;
/* -- 8) select * from product pr where pr.model in (select pc.model from pc pc) 
 union select * from product pr where pr.model in (select lap.model from laptop lap);*/

-- 9) select pr.maker,pc.model,pc.price from pc pc join product pr where pr.model = pc.model;
-- 10) select pr.maker,pr.type,lap.model,lap.speed from laptop lap join product pr where pr.model = lap.model and lap.speed >= 600;


-- 11) select sh.name, cl.displacement from ships sh join classes cl where cl.class = sh.class order by sh.name;
-- 12) select bat.name,bat.date from battles bat join outcomes outc where bat.name = outc.battle and not outc.result = 'sunk';
-- 13) select sh.name, cl.country from ships sh join classes cl where cl.class = sh.class order by sh.name;

-- 14) select distinct comp.name, tr.plane from company comp join trip tr where comp.ID_comp = tr.ID_comp and tr.plane = 'Boeing'; 
-- 15) select pass.name,pit.date from passenger pass join pass_in_trip pit where pass.ID_psg = pit.ID_psg order by pass.name; 