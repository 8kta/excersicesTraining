from Querys import *
from conn import connection

#with connection.cursor() as cursor:
cursor = connection.cursor()
print(INSERT)
cursor.execute(INSERT)
#connection.commit()
cursor.close()

    
