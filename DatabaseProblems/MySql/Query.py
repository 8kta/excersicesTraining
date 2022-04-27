from Querys import *
from conn import connection

with connection.cursor() as cursor:
    print(QUERY)
    cursor.execute(QUERY)
    result = cursor.fetchall()
    for row in result:
        print(row)
