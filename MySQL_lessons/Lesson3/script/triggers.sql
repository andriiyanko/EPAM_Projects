-- -------------------triggers for foreign keys ---------------------------
use storedpr_db;
-- ----------------- Employee_Post & Employee_Pharmacy --------------
DELIMITER //
CREATE TRIGGER Before_Insert_Child_Employee_Post BEFORE INSERT ON employee FOR EACH ROW
BEGIN
IF (SELECT COUNT(*) FROM post WHERE post = new.post) = 0 THEN
    SIGNAL SQLSTATE '45000' set MESSAGE_TEXT = 'Can\'t insert record. Foreign parent key does not exist!';
END IF;
END //
DELIMITER ;	

DELIMITER //
CREATE TRIGGER Before_Insert_Child_Employee_Pharmacy BEFORE INSERT ON employee FOR EACH ROW
BEGIN
IF (SELECT COUNT(*) FROM pharmacy WHERE pharmacy.id = new.pharmacy_id) = 0 THEN
    SIGNAL SQLSTATE '45000' set MESSAGE_TEXT = 'Can\'t insert record. Foreign parent key does not exist!';
END IF;
END //
DELIMITER ;	

DELIMITER //
CREATE TRIGGER Before_Update_Child_Employee_Post BEFORE UPDATE ON employee FOR EACH ROW
BEGIN
IF (SELECT COUNT(*) FROM post WHERE post.post = new.post) = 0 THEN
    SIGNAL SQLSTATE '45000' set MESSAGE_TEXT = 'Can\'t update record. Foreign parent key does not exist!';
END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER Before_Update_Child_Employee_Pharmacy BEFORE UPDATE ON employee FOR EACH ROW
BEGIN
IF (SELECT COUNT(*) FROM pharmacy WHERE pharmacy.id = new.pharmacy_id) = 0 THEN
    SIGNAL SQLSTATE '45000' set MESSAGE_TEXT = 'Can\'t update record. Foreign parent key does not exist!';
END IF;
END //
DELIMITER ;


DELIMITER //
CREATE TRIGGER delete_Child_Employee_Post before DELETE ON post FOR EACH ROW
BEGIN
    DELETE FROM employee WHERE post = old.post;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER delete_Child_Employee_Pharmacy before DELETE ON pharmacy FOR EACH ROW
BEGIN
    DELETE FROM employee WHERE pharmacy_id = old.id;
END //
DELIMITER ;

-- ---------------------------------------------------------------------

-- --------------- Pharmacy_Street ---------------------
DELIMITER //
CREATE TRIGGER Before_Insert_Child_Pharmacy_Street BEFORE INSERT ON pharmacy FOR EACH ROW
BEGIN
IF (SELECT COUNT(*) FROM street WHERE street = new.street) = 0 THEN
    SIGNAL SQLSTATE '45000' set MESSAGE_TEXT = 'Can\'t insert record. Foreign parent key does not exist!';
END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER Before_Update_Child_Pharmacy_Street BEFORE UPDATE ON pharmacy FOR EACH ROW
BEGIN
IF (SELECT COUNT(*) FROM street WHERE street = new.street) = 0 THEN
    SIGNAL SQLSTATE '45000' set MESSAGE_TEXT = 'Can\'t update record. Foreign parent key does not exist!';
END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER delete_Child_Pharmacy_Street before DELETE ON street FOR EACH ROW
BEGIN
    DELETE FROM pharmacy WHERE street = old.street;
END //
DELIMITER ;

-- ------------------------------------------------------

-- --------------- Pharmacy_PharmacyMedicine ---------------------
DELIMITER //
CREATE TRIGGER Before_Insert_Child_PharmacyMedicine_Pharmacy BEFORE INSERT ON pharmacy_medicine FOR EACH ROW
BEGIN
IF (SELECT COUNT(*) FROM pharmacy WHERE id = new.pharmacy_id) = 0 THEN
    SIGNAL SQLSTATE '45000' set MESSAGE_TEXT = 'Can\'t insert record. Foreign parent key does not exist!';
END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER Before_Update_Child_PharmacyMedicine_Pharmacy BEFORE UPDATE ON pharmacy_medicine FOR EACH ROW
BEGIN
IF (SELECT COUNT(*) FROM pharmacy WHERE id = new.pharmacy_id) = 0 THEN
    SIGNAL SQLSTATE '45000' SET  MESSAGE_TEXT = 'Can\'t update record. Foreign parent key does not exist!';
END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER delete_Child_PharmacyMedicine_Pharmacy before DELETE ON pharmacy FOR EACH ROW
BEGIN
    DELETE FROM pharmacy_medicine WHERE pharmacy_id = old.id;
END //
DELIMITER ;
-- ------------------------------------------------------

-- --------------Medicine_PharmacyMedicine ---------------------
DELIMITER //
CREATE TRIGGER Before_Insert_Child_PharmacyMedicine_Medicine BEFORE INSERT ON pharmacy_medicine FOR EACH ROW
BEGIN
IF (SELECT COUNT(*) FROM medicine WHERE id = new.medicine_id) = 0 THEN
    SIGNAL SQLSTATE '45000' set MESSAGE_TEXT = 'Can\'t insert record. Foreign parent key does not exist!';
END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER Before_Update_Child_PharmacyMedicine_Medicine BEFORE UPDATE ON pharmacy_medicine FOR EACH ROW
BEGIN
IF (SELECT COUNT(*) FROM medicine WHERE id = new.medicine_id) = 0 THEN
    SIGNAL SQLSTATE '45000' SET  MESSAGE_TEXT = 'Can\'t update record. Foreign parent key does not exist!';
END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER delete_Child_PharmacyMedicine_Medicine before DELETE ON medicine FOR EACH ROW
BEGIN
    DELETE FROM pharmacy_medicine WHERE medicine_id = old.id;
END //
DELIMITER ;
-- ------------------------------------------------------

-- --------------Medicine_MedicineZone ---------------------
DELIMITER //
CREATE TRIGGER Before_Insert_Child_MedicineZone_Medicine BEFORE INSERT ON medicine_zone FOR EACH ROW
BEGIN
IF (SELECT COUNT(*) FROM medicine WHERE id = new.medicine_id) = 0 THEN
    SIGNAL SQLSTATE '45000' set MESSAGE_TEXT = 'Can\'t insert record. Foreign parent key does not exist!';
END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER Before_Update_Child_MedicineZone_Medicine BEFORE UPDATE ON medicine_zone FOR EACH ROW
BEGIN
IF (SELECT COUNT(*) FROM medicine WHERE id = new.medicine_id) = 0 THEN
    SIGNAL SQLSTATE '45000' set MESSAGE_TEXT = 'Can\'t update record. Foreign parent key does not exist!';
END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER delete_Child_MedicineZone_Medicine before DELETE ON medicine FOR EACH ROW
BEGIN
    DELETE FROM medicine_zone WHERE medicine_id = old.id;
END //
DELIMITER ;
-- ------------------------------------------------------

-- --------------Zone_MedicineZone ---------------------
DELIMITER //
CREATE TRIGGER Before_Insert_Child_MedicineZone_Zone BEFORE INSERT ON medicine_zone FOR EACH ROW
BEGIN
IF (SELECT COUNT(*) FROM zone WHERE id = new.zone_id) = 0 THEN
    SIGNAL SQLSTATE '45000' set MESSAGE_TEXT = 'Can\'t insert record. Foreign parent key does not exist!';
END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER Before_Update_Child_MedicineZone_Zonw BEFORE UPDATE ON medicine_zone FOR EACH ROW
BEGIN
IF (SELECT COUNT(*) FROM zone WHERE id = new.zone_id) = 0 THEN
    SIGNAL SQLSTATE '45000' SET  MESSAGE_TEXT = 'Can\'t update record. Foreign parent key does not exist!';
END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER delete_Child_MedicineZone_Zone before DELETE ON zone FOR EACH ROW
BEGIN
    DELETE FROM medicine_zone WHERE zone_id = old.id;
END //
DELIMITER ;
-- ------------------------------------------------------


-- --------------Employee_IdentityNumber ---------------------
DELIMITER //
CREATE TRIGGER Check_Instert_IdentityNumber_To_Employee before INSERT ON employee FOR EACH ROW
BEGIN
	IF(identity_number LIKE '%00') THEN 
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'identify number can`t end with 00';
END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER Check_Update_IdentityNumber_To_Employee before update ON employee FOR EACH ROW
BEGIN
	IF(new.identity_number LIKE '%00') THEN 
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'identify number can`t end with 00';
END IF;
END //
DELIMITER ;
-- ------------------------------------------------------


-- --------------Check_Medicine_MinistryCode ---------------------
DELIMITER //
CREATE TRIGGER Check_Insert_Medicine_MinistryCode before INSERT ON medicine FOR EACH ROW
BEGIN
  IF NOT(convert(ministry_code USING cp1251) RLIKE convert('^[^МП][^МП]-[0-9][0-9][0-9]-[0-9][0-9]$' USING cp1251) ) THEN
 SIGNAL SQLSTATE '45000'
	SET MESSAGE_TEXT = 'Ministry code format: 2 довільні букви, окрім М та П - 3 цифри - 2 цифри';
 END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER Check_Update_Medicine_MinistryCode before update ON medicine FOR EACH ROW
BEGIN
  IF NOT(convert(new.ministry_code USING cp1251) RLIKE convert('^[^МП][^МП]-[0-9][0-9][0-9]-[0-9][0-9]$' USING cp1251) ) THEN
 SIGNAL SQLSTATE '45000'
	SET MESSAGE_TEXT = 'Ministry code format: 2 довільні букви, окрім М та П - 3 цифри - 2 цифри';
 END IF;
END //
DELIMITER ;
-- ------------------------------------------------------


-- --------------Deny_Data_In_Post---------------------

DELIMITER //
CREATE TRIGGER Check_Update_Data_In_Post before UPDATE ON post FOR EACH ROW
BEGIN
	SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cannot update data in post';
END //
DELIMITER ;
-- ------------------------------------------------------
