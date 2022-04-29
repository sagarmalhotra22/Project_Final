Set Serveroutput on;
-- Trigger for deleting the professor_schedule
CREATE OR REPLACE TRIGGER delete_Prof_schedule
After DELETE
ON Professor_Schedule
FOR EACH ROW 
Enable
DECLARE 
v_user varchar2(25);
BEGIN
Select user into v_user from dual;
DBMS_OUTPUT.PUT_LINE('Schedule has been deleted by '||v_user);
EXCEPTION 
WHEN Others Then
dbms_output.put_line(' Schedule has not been deleted');
END;
/