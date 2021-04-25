package com.jay.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
public class MongoConfig {
	public static final String USERNAME = "myUserAdmin";
	public static final String PASSWORD = "admin";
	public static final String HOSTNAME = "localhost";
	public static final String AUTH_DATABASE = "admin";
	public static final Integer PORT = 27017;

	@Autowired
	MongoClient mongoClient;

	@Bean
	public MongoClient getMongoClient() {
		MongoClientOptions options = MongoClientOptions.builder().connectionsPerHost(10).socketTimeout(10000)
				.maxWaitTime(10000).connectTimeout(10000).build();
		MongoCredential credential = MongoCredential.createCredential(USERNAME, AUTH_DATABASE, PASSWORD.toCharArray());
		this.mongoClient = new MongoClient(new ServerAddress(HOSTNAME, PORT), credential, options);

		return this.mongoClient;
	}
}
