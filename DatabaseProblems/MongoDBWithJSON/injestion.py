import json

import pymongo

myclient = pymongo.MongoClient("mongodb://localhost:27017/")
mydb = myclient["historic"]
mycol = mydb["TweetsTest"]

#Path to JSON file
path = '/home/alonso/Documents/DataBases/pepsiYear.json'

# Opening JSON file
with open(path) as json_file:
    data = json.load(json_file)
 
    # Print the type of data variable
    print("Type:", type(data))
 
    print(f"Keys:", len(data['results']))
    
    my_data=data['results']
    
    x = mycol.insert_many(my_data)
    
    print("Data Ingested")



