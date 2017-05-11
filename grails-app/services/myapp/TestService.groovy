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

        return cursor.toList().sort()
    }

    def masterbrandMethod(){
        MongoCursor<String> cursor = collection.distinct("masterbrand", String.class).iterator()

        return cursor.toList().sort()
    }

    def advancedSearch(boolean dubbed, boolean signed, String media, String masterbrand, String keywords,
                       int clip){
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

        /*
        if(startTime!=null){
            objectives.put("epoch_start", new BasicDBObject('$gte', startTime))
        }

        if(endTime!=null){
            objectives.put("epoch_start", new BasicDBObject('$lte', endTime))
        }*/

        if(masterbrand!=null){
            objectives.put("masterbrand", new BasicDBObject('$eq', masterbrand))
        }

        if(keywords!=null){
            objectives.put('$text', new BasicDBObject('$search', keywords))
        }

        if(clip!=null){
            objectives.put("is_clip", clip)
        }


        // the default is to sort by epoch_start in descending order
        def sorting = ["epoch_start": -1]

        FindIterable iterable

        // if no keywords were passed, just sort by epoch_start
        if (keywords == null) {
            iterable = collection.find(objectives).sort(sorting)
        }
        // if keywords were passed, sort by text search relevance AND epoch_start
        else
        {
            def score = ['$meta': "textScore"]
            def proj = ["score": score]
            iterable = collection.find(objectives).projection(proj).sort(proj)
        }


        //FindIterable iterable = collection.find(objectives).sort(sorting)


        return iterable;

    }



}
