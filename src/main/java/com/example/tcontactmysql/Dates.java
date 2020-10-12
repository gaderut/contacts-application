package com.example.tcontactmysql;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Dates {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer date_id;
  private Integer contact_id;

  private String date_type;
  private Date date_full;
  
public Integer getDate_id() {
	return date_id;
}
public void setDate_id(Integer date_id) {
	this.date_id = date_id;
}
public Integer getContact_id() {
	return contact_id;
}
public void setContact_id(Integer contact_id) {
	this.contact_id = contact_id;
}
public String getDate_type() {
	return date_type;
}
public void setDate_type(String date_type) {
	this.date_type = date_type;
}
public Date getDate_full() {
	return date_full;
}
public void setDate_full(Date date_full) {
	this.date_full = date_full;
}

  

}

