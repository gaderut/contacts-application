package com.example.tcontactmysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Phone {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer phone_id;
  
  @Column(name="contact_id")
  private Integer contactid;

  private String phone_type;
  
  @Column(name="phone_number")
  private String phonenumber;
  
public Integer getContactid() {
	return contactid;
}
public void setContactid(Integer contactid) {
	this.contactid = contactid;
}
public Integer getPhone_id() {
	return phone_id;
}
public void setPhone_id(Integer phone_id) {
	this.phone_id = phone_id;
}
//public Integer getContact_id() {
//	return contact_id;
//}
//public void setContact_id(Integer contact_id) {
//	this.contact_id = contact_id;
//}
public String getPhone_type() {
	return phone_type;
}
public void setPhone_type(String phone_type) {
	this.phone_type = phone_type;
}
//public String getPhone_number() {
//	return phone_number;
//}
//public void setPhone_number(String phone_number) {
//	this.phone_number = phone_number;
//}
public String getPhonenumber() {
	return phonenumber;
}
public void setPhonenumber(String phonenumber) {
	this.phonenumber = phonenumber;
}



  


}
