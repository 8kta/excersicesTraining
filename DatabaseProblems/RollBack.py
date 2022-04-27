from Querys import *
from conn import connection

with connection.cursor() as cursor:
    print(ROLLBACK)
    cursor.execute(ROLLBACK)
