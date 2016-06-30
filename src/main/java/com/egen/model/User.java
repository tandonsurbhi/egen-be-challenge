package com.egen.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;


/*
{  
   "id":"1630215c-2608-44b9-aad4-9d56d8aafd4c",
   "firstName":"Dorris",
   "lastName":"Keeling",
   "email":"Darby_Leffler68@gmail.com",
   "address":{  
      "street":"193 Talon Valley",
      "city":"South Tate furt",
      "zip":"47069",
      "state":"IA",
      "country":"US"
   },
   "dateCreated":"2016-03-15T07:02:40.896Z",
   "company":{  
      "name":"Denesik Group",
      "website":"http://jodie.org"
   },
   "profilePic":"http://lorempixel.com/640/480/people"
}

 */
/**
 * Pojo class
 * @author Surbhi Tandon
 *
 */
@Entity
public class User implements Serializable{

    private static final long serial = 342534534L;

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
    private String dateCreated;
    private Company company;
    private String profilePic;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
    	this.dateCreated=dateCreated;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", dateCreated=" + dateCreated +
                ", company=" + company +
                ", profilePic='" + profilePic + '\'' +
                '}';
    }
}
