package com.jay.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jay.utils.MongoConstants;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

@Configuration
public class MongoConfig {
	public static final String USERNAME = "root";
	public static final String PASSWORD = "password";
	public static final String HOSTNAME = "localhost";
	public static final String AUTH_DATABASE = "admin";
	public static final Integer PORT = 27017;

	@Bean(destroyMethod = "close")
	public MongoClient getMongoClient() {
		MongoClientOptions options = MongoClientOptions.builder().connectionsPerHost(10).socketTimeout(10000)
				.maxWaitTime(10000).connectTimeout(10000).build();
		MongoCredential credential = MongoCredential.createCredential(USERNAME, AUTH_DATABASE, PASSWORD.toCharArray());
		MongoClient mongoClient = new MongoClient(new ServerAddress(HOSTNAME, PORT), credential, options);

		return mongoClient;
	}

	@Bean(name = MongoConstants.ORGANIZATION)
	public MongoDatabase mongoDatabase() {
		return getMongoClient().getDatabase(MongoConstants.ORGANIZATION);
	}
}
