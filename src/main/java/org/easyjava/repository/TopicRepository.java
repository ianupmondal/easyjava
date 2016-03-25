package org.easyjava.repository;

import org.easyjava.model.Topic;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TopicRepository extends MongoRepository<Topic, String>{

	public Topic findByTitle(String title);
}
