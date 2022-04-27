DATABASE = '''
CREATE DATABASE test_database;
'''

DDL = '''
CREATE TABLE test_table_one (
    PersonID Int NOT NULL,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255) NOT NULL,
    Address varchar(255),
    City varchar(255),
    PRIMARY KEY (PersonID) 
    );
    
CREATE OR REPLACE test_view_line as
select PersonID,
LastName,
FirstName,
Address,
City
from test_table_one;
    
GRANT SELECT, DELETE, UPDATE ON *.* TO alonso@localhost;
'''

ROLLBACK = '''
DROP TABLE IF EXISTS test_table_one;
DROP VIEW IF EXISTS test_view_line;
'''

INSERT = '''
INSERT INTO test_table_one ( PersonID, LastName, FirstName, Address, City )
VALUES ( 1, "Garcia", "Alonso", "Hidden Glenn", "Atlanta" )
VALUES ( 2, "Hernandez", "Memo", "Hidden Glenn", "Atlanta" );
'''

QUERY = '''
SELECT * FROM test_database.test_table_one;
'''
