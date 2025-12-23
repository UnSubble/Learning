SET SERVEROUTPUT ON; -- allows printing to stdout

DECLARE
    v_name VARCHAR2(50);

BEGIN
    v_name := 'unsubble';

    DBMS_OUTPUT.PUT_LINE('Hello PL/SQL!' || v_name);
END;
/
