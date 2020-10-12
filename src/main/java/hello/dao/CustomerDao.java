package hello.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import hello.model.Customer;

public class CustomerDao {
	
	// read https://www.arangodb.com/tutorials/tutorial-sync-java-driver/

	// TODO for Customer Data Access Object (DAO)
	
	public static void save(Customer c) {
		// TODO
	}
	
	public static Customer getById(Customer id) {
		// TODO
		return null;
	}
	
	public static List<Customer> listAll() {
		List<Customer> list = new ArrayList<>();
		// TODO
		return list;
	}
	
	public static List<Customer> getSampleList() {
		List<Customer> list = new ArrayList<>();
		try {
			list.add(new Customer("31/12/1998", "John"));
			list.add(new Customer("09/12/1996", "Thomas"));
			list.add(new Customer("09/08/1994", "Peter"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static Customer getSampleObject() {
		try {
			return new Customer("31/12/1998", "John");
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return null;
	}
}
