
-- 1) select * from pc pc where pc.model like '%1%1%';

-- 2) select * from outcome_o  where Month(date) = 3;
-- 3) select * from outcome_o where day(date) = 14;
 
-- 4) select * from ships sh where sh.name rlike '^W' and sh.name rlike 'n$';
-- 5) select * from ships sh where sh.name like '%e%e%';
use ships;
-- 6) select sh.name,sh.launched from ships sh where not sh.name rlike 'a$'; 
-- 7) select out_c.battle from outcomes out_c where out_c.battle rlike '[[:blank:]]' and not out_c.battle rlike 'c$';

-- 8) select * from trip tr where tr.time_out rlike '[[:blank:]](12|13|14|15|16|17)' ;
-- 9) select * from trip tr where tr.time_in rlike '[[:blank:]](17|18|19|20|21|22|23)';
-- 10) select pit.date, pit.place from pass_in_trip pit where pit.place rlike '^1'; 
-- 11) select pit.date, pit.place from pass_in_trip pit where pit.place rlike 'c$';
-- 12) select * from passenger ps where ps.name rlike '[[:blank:]]C';
-- 13) select * from passenger ps where ps.name not rlike '[[:blank:]]J';

 