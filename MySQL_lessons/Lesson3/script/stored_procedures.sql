use storedpr_db;
-- --------------Insert_Employee ---------------------
DELIMITER //
CREATE PROCEDURE insert_employee(
	surname VARCHAR(30),
    name CHAR(30),
    midle_name VARCHAR(30),
    identity_number CHAR(10),
    passport CHAR(10),
    experience DECIMAL (10, 1),
    birthday DATE,
    post VARCHAR(15),
    pharmacy_id INT)
INSERT INTO employee (surname, name, midle_name, identity_number, passport, experience, birthday, post, pharmacy_id) VALUES (
 surname, name, midle_name, identity_number, passport, experience, birthday, post, pharmacy_id);
//
DELIMITER ;
-- ------------------------------------------------------

-- --------------Relationship M:M between Medicine_Zone ---------------------
DELIMITER // 
CREATE PROCEDURE Add_Data_To_MedicineZone(
	IN medicine_id int, 
	IN zone_id int)
BEGIN 
	IF((SELECT COUNT(*) FROM medicine WHERE medicine_id = id) > 0 AND (SELECT COUNT(*) FROM zone WHERE zone_id = id) > 0)
		THEN INSERT INTO medicine_zone(medicine_id, zone_id) values(medicine_id, zone_id);
	END IF;
END // 
DELIMITER ;
-- ------------------------------------------------------

-- --------------Cursor to create dynamically table from name Employee ---------------------
DELIMITER //
CREATE FUNCTION Generate_Random_Columns() RETURNS VARCHAR(100)
BEGIN 
SET @temp_columns = FLOOR(1 + (RAND() * 9));
    SET @random_columns = CONCAT("column_", @temp_columns, ' int null');
    
    generate_random_columns: REPEAT
		SET @temp_columns = @temp_columns - 1;
		SET @random_columns = CONCAT(@random_columns, ', column_', @temp_columns, ' int null');
        UNTIL @temp_columns = 1
		END REPEAT;
RETURN @random_columns;
END//         
DELIMITER ;    

DELIMITER //
CREATE PROCEDURE Create_Tables_Foreach_SurnameAndNames_From_Employee ()
BEGIN
	DECLARE done INT DEFAULT FALSE;
    DECLARE surnameT, nameT char (30);
    
    DECLARE cursor_new  CURSOR
    FOR SELECT surname, name FROM employee;
    
    DECLARE CONTINUE HANDLER 
    FOR NOT FOUND SET done = TRUE;
    
    OPEN cursor_new;
   
    my_loop: LOOP 
		FETCH cursor_new INTO surnameT, nameT;
        IF done = TRUE THEN LEAVE my_loop;
        END IF;
        SET @temp_query = CONCAT('CREATE TABLE ', surnameT, nameT,' (', Generate_Random_Columns(), ' ) ' ';');
        PREPARE myquery FROM @temp_query;
        EXECUTE myquery;
        DEALLOCATE PREPARE myquery;
        END LOOP;
        
        CLOSE cursor_new;        
    
END//
DELIMITER ;
    
