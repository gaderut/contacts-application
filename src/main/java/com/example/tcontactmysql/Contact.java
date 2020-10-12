package com.example.tcontactmysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Contact {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer contact_id;

  private String fname;
  private String mname;
  private String lname;

  public String getFname() {
	return fname;
}

public void setFname(String fname) {
	this.fname = fname;
}

public String getMname() {
	return mname;
}

public void setMname(String mname) {
	this.mname = mname;
}

public String getLname() {
	return lname;
}

public void setLname(String lname) {
	this.lname = lname;
}

public Integer getId() {
    return contact_id;
  }

  public void setId(Integer id) {
    this.contact_id = id;
  }



}
