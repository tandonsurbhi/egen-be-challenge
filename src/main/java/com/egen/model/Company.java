package com.egen.model;

import java.io.Serializable;

import org.mongodb.morphia.annotations.Embedded;
import org.springframework.stereotype.Component;

/*
"company":{  
      "name":"Denesik Group",
      "website":"http://jodie.org"
   }
 */
/**
 * Pojo Class
 * 
 * @author Surbhi Tandon
 *
 */
public class Company implements Serializable {

	private String name;
	private String website;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public String toString() {
		return "Company{" + "name='" + name + '\'' + ", website='" + website + '\'' + '}';
	}
}
