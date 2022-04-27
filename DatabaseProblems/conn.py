import mysql.connector

from getpass import getpass
from mysql.connector import connect, Error

try:
    connection = connect(host="localhost", user='alonso', password='password')
	        
except Error as e:
    print(e)
    

