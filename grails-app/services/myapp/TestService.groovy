package myapp

import com.mongodb.BasicDBObject
import com.mongodb.MongoClient
import com.mongodb.client.FindIterable
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

        def category = [:]
        cursor.each{
            category.put("category", it)
        }

        return category
    }

    def advancedSearch(boolean dubbed, boolean signed, String media){
        String dubbedCategory = "dubbedaudiodescribedaudio described"
        String signedCategory = "signedsigned"

        BasicDBObject objectives = new BasicDBObject()

        if (dubbed && signed){
            objectives.put("categories", new BasicDBObject('$all', [dubbedCategory, signedCategory]))
        }

        else if (dubbed){
            objectives.put("categories", new BasicDBObject('$eq', dubbedCategory))
        }

        else if (signed){
            objectives.put("categories", new BasicDBObject('$eq', signedCategory))
        }
        else{

        }

        if(media!=null){
            objectives.put("media_type", new BasicDBObject('$eq', media))
        }

        FindIterable iterable = collection.find(objectives)

        return iterable;

    }



}
