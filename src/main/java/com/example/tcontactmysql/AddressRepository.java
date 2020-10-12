package com.example.tcontactmysql;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer> {

	public List<Address> findByAddressfullContainingIgnoreCase(String address_full);
	public List<Address> findByCityContainingIgnoreCase(String city);
	public List<Address> findByStateContainingIgnoreCase(String state);
	public Iterable<Address> findAllByContactid(int contact_id);
}

