import pymongo

myclient = pymongo.MongoClient("mongodb://localhost:27017/")
mydb = myclient["historic"]
mycol = mydb["TweetsTest"]

#x = mycol.find_one()

#print(x)
tweets = mycol.find({},{ "_id": 0, "body": 1})

print(type(tweets))
