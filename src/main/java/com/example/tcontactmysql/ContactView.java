package com.example.tcontactmysql;

import java.sql.Date;

public class ContactView {
	
	private Integer contact_id;

	  private String fname;
	  private String mname;
	  private String lname;
	  
	  private Integer address_id1;
	  private Integer address_id2;
	  private Integer phone_id1;
	  private Integer phone_id2;

	  private String address_type1;
	  private String address1;
	  
	  private String city1;
	  private String state1;
	  private Integer zip1;
	  
	  private String address_type2;
	  private String address2;
	  private String city2;
	  private String state2;
	  private Integer zip2;
	  
	  private String phone_type1;
	  private String phone1;
	  private String phone_type2;
	  private String phone2;
	  
	  private String date_type;
	  private Date date_full;

	  
	  public Integer getPhone_id1() {
		return phone_id1;
	}
	public void setPhone_id1(Integer phone_id1) {
		this.phone_id1 = phone_id1;
	}
	public Integer getPhone_id2() {
		return phone_id2;
	}
	public void setPhone_id2(Integer phone_id2) {
		this.phone_id2 = phone_id2;
	}
	public String getPhone_type1() {
		return phone_type1;
	}
	public void setPhone_type1(String phone_type1) {
		this.phone_type1 = phone_type1;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone_type2() {
		return phone_type2;
	}
	public void setPhone_type2(String phone_type2) {
		this.phone_type2 = phone_type2;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	
	  public Integer getContact_id() {
		return contact_id;
	}
	public void setContact_id(Integer contact_id) {
		this.contact_id = contact_id;
	}
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
	public Integer getAddress_id1() {
		return address_id1;
	}
	public void setAddress_id1(Integer address_id1) {
		this.address_id1 = address_id1;
	}
	public Integer getAddress_id2() {
		return address_id2;
	}
	public void setAddress_id2(Integer address_id2) {
		this.address_id2 = address_id2;
	}
	public String getAddress_type1() {
		return address_type1;
	}
	public void setAddress_type1(String address_type1) {
		this.address_type1 = address_type1;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getCity1() {
		return city1;
	}
	public void setCity1(String city1) {
		this.city1 = city1;
	}
	public String getState1() {
		return state1;
	}
	public void setState1(String state1) {
		this.state1 = state1;
	}
	public Integer getZip1() {
		return zip1;
	}
	public void setZip1(Integer zip1) {
		this.zip1 = zip1;
	}
	public String getAddress_type2() {
		return address_type2;
	}
	public void setAddress_type2(String address_type2) {
		this.address_type2 = address_type2;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity2() {
		return city2;
	}
	public void setCity2(String city2) {
		this.city2 = city2;
	}
	public String getState2() {
		return state2;
	}
	public void setState2(String state2) {
		this.state2 = state2;
	}
	public Integer getZip2() {
		return zip2;
	}
	public void setZip2(Integer zip2) {
		this.zip2 = zip2;
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
