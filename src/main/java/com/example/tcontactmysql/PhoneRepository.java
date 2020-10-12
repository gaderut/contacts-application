package com.example.tcontactmysql;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PhoneRepository extends CrudRepository<Phone, Integer> {
	
	public List<Phone> findByPhonenumberContainingIgnoreCase(String phone_number);
	public Iterable<Phone> findAllByContactid(int contact_id);
}
