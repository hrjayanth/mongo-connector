package com.jay.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;

import org.bson.Document;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jay.annotations.Collection;
import com.jay.exception.MongoAdapterException;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Repository
public abstract class MongoDao<T> {
	private Class<T> persistentClass;

	private MongoDatabase mongoDatabase;

	private MongoCollection<Document> mongoCollection;

	@Autowired
	MongoClient mongoClient;

	@PostConstruct
	public void setContext() throws MongoAdapterException {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		if (!this.persistentClass.isAnnotationPresent(com.jay.annotations.Collection.class)) {
			throw new MongoAdapterException("This is not a collection");
		}

		Collection collection = this.persistentClass.getAnnotation(Collection.class);
		mongoDatabase = mongoClient.getDatabase(collection.database());
		mongoCollection = mongoDatabase.getCollection(collection.name());
	}

	/**
	 * Inserts one document into the database
	 * 
	 * @param t
	 */
	public void insert(T t) {
		JSONObject jsonObj = new JSONObject(t);
		mongoCollection.insertOne(Document.parse(jsonObj.toString()));
	}

	/**
	 * Inserts many document into the database
	 * 
	 * @param t
	 */
	public void insert(List<T> t) {

	}

	public void delete(Integer id) {

	}

	public T find() {
		return null;
	}
}
