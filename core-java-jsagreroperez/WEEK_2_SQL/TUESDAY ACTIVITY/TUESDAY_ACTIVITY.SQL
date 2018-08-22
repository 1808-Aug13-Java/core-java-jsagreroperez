-- WE CAN CREATE A COMMENT LIKE THIS
--JORGE SAGRERO-PEREZ
/*
THIS IS A MULUTILINNE COMMENT
WE CAN COMMENT HERE TOO
*/
--------------------------------
-- using ddl to create our tables
---------------------------------
CREATE TABLE DEPARTMENT (
    DEPT_ID NUMBER(5) CONSTRAINT PK_DEPT PRIMARY KEY,
    DEPT_NAME VARCHAR2(50),--VARCHAR 2 IS RECOMMENDED BECAUSE ORACLE STATES THAT VARCHAR1 WILL AT SOME POINT BECOME OBSOLETE AND CHANGE, RIGHTNOW THEY PERFROM THE SAME
    MONTHLY_BUDGET NUMBER(7,2)
    );-- YOU CAN HIGHLIGHT WHAT YOU WANT TO RUN
    
CREATE TABLE CUSTOMER (FIRST_NAME VARCHAR2(50), LAST_NAME VARCHAR2(50), PHONE_NUMBER NUMBER(20),  
EMAIL VARCHAR2(50), HOME_ADDRESS VARCHAR2(50), CUSTOMER_ID NUMBER(20)CONSTRAINT PK_CUSTOMER PRIMARY KEY 
);

--THIS QUERY SHOWS PURCHASES THAT OCCURED TODAY
CREATE TABLE INVOICE (INVOICE_ID NUMBER(20), INVOICE_DATE VARCHAR2(30), 
CUSTOMER_ID NUMBER(20) CONSTRAINT FK_INVOICE_CUSTOMER REFERENCES CUSTOMER ,
AMOUNT NUMBER (5,2) 
);
--THIS QUERY SHOWS PURCHASES THAT OCCURED TODAY
--SELECT TO_CHAR(SYSTIMESTAMP,'YYYY-MM-DD HH:MI:SS') FROM DUAL;
SELECT * FROM INVOICE
WHERE INVOICE_DATE = (SELECT TO_CHAR(SYSTIMESTAMP,'YYYY-MM-DD HH:MI:SS') FROM DUAL);

--a query which shows each customer and the number of purchases made by each

SELECT CUSTOMER.FIRST_NAME, CUSTOMER.LAST_NAME,CUSTOMER.CUSTOMER_ID, count(INVOICE.CUSTOMER_ID) as NUMBER_OF_ORDERS
FROM INVOICE
INNER JOIN CUSTOMER ON INVOICE.CUSTOMER_ID = CUSTOMER.CUSTOMER_ID
GROUP BY CUSTOMER.CUSTOMER_ID, CUSTOMER.FIRST_NAME, CUSTOMER.LAST_NAME, CUSTOMER.CUSTOMER_ID;


-- THE  QUERY THAT SHOWS THE CUSTOMER AND THE TOTAL COST OF ALL THEIR PURCHASES
SELECT CUSTOMER.FIRST_NAME, CUSTOMER.LAST_NAME,CUSTOMER.CUSTOMER_ID ,SUM(INVOICE.AMOUNT) as TOTAL_SPENT,count(INVOICE.CUSTOMER_ID) as NUMBER_OF_ORDERS
FROM INVOICE
INNER JOIN CUSTOMER ON INVOICE.CUSTOMER_ID = CUSTOMER.CUSTOMER_ID
GROUP BY CUSTOMER.CUSTOMER_ID, CUSTOMER.FIRST_NAME, CUSTOMER.LAST_NAME, CUSTOMER.CUSTOMER_ID;

--a query which returns all purchases which took place in the last month, display them in descending order
SELECT TO_CHAR(SYSTIMESTAMP,'YYYY-MM-DD HH:MI:SS') FROM DUAL;
SELECT * FROM INVOICE
WHERE INVOICE_DATE >( SELECT TO_CHAR((ADD_MONTHS(SYSDATE, -1)),'YYYY-MM-DD HH:MI:SS') FROM DUAL);

--Create a query which show the top three most expensive purchases

SELECT *
FROM INVOICE 
WHERE ROWNUM < 4
ORDER BY AMOUNT DESC;
    



/*

Create a table INVOICE which includes an id, date, customer id, and amount
Create a table CUSTOMER which includes relevant customer information 
Customer id in the invoice table should make a reference to the customer id in the customer table
Insert at least 50 records into your invoice table and at least 10 records into your customer table
Create a query which shows purchases that occured today
Create a query which shows each customer and the number of purchases made by each
Create a query which shows each customer and the total cost of all their purchases
Create a query which returns all purchases which took place in the last month, display them in descending order
Create a query which show the top three most expensive purchases

*/
