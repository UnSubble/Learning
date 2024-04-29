-- trigger_time                   trigger_event 
--  BEFORE                         INSERT
--  AFTER                          UPDATE
--                                 DELETE

DELIMITER $$  -- > sonlandırıcıyı $$ yaptık.
-- CREATE TRIGGER trigger_name trigger_time trigger_event ON table_name FOR EACH ROW
CREATE TRIGGER first BEFORE INSERT ON people FOR EACH ROW
BEGIN
	IF YEAR(NOW()) - YEAR(NEW.birthdt) < 18
    THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Must be an adult!';
    END IF;
END;

$$

DELIMITER ; -- > sonlandırıcıyı tekrar ; yaptık ki normale dönsün.

