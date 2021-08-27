package com.jay.collection;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Project {

	@JsonProperty("_id")
	private Object _id;

	private String projectName;

	private List<String> projectTechnologies;

	public Object get_id() {
		return _id;
	}

	public void set_id(Object _id) {
		this._id = _id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<String> getProjectTechnologies() {
		return projectTechnologies;
	}

	public void setProjectTechnologies(List<String> projectTechnologies) {
		this.projectTechnologies = projectTechnologies;
	}

}
