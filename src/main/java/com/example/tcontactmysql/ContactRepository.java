package com.example.tcontactmysql;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.tcontactmysql.Contact;

public interface ContactRepository extends CrudRepository<Contact, Integer> {
	

	public List<Contact> findByFnameContainingIgnoreCase(String fname);
	public List<Contact> findByMnameContainingIgnoreCase(String mname);
	public List<Contact> findByLnameContainingIgnoreCase(String lname);
	public List<Contact> findByFnameLike(String fname);
	
}
