package yazlab;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class productList {

    public productList() {

        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = mongoClient.getDB("Product");

        DBCollection userCollection = db.getCollection("product");
        BasicDBObject bO = new BasicDBObject();

        userCollection.find().forEach((t) -> {
            System.out.println(t);
        });
    }

}
