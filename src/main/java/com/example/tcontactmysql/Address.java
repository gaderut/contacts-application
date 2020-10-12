package com.example.tcontactmysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer address_id;
  @Column(name="contact_id")
  private Integer contactid;
  
  private String address_type;
  
  @Column(name="address_full")
  private String addressfull;
  
  private String city;
  private String state;
  private Integer zip;
  
public Integer getContactid() {
	return contactid;
}
public void setContactid(Integer contactid) {
	this.contactid = contactid;
}
public Integer getAddress_id() {
	return address_id;
}
public void setAddress_id(Integer address_id) {
	this.address_id = address_id;
}
//public Integer getContact_id() {
//	return contact_id;
//}
//public void setContact_id(Integer contact_id) {
//	this.contact_id = contact_id;
//}
public String getAddress_type() {
	return address_type;
}
public void setAddress_type(String address_type) {
	this.address_type = address_type;
}
//public String getAddress_full() {
//	return address_full;
//}
//public void setAddress_full(String address_full) {
//	this.address_full = address_full;
//}
public String getCity() {
	return city;
}
public String getAddressfull() {
	return addressfull;
}
public void setAddressfull(String addressfull) {
	this.addressfull = addressfull;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public Integer getZip() {
	return zip;
}
public void setZip(Integer zip) {
	this.zip = zip;
}

  
}
