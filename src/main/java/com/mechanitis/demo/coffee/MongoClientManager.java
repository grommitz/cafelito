package com.mechanitis.demo.coffee;

import com.mongodb.MongoClient;
import io.dropwizard.lifecycle.Managed;

public class MongoClientManager implements Managed {
    private final MongoClient mongoClient;

    public MongoClientManager(final MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

	public void start() throws Exception {
		
	}

	public void stop() throws Exception {
		mongoClient.close();
	}


}
