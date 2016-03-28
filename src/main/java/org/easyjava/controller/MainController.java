package org.easyjava.controller;

import java.net.UnknownHostException;

import org.easyjava.model.Topic;
import org.easyjava.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Controller
public class MainController {

	@Autowired
	private TopicRepository repository;
	
	@RequestMapping("/")
    public String home(Model model) {
		 MongoClientURI uri  = new MongoClientURI("mongodb://heroku_tdtlxg32:abi3j9ono9ihsih7unska4a8q2@ds051788.mlab.com:51788/heroku_tdtlxg32"); 
	        MongoClient client = null;
			try {
				client = new MongoClient(uri);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        DB db = client.getDB(uri.getDatabase());
	        DBCollection collection = db.getCollection("Topic");
	        DBObject dbObject = new BasicDBObject();
	        Topic topic = new Topic("HashMap", "HASHMAP IS MY FAV COLLECTION");
	        topic.setId("123");
	        dbObject.put("title", topic);
	        collection.insert(dbObject);
		model.addAttribute("desc",dbObject.toString());
      return "index";
    }

}
