package com.example.tcontactmysql;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"user"})
public class ViewContactsController {
	@Autowired 
	private ContactRepository contactRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private PhoneRepository phoneRepository;
	@Autowired
	private DatesRepository datesRepository;

    @RequestMapping(value = {"view"}, method = RequestMethod.GET)
    public ModelAndView viewUsers() {
        return new ModelAndView("viewUsers");
    }

    @RequestMapping(value = {"get"}, method = RequestMethod.GET)
    public ResponseEntity getAllUsers() {
        List<Contact> ct = (List<Contact>) contactRepository.findAll();;
        if (ct.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            List<Contact> responseList = new ArrayList<>();
            Contact responseData;
            for (Contact user : ct) {
                responseData = new Contact();
                responseData.setId(user.getId());
                responseData.setFname(user.getFname());
                responseData.setMname(user.getMname());
                responseData.setLname(user.getLname());
                responseList.add(responseData);
            }
            return new ResponseEntity(responseList, HttpStatus.OK);
        }
    }

    @RequestMapping(value = {"get/contact"}, method = RequestMethod.GET)
    public ResponseEntity getContactsForUser(@RequestParam("id") Integer id) {
        Optional<Contact> n = contactRepository.findById(id);
        int contact_id = n.get().getId();
        Iterable<Address> addresses =  addressRepository.findAll();
        Iterable<Phone> phones =  phoneRepository.findAll();
        Iterable<Dates> dates =  datesRepository.findAll();
        
        List<ContactView> responseList = new ArrayList<>();
        ContactView cv = new ContactView();
        if(n.isPresent()){
        	cv.setContact_id(n.get().getId());
         	cv.setFname(n.get().getFname());
         	cv.setMname(n.get().getMname());
         	cv.setLname(n.get().getLname());
	        for(Address ad :addresses) {
	        	if(ad.getContactid() == id) {
	             	if(ad.getAddress_type().equalsIgnoreCase("Home")) {
	             		cv.setAddress_id1(ad.getAddress_id());
	             		cv.setAddress_type1(ad.getAddress_type());
		             	cv.setAddress1(ad.getAddressfull());
		             	cv.setCity1(ad.getCity());
		             	cv.setState1(ad.getState());
		             	cv.setZip1(ad.getZip());
	             	}
	             	else {
	             		cv.setAddress_id2(ad.getAddress_id());
	             		cv.setAddress_type2(ad.getAddress_type());
		             	cv.setAddress2(ad.getAddressfull());
		             	cv.setCity2(ad.getCity());
		             	cv.setState2(ad.getState());
		             	cv.setZip2(ad.getZip());
	             	}
	        	}
	        }
	        for(Phone ph :phones) {
	        	if(ph.getContactid() == id) {
	             	if(ph.getPhone_type().equalsIgnoreCase("Cell")) {
		             	cv.setPhone_id1(ph.getPhone_id());
		             	cv.setPhone_type1(ph.getPhone_type());
		             	cv.setPhone1(ph.getPhonenumber());
	             	}
	             	else {
	             		cv.setPhone_id2(ph.getPhone_id());
		             	cv.setPhone_type2(ph.getPhone_type());
		             	cv.setPhone2(ph.getPhonenumber());
	             	}
	        	}
	        }
	        for(Dates dt :dates) {
	        	if(dt.getContact_id() == id) {
		             	cv.setDate_type(dt.getDate_type());
		             	cv.setDate_full(dt.getDate_full());             	
	        	}
	        	
	        }
	        responseList.add(cv);
	        return new ResponseEntity(responseList, HttpStatus.OK);
        }else {
        	return new ResponseEntity(HttpStatus.NO_CONTENT);
        }    
        
    }

    @RequestMapping(value = {"add"}, method = RequestMethod.POST)
    public ResponseEntity addUser(@RequestBody ContactView cv) {
        
        Contact n = new Contact();
	    n.setFname(cv.getFname());
	    n.setMname(cv.getMname());
	    n.setLname(cv.getLname());
	    contactRepository.save(n);
//	    System.out.println("cv add 2 is  "+cv.getAddress_type2());
	    
	    Optional<Contact> c = contactRepository.findById(n.getId());
	    
	    if(cv.getAddress_type1() != null) {
		    Address ad1 = new Address();
		    ad1.setContactid(c.get().getId());
		    ad1.setAddress_type(cv.getAddress_type1());
		    ad1.setAddressfull(cv.getAddress1());
		    ad1.setCity(cv.getCity1());
		    ad1.setState(cv.getState1());
		    ad1.setZip(cv.getZip1());	    
		    addressRepository.save(ad1);
	    }
	    if(cv.getAddress_type2() != null) {
		    Address ad2 = new Address();
		    ad2.setContactid(c.get().getId());
		    ad2.setAddress_type(cv.getAddress_type2());
		    ad2.setAddressfull(cv.getAddress2());
		    ad2.setCity(cv.getCity2());
		    ad2.setState(cv.getState2());
		    ad2.setZip(cv.getZip2());	    
		    addressRepository.save(ad2);
	    }
	    if(cv.getPhone_type1() != null) {
		    Phone ph1 = new Phone();
		    ph1.setContactid(c.get().getId());
		    ph1.setPhone_type(cv.getPhone_type1());
		    ph1.setPhonenumber(cv.getPhone1());
		    phoneRepository.save(ph1);
	    }
	    if(cv.getPhone_type2() != null) {
		    Phone ph2 = new Phone();
		    ph2.setContactid(c.get().getId());
		    ph2.setPhone_type(cv.getPhone_type2());
		    ph2.setPhonenumber(cv.getPhone2());
		    phoneRepository.save(ph2);
	    }
	    if(cv.getDate_type() != null) {
		    Dates dt = new Dates();
		    dt.setContact_id(c.get().getId());
		    dt.setDate_type(cv.getDate_type());
		    dt.setDate_full(cv.getDate_full());
		    datesRepository.save(dt);
	    }
	    
		return new ResponseEntity(new SystemMessage("User Added"), HttpStatus.OK);
    }

    @RequestMapping(value = {"delete/{id}"}, method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable("id") Integer id) {
        Iterable<Address> add = addressRepository.findAllByContactid(id);
        Iterable<Phone> phh = phoneRepository.findAllByContactid(id);
        for(Address ad : add) {
        	addressRepository.deleteById(ad.getAddress_id());
        }
        for(Phone ph : phh) {
        	phoneRepository.deleteById(ph.getPhone_id());
        }
        contactRepository.deleteById(id);
        Optional<Contact> n = contactRepository.findById(id);
        if (n.isPresent()) {
        	return new ResponseEntity(new SystemMessage("Delete failed"), HttpStatus.BAD_REQUEST);
            
        } else {
        	return new ResponseEntity(new SystemMessage("Delete done"), HttpStatus.OK);
        }
    }
    
    @RequestMapping(value = {"edit"}, method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity editUser(@RequestBody ContactView cv) {
//        System.out.println("in editUser");
        System.out.println("contact id "+cv.getContact_id());
        System.out.println("last name id "+cv.getLname());
        Optional<Contact> n = contactRepository.findById(cv.getContact_id());
        int contact_id = n.get().getId();
//        Iterable<Address> addresses =  addressRepository.findAll();
        Iterable<Phone> phones =  phoneRepository.findAll();
        Iterable<Dates> dates =  datesRepository.findAll();
//        Iterable<Address> addresses = addressRepository.findAllById(contact_id);
        if (n.isPresent()) {
        	n.get().setFname(cv.getFname());
        	n.get().setMname(cv.getMname());
        	n.get().setLname(cv.getLname()); 
        	return new ResponseEntity(new SystemMessage("Edit done"), HttpStatus.OK);
        } 
        else {
        	return new ResponseEntity(new SystemMessage("Edit failed"), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = {"get/search"}, method = RequestMethod.GET)
    public ResponseEntity getContactsForUserSearch(@RequestParam("name") String searchstring) {
//        System.out.println("in getContactsForUserSearch");
        List<Contact> resultFname = contactRepository.findByFnameContainingIgnoreCase(searchstring);
        List<Contact> resultMname = contactRepository.findByMnameContainingIgnoreCase(searchstring);
        List<Contact> resultLname = contactRepository.findByLnameContainingIgnoreCase(searchstring);
        List<Address> resultAddress = addressRepository.findByAddressfullContainingIgnoreCase(searchstring);
        List<Address> resultCity = addressRepository.findByCityContainingIgnoreCase(searchstring);
        List<Address> resultState = addressRepository.findByStateContainingIgnoreCase(searchstring);
        List<Phone> resultPhone = phoneRepository.findByPhonenumberContainingIgnoreCase(searchstring);
       
        List<Contact> responseList = new ArrayList<>();
        Contact responseData;
        if(!resultFname.isEmpty()){
        	for(Contact ct :resultFname) {
        		responseData = new Contact();
        		responseData.setId(ct.getId());
        		responseData.setFname(ct.getFname());
        		responseData.setMname(ct.getMname());
        		responseData.setLname(ct.getLname());
        		responseList.add(responseData);
        	}
        }
        if(!resultMname.isEmpty()){
        	for(Contact ct :resultMname) {
        		responseData = new Contact();
        		responseData.setId(ct.getId());
        		responseData.setFname(ct.getFname());
        		responseData.setMname(ct.getMname());
        		responseData.setLname(ct.getLname());
        		responseList.add(responseData);
        	}
        }
        if(!resultLname.isEmpty()){
        	for(Contact ct :resultLname) {
        		responseData = new Contact();
        		responseData.setId(ct.getId());
        		responseData.setFname(ct.getFname());
        		responseData.setMname(ct.getMname());
        		responseData.setLname(ct.getLname());
        		responseList.add(responseData);
        	}
        }
        if(!resultAddress.isEmpty()){
        	for(Address ad :resultAddress) {
        		responseData = new Contact();
        		responseData.setId(ad.getContactid());
        		Optional<Contact> n = contactRepository.findById(ad.getContactid());
        		responseData.setFname(n.get().getFname());
        		responseData.setMname(n.get().getMname());
        		responseData.setLname(n.get().getLname());
        		responseList.add(responseData);
        	}
        }
        if(!resultCity.isEmpty()){
        	for(Address ad :resultCity) {
        		responseData = new Contact();
        		responseData.setId(ad.getContactid());
        		Optional<Contact> n = contactRepository.findById(ad.getContactid());
        		responseData.setFname(n.get().getFname());      		
        		responseData.setMname(n.get().getMname());
        		responseData.setLname(n.get().getLname());
        		responseList.add(responseData);
        	}
        	
        }
        if(!resultState.isEmpty()){
        	for(Address ad :resultState) {
        		responseData = new Contact();
        		responseData.setId(ad.getContactid());
        		Optional<Contact> n = contactRepository.findById(ad.getContactid());
        		responseData.setFname(n.get().getFname());
        		responseData.setMname(n.get().getMname());
        		responseData.setLname(n.get().getLname());
        		responseList.add(responseData);
        	}
        }
        if(!resultPhone.isEmpty()){
        	for(Phone ph :resultPhone) {
        		responseData = new Contact();
        		responseData.setId(ph.getContactid());
        		Optional<Contact> n = contactRepository.findById(ph.getContactid());
        		responseData.setFname(n.get().getFname());
        		responseData.setMname(n.get().getMname());
        		responseData.setLname(n.get().getLname());
        		responseList.add(responseData);
        	}
        }
	        
        if(!responseList.isEmpty())
	        return new ResponseEntity(responseList, HttpStatus.OK);
        else {
        	return new ResponseEntity(HttpStatus.NO_CONTENT);
        }    
        
    }    

}

