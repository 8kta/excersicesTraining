import mysql.connector

from getpass import getpass
from mysql.connector import connect, Error
from Querys import *
from conn import connection

with connection.cursor() as cursor:
    print(DATABASE)
    cursor.execute(DATABASE)
