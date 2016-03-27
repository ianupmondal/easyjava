package org.easyjava.configuration;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.mongodb.DB;
import com.mongodb.MongoException;
import com.mongodb.MongoURI;

@Component
@Configuration
public class SpringConfig {
	
	@Bean
	public DB getDb() throws UnknownHostException, MongoException {
		MongoURI mongoURI = new MongoURI("mongodb://heroku_tdtlxg32:abi3j9ono9ihsih7unska4a8q2@ds051788.mlab.com:51788/heroku_tdtlxg32");
        DB db = mongoURI.connectDB();
        db.authenticate(mongoURI.getUsername(), mongoURI.getPassword());
        //db.addUser(mongoURI.getUsername(), mongoURI.getPassword());
        return db;
	}

}
