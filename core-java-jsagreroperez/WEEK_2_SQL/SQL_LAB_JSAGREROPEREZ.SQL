/*
JORGE SAGRERO-PEREZ
SQL LAB
WEEK 2 ASSIGNMENT DUE MONDAY 8/27/2018
*/

--Select all records from the Employee table.
SELECT * FROM EMPLOYEE;

--Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE
WHERE LASTNAME = 'King';


--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.// 
SELECT * FROM EMPLOYEE
-- NULL CANNOT BE USED IN A COMPARISON '=' STATEMENT, USE 'WHERE IS NULL, WHERE IS NOT NULL'
WHERE (FIRSTNAME = 'Andrew')AND (REPORTSTO IS NULL);

/*
2.2 ORDER BY
*/
--Task – Select all albums in Album table and sort result set in descending order by title.

SELECT * FROM ALBUM
ORDER BY(TITLE) DESC;



--Task – Select first name from Customer and sort result set in ascending order by city

SELECT FIRSTNAME FROM CUSTOMER
ORDER BY (CITY) ASC

--2.3 INSERT INTO
/*Task – Insert two new records into Genre table 
INSERT INTO table_name
VALUES (value1, value2, value3, ...);
GENREID(NUM), NAME120VARCHAR2*/
INSERT INTO GENRE
VALUES(26,'DOWN BEAT');

INSERT INTO GENRE
VALUES(27, 'ALTERNATIVE ROCK');





--Task – Insert two new records into Employee table
--EMPLOYEEID LASTNAME FIRSTNAME TITLE REPORTSTO BIRTHDATE 
--HIREDATE ADDRESS CITY STATE COUNTRY POSTALCODE PHONE FAX EMAIL
INSERT INTO EMPLOYEE
VALUES(9, 'SAGRERO-PEREZ', 'JORGE', 'IT STAFF',10,'26-NOV-94',
'10-NOV-18','1530 BERNARD ST', 'BAKERSFIELD','CA','USA', '93305',
'+1 (661) 496-4009', NULL,'jsagreroperez@mail.com');

INSERT INTO EMPLOYEE
VALUES(10, 'LAWSON', 'MIRANDA', 'IT MANAGER',1,'21-JAN-94',
'10-OCT-18','1421 NORMANDY AVE', 'NEW YORK','NY','USA', '94021',
'+1 (651) 623-5123', NULL,'mlawson@mail.com');



--Task – Insert two new records into Customer table
/*CUSTOMERID	NUMBER FIRSTNAME	VARCHAR2(40 BYTE) LASTNAME	VARCHAR2(20 BYTE) COMPANY	VARCHAR2(80 BYTE)
ADDRESS	VARCHAR2(70 BYTE) CITY	VARCHAR2(40 BYTE) STATE	VARCHAR2(40 BYTE) COUNTRY	VARCHAR2(40 BYTE)
POSTALCODE	VARCHAR2(10 BYTE) PHONE	VARCHAR2(24 BYTE) FAX	VARCHAR2(24 BYTE) EMAIL	VARCHAR2(60 BYTE)
SUPPORTREPID	NUMBER */

INSERT INTO CUSTOMER
VALUES(60, 'JORGE','SAGRERO','REVATURE','1530 BERNARD ST','BAKERSFIELD','CA','USA','93305',
'+1 (661) 496-4009', NULL,'jsagreroperez@mail.com',5);

INSERT INTO CUSTOMER
VALUES(61, 'MANUEL','SAGRERO','CSUB','1530 BERNARD ST','BAKERSFIELD','CA','USA','93305',
'+1 (661) 532-5262', NULL,'msagreroperez@mail.com',4);

/*
2.4 UPDATE
Task – Update Aaron Mitchell in Customer table to Robert Walter
Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE table_name
SET column1 = value1, column2 = value2, ...
WHERE condition;
*/
--Task – Update Aaron Mitchell in Customer table to Robert Walter

UPDATE CUSTOMER 
SET FIRSTNAME = 'Robert' , LASTNAME = 'Walter'
WHERE ((FIRSTNAME = 'Aaron') AND (LASTNAME = 'Mitchell'));

/*2.5 LIKE
Task – Select all invoices with a billing address like “T%”
*/
SELECT * FROM INVOICE
WHERE (BILLINGADDRESS LIKE 'T%');


/*
2.6 BETWEEN
Task – Select all invoices that have a total between 15 and 50
*/
SELECT * FROM INVOICE
WHERE (TOTAL BETWEEN 15 AND 30);

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004 FORMAT: 18-FEB-62
SELECT * FROM EMPLOYEE
WHERE (HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04');


/*2.7 DELETE
Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).	
SQL Functions
ALTER TABLE Persons
DROP CONSTRAINT PK_Person;
-----------------


------------
ALTER TABLE dbo.T2
   DROP CONSTRAINT FK_T1_T2   -- or whatever it's called

ALTER TABLE dbo.T2
   ADD CONSTRAINT FK_T1_T2_Cascade
   FOREIGN KEY (EmployeeID) REFERENCES dbo.T1(EmployeeID) ON DELETE CASCADE 
*/

/*
YOU CAN CHECK THE CONSTRAINTS BY TRYING TO DELETE THE RECORD AND LOOKING AT THE
ERROR WHICH STATES WHAT CHILD WAS ABOUT TO BE ORPHANED, THEN GO TO THAT TABLE AND CHOOSE
MODEL WHICH SHOWS A HEIRARCHY OF THE TABLES REFERENCES

IN THIS CASE INVOICE HAD A FOREIGN KEY REFERENCING THE CUSTOMERID OF CUSTOMER. THIS CONSTRAINT HAD A DELETE_RULE OF NO ACTION 
WHICH PREVENTED CASCADED DELETION, SO I HAD TO DROP THE ORIGINAL CONSTRAINT AND READD THE CONSTRAINT
WITH THE OPTION OF DELETE ON CASCADE ADDED

*/
ALTER TABLE INVOICE
DROP CONSTRAINT FK_INVOICECUSTOMERID;

ALTER TABLE INVOICE
ADD CONSTRAINT FK_INVOICECUSTOMERID 
   FOREIGN KEY  (CUSTOMERID)
   REFERENCES CUSTOMER(CUSTOMERID)
   ON DELETE CASCADE;
/*
AFTER ADJUSTING THE RESTRAINT DELETE OPTION OF INVOICE, THE REFERENCE KEY OF INVOICELINE
THAT REFERENCED THE INVOICEID OF THE TABLE INVOICE MUST ALSO BE ADJUSTED THE SAME WAY
SINCE THIS CONNECTION MEANS INVOICELINE ALSO DEPENDS ON THE TABLE CUSTOMER.
*/
   
   ALTER TABLE INVOICELINE
DROP CONSTRAINT FK_INVOICELINEINVOICEID;

ALTER TABLE INVOICELINE
ADD CONSTRAINT FK_INVOICELINEINVOICEID 
   FOREIGN KEY  (INVOICEID)
   REFERENCES INVOICE(INVOICEID)
   ON DELETE CASCADE;
   
DELETE FROM CUSTOMER 
WHERE ((FIRSTNAME ='Robert') AND (LASTNAME = 'Walter'));


/*
In this section you will be using the Oracle system functions, as well as your own functions,
to perform various actions against the database
3.1 System Defined Functions
Task – Create a function that returns the current time.
*/

-- creating table person_info
/* EXAMPLE CREATED PROGRAM
CREATE TABLE person_info
(
  PERSON_ID number(5) primary key,
  FIRST_NAME varchar2(20),
  LAST_NAME varchar2(20)
);

--creating table person_address_details

CREATE TABLE person_address_details
(
  PERSON_ADDRESS_ID number(5) primary key,
  PERSON_ID number(5) references person_info(person_id),
  CITY varchar2(15),
  STATE varchar2(15),
  COUNTRY varchar2(20),
  ZIP_CODE varchar2(10)
);

--creating function get_complete_address

create or replace FUNCTION get_complete_address(in_person_id IN NUMBER) 
   RETURN VARCHAR2
   IS person_details VARCHAR2(130);

   BEGIN 

	  SELECT 'Name-'||person.first_name||' '|| person.last_name||', 
        City-'|| address.city ||', State-'||address.state||', 
        Country-'||address.country||', ZIP Code-'||address.zip_code 
      INTO person_details
      FROM person_info person, person_address_details address
      WHERE person.person_id = in_person_id 
      AND address.person_id = person.person_id;

      RETURN(person_details); 

    END get_complete_address;

INSERT INTO person_info VALUES (10,'Luis','Thomas');
INSERT INTO person_info VALUES (20,'Wang','Moris');

INSERT INTO person_address_details VALUES (101,10,'Vegas','Nevada','US','88901');
INSERT INTO person_address_details  VALUES (102,20,'Carson','Nevada','US','90220');

select * from PERSON_INFO; */
/*
3.1 System Defined Functions
Task – Create a function that returns the current time.
Task – create a function that returns the length of name in MEDIATYPE table	
*/
SET SERVEROUTPUT ON;

CREATE OR REPLACE FUNCTION GET_TIME
    RETURN VARCHAR2
    IS CURRENT_TIME VARCHAR2(50);
    
    BEGIN
    
    SELECT TO_CHAR(SYSTIMESTAMP) 
    INTO CURRENT_TIME FROM DUAL;
    RETURN CURRENT_TIME;
     
    END;
    /
    
BEGIN
    DBMS_OUTPUT.PUT_LINE(GET_TIME());
END;
/
    
    
----------------------------
--Task – create a function that returns the length of name in MEDIATYPE table
CREATE OR REPLACE PROCEDURE GET_ALL_FROM_TABLE (S OUT SYS_REFCURSOR)
IS
BEGIN 
    OPEN S FOR
    SELECT NAME FROM MEDIATYPE;
END;
/


CREATE OR REPLACE FUNCTION NAME_LENGTH
--DECLARE
RETURN VARCHAR2
IS NAMES VARCHAR2(5000);
    SVAR SYS_REFCURSOR;
    TEMP_NAME MEDIATYPE.NAME%TYPE;--NUMBER; WE MAYNOT KNOW THE DATA TYPE, SO WE CAN JUST PROVIDE THE DATA TYPE OF ANOTHER COLUMN

BEGIN
    GET_ALL_FROM_TABLE(SVAR);
    -- NOW WE SHOULD HAVE ACCESS TO OUR EMPLYEES THROUGH SVAR
    LOOP
        FETCH SVAR INTO TEMP_NAME; -- "ACTIVE SET" IS EACH ROW RETURNED BY THE CURSOR
        EXIT WHEN SVAR%NOTFOUND;
        NAMES := (NAMES || CHR(13) || CHR(10)||(TEMP_NAME || ' IS ' || (LENGTH(TEMP_NAME)) || 'characters long' ));
    END LOOP;
    DBMS_OUTPUT.PUT_LINE(NAMES);
    CLOSE SVAR;
    RETURN NAMES;
END;
/
SET SERVEROUTPUT ON
EXEC DBMS_OUTPUT.PUT_LINE(NAME_LENGTH);

/*
3.2 System Defined Aggregate Functions
Task – Create a function that returns the average total of all invoices 
Task – Create a function that returns the most expensive track
  */
  
    
CREATE OR REPLACE FUNCTION GET_AVG_INVOICE_TOTAL
    RETURN NUMBER
    IS INV_AVG NUMBER;
    
    BEGIN
    
    SELECT AVG( TOTAL)
    INTO INV_AVG FROM INVOICE;
    RETURN INV_AVG;
     
    END;
    /
    BEGIN
    DBMS_OUTPUT.PUT_LINE(GET_AVG_INVOICE_TOTAL());
END;
/

--Task – Create a function that returns the most expensive track

--TRACK.UNITPRICE%TYPE
CREATE OR REPLACE FUNCTION GET_MOST_EXPENSIVE_TRACK
    RETURN TRACK.UNITPRICE%TYPE
    IS MOST_EXP_TRACK TRACK.UNITPRICE%TYPE;
    
    BEGIN
    
    SELECT MAX( UNITPRICE)
    INTO MOST_EXP_TRACK FROM TRACK;
    RETURN MOST_EXP_TRACK;
     
    END;
    /
    
BEGIN
    DBMS_OUTPUT.PUT_LINE(GET_MOST_EXPENSIVE_TRACK());
END;
/


/*----------------------------
3.3 User Defined Scalar Functions
Task – Create a function that returns the average price of invoiceline items in the invoiceline table
*/
CREATE OR REPLACE FUNCTION AVG_PRICE_INVOICELINE
RETURN NUMBER
IS AVG_PRICE NUMBER;

BEGIN
    SELECT AVG(UNITPRICE) INTO AVG_PRICE FROM INVOICELINE;
    RETURN AVG_PRICE;
END;
/

SET SERVEROUTPUT ON

BEGIN
    DBMS_OUTPUT.PUT_LINE(AVG_PRICE_INVOICELINE());
END;
/

/*3.4 User Defined Table Valued Functions
Task – Create a function that returns all employees who are born after 1968.
*/
CREATE OR REPLACE PROCEDURE GET_ALL_EMPLOYEES (S OUT SYS_REFCURSOR)
IS
BEGIN 
    OPEN S FOR
    SELECT FIRSTNAME,BIRTHDATE FROM EMPLOYEE;
END;
/


CREATE OR REPLACE FUNCTION EMPLOYEE_BORN_AFTER_1968
RETURN VARCHAR2
IS NAMES2 VARCHAR2(5000);
    SVAR SYS_REFCURSOR;
    TEMP_NAME EMPLOYEE.FIRSTNAME%TYPE;--NUMBER; WE MAYNOT KNOW THE DATA TYPE, SO WE CAN JUST PROVIDE THE DATA TYPE OF ANOTHER COLUMN
    TEMP_BDAY EMPLOYEE.BIRTHDATE%TYPE;
    HOLDER VARCHAR2(40);
BEGIN
    GET_ALL_EMPLOYEES(SVAR);
    -- NOW WE SHOULD HAVE ACCESS TO OUR EMPLYEES THROUGH SVAR
    LOOP
        FETCH SVAR INTO TEMP_NAME, TEMP_BDAY; -- "ACTIVE SET" IS EACH ROW RETURNED BY THE CURSOR
        EXIT WHEN SVAR%NOTFOUND;
        SELECT (TO_CHAR(TEMP_BDAY,'YYYY-MON-DD')) INTO HOLDER FROM DUAL;
        IF (HOLDER > '1968-JAN-01') THEN
        NAMES2 := (NAMES2 || CHR(13) || CHR(10)|| TEMP_NAME || ( ' IS ' || ' IS BORN AFTER 1968-JAN-01, THEIR BIRTHDAY IS  ON ' || TEMP_BDAY ));
          END IF;
    END LOOP;
    CLOSE SVAR;
    RETURN NAMES2;
END;
/
SET SERVEROUTPUT ON
EXEC DBMS_OUTPUT.PUT_LINE(EMPLOYEE_BORN_AFTER_1968);




/*4.0 Stored Procedures
 In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
*/




/*4.1 Basic Stored Procedure
Task – Create a stored procedure that selects the first and last names of all the employees.
*/

CREATE OR REPLACE PROCEDURE GET_ALL_EMPLOYEES (S OUT SYS_REFCURSOR)
IS
BEGIN 
    OPEN S FOR
    SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/

DECLARE
    SVAR SYS_REFCURSOR;
    TEMP_FNAME EMPLOYEE.FIRSTNAME%TYPE;
    TEMP_LNAME EMPLOYEE.LASTNAME%TYPE;

BEGIN
    GET_ALL_EMPLOYEES(SVAR);
    -- NOW WE SHOULD HAVE ACCESS TO OUR EMPLYEES THROUGH SVAR
    LOOP
        FETCH SVAR INTO TEMP_FNAME, TEMP_LNAME; -- "ACTIVE SET" IS EACH ROW RETURNED BY THE CURSOR
        EXIT WHEN SVAR%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('FIRSTNAME: '||TEMP_FNAME||', LASTNAME:  ' ||TEMP_LNAME);
    END LOOP;
    CLOSE SVAR;
END;



/*4.2 Stored Procedure Input Parameters
Task – Create a stored procedure that updates the personal information of an employee.
*/
--by default, the parameters input parameters if they are not specified
CREATE OR REPLACE PROCEDURE UPDATEEMPLOYEE(
TMP_EMPLOYEEID EMPLOYEE.EMPLOYEEID%TYPE,
TMP_LASTNAME EMPLOYEE.LASTNAME%TYPE,
TMP_FIRSTNAME EMPLOYEE.FIRSTNAME%TYPE,
TMP_TITLE EMPLOYEE.TITLE%TYPE,
TMP_REPORTSTO EMPLOYEE.REPORTSTO%TYPE,
TMP_BIRTHDATE EMPLOYEE.BIRTHDATE%TYPE,
TMP_HIREDATE EMPLOYEE.HIREDATE%TYPE,
TMP_ADDRESS EMPLOYEE.ADDRESS%TYPE,
TMP_CITY EMPLOYEE.CITY%TYPE,
TMP_STATE EMPLOYEE.STATE%TYPE,
TMP_COUNTRY EMPLOYEE.COUNTRY%TYPE,
TMP_POSTALCODE EMPLOYEE.POSTALCODE%TYPE,
TMP_PHONE, EMPLOYEE.PHONE%TYPE,
TMP_FAX, EMPLOYEE.FAX%TYPE,
TMP_EMAIL, EMPLOYEE.EMAIL%TYPE,
IS
BEGIN
    UPDATE EMPLOYEE
    SET 
EMPLOYEE.LASTNAME = TMP_LASTNAME ,
EMPLOYEE.FIRSTNAME =TMP_FIRSTNAME,
EMPLOYEE.TITLE = TMP_TITLE ,
EMPLOYEE.REPORTSTO = TMP_REPORTSTO ,
EMPLOYEE.BIRTHDATE = TMP_BIRTHDATE ,
EMPLOYEE.HIREDATE = TMP_HIREDATE ,
EMPLOYEE.ADDRESS = TMP_ADDRESS ,
EMPLOYEE.CITY = TMP_CITY,
EMPLOYEE.STATE = TMP_STATE ,
EMPLOYEE.COUNTRY = TMP_COUNTRY ,
EMPLOYEE.POSTALCODE = TMP_POSTALCODE ,
EMPLOYEE.PHONE = TMP_PHONE,
EMPLOYEE.FAX = TMP_FAX,
EMPLOYEE.EMAIL = TMP_EMAIL,
    WHERE  TMP_EMPLOYEEID = EMPLOYEE.EMPLOYEEID;
END;
/






/*Task – Create a stored procedure that returns the managers of an employee.
*/

/*
4.3 Stored Procedure Output Parameters
Task – Create a stored procedure that returns the name and company of a customer.
*/
CREATE OR REPLACE PROCEDURE RETURN_CUSTOMER_COMPANY(CUST IN CUSTOMER.CUSTOMERID%TYPE ,
FNAME OUT CUSTOMER.FIRSTNAME%TYPE,
LNAME OUT CUSTOMER.LASTNAME%TYPE,
COMPNY OUT CUSTOMER.COMPANY%TYPE)
IS
BEGIN
    SELECT FIRSTNAME, LASTNAME, COMPANY INTO FNAME, LNAME, COMPNY FROM
    CUSTOMER WHERE CUST = CUSTOMER.CUSTOMERID;
END;
/
SET SERVEROUTPUT ON;

DECLARE
    FNAME2 CUSTOMER.FIRSTNAME%TYPE;
LNAME2 CUSTOMER.LASTNAME%TYPE;
COMPNY2 CUSTOMER.COMPANY%TYPE;
STRINGBABY VARCHAR2(200);
BEGIN


    RETURN_CUSTOMER_COMPANY(1, FNAME2,LNAME2,COMPNY2);
    STRINGBABY := (FNAME2 || ' ' || LNAME2|| ' ' || COMPNY2);
    DBMS_OUTPUT.PUT_LINE(STRINGBABY);
END;
/


/*5.0 Transactions
In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
*/

CREATE OR REPLACE PROCEDURE REMOVE_INVOICE(INVID IN INVOICE.INVOICEID%TYPE )
IS
BEGIN
    DELETE FROM INVOICELINE
    WHERE INVOICELINEID = INVID;
    DELETE FROM INVOICE 
    WHERE INVOICE.INVOICEID = INVID;
END;
/
SET SERVEROUTPUT ON;

DECLARE
   
BEGIN
 REMOVE_INVOICE(1);
END;
/

/*Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
*/



CREATE OR REPLACE PROCEDURE NEWCUSTOMER(
    CUST_ID CUSTOMER.CUSTOMERID%TYPE,
    FNAME CUSTOMER.FIRSTNAME%TYPE,
    LNAME CUSTOMER.LASTNAME%TYPE,
    CUSTCOMP CUSTOMER.COMPANY%TYPE,
    CUSTADR CUSTOMER.ADDRESS%TYPE,
    CUSTCITY CUSTOMER.CITY%TYPE,
    CUSTST CUSTOMER.STATE%TYPE,
    CUSTCONT CUSTOMER.COUNTRY%TYPE,
    CUSTPOST CUSTOMER.POSTALCODE%TYPE,
    CUSTPHON CUSTOMER.PHONE%TYPE,
    CUSTFAX CUSTOMER.FAX%TYPE,
    CUSTEMAIL CUSTOMER.EMAIL%TYPE,
    CUSTSUPID CUSTOMER.SUPPORTREPID%TYPE)
IS
BEGIN
    INSERT INTO CUSTOMER(CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,
    COUNTRY,POSTALCODE,PHONE,FAX,EMAIL, SUPPORTREPID)
    VALUES(
    CUST_ID,
    FNAME,
    LNAME,
    CUSTCOMP,
    CUSTADR,
    CUSTCITY,
    CUSTST,
    CUSTCONT,
    CUSTPOST,
    CUSTPHON,
    CUSTFAX,
    CUSTEMAIL,
    CUSTSUPID );
END;
/



/*6.0 Triggers
In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
*/


/*6.1 AFTER/FOR
Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
*/
CREATE OR REPLACE TRIGGER TRIG_AFTER_INSERT_EMPLOYEE
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('A new employee has joined.');
END;
/
/*Task – Create an after update trigger on the album table that fires after a row is inserted in the table
*/
CREATE OR REPLACE TRIGGER TRIG_AFTER_NEW_ALBUM
AFTER UPDATE ON ALBUM
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('A record was just updated');
END;
/

/*Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
*/

CREATE OR REPLACE TRIGGER TRIG_AFTER_CUSTOMER_DELETE
AFTER DELETE ON CUSTOMER
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('A customer is no longer doing business.');
END;
/

/*
7.0 JOINS
In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
*/

/*
7.1 INNER
Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
*/

SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID FROM CUSTOMER
INNER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

/*7.2 OUTER
Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
*/
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER
FULL OUTER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

/*7.3 RIGHT
Task – Create a right join that joins album and artist specifying artist name and title.
*/

SELECT ARTIST.NAME,ALBUM.TITLE 
FROM ALBUM
RIGHT JOIN ARTIST ON ALBUM.ARTISTID = ARTIST.ARTISTID;

/*7.4 CROSS
Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
*/
SELECT *
FROM ALBUM
CROSS JOIN ARTIST
ORDER BY ARTIST.NAME ASC;

/*7.5 SELF
Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT a.column_name, b.column_name... 
FROM table1 a, table1 b 
WHERE a.common_filed = b.common_field;
*/

SELECT  A.REPORTSTO, B.EMPLOYEEID
FROM EMPLOYEE A, EMPLOYEE B
WHERE A.EMPLOYEEID = B.EMPLOYEEID;L