from Querys import *
from conn import connection

with connection.cursor() as cursor:
    print(DDL)
    cursor.execute(DDL)
