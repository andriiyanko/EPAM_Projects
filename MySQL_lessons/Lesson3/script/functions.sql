use storedpr_db;

-- --------------Find Min value of Experience from Employee ---------------------
DELIMITER //
CREATE FUNCTION MinExperience() returns decimal(10,1)
begin
	return (select min(emp.experience) from employee emp);
END //
DELIMITER ;

select MinExperience;
-- ------------------------------------------------------

-- --------------Find Name_And_BuildingNumber ---------------------
DELIMITER //
CREATE FUNCTION Find_Name_BuildingNumber(id int) returns decimal(30)
begin
	return concat((select ph.name from pharmacy ph where ph.id = id), ' ',(select ph.building_number from pharmacy ph where ph.id = id));
END //
DELIMITER ;

select *,Find_Name_BuildingNumber(id) from employee;

-- ------------------------------------------------------