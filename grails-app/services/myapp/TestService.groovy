package myapp

import com.mongodb.MongoClient
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoCursor
import com.mongodb.client.MongoDatabase
import grails.transaction.Transactional


@Transactional
class TestService {
    MongoClient mongo = new MongoClient()
    MongoDatabase db = mongo.getDatabase("mydb")
    MongoCollection collection = db.getCollection("bbc")


    def searchMethod(String keywords) {
        def count = Programme.countHits(keywords)
        List<Programme> programmes = Programme.searchTop(keywords, count)

        return programmes
    }

    def signedMethod() {
        //def count = Programme.countHits("signed")
        List<Programme> signed = Programme.find(eq("categories", "signed"))

        return signed
    }

    def tagsMethod(){
        MongoCursor<String> cursor = collection.distinct("tags", String.class).iterator()

        return cursor.toList().sort()
    }

    def categoriesMethod(){
        MongoCursor<String> cursor = collection.distinct("categories", String.class).iterator()

        return cursor.toList().sort()
    }



}
