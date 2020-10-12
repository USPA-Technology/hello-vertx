package hello.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.google.gson.Gson;

public class Customer extends Person {
	
	static SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");

	String name;
	
	
	
	/**
	 * @param birthday (String in dd/MM/yyyy)
	 * @param name 
	 * @throws ParseException
	 */
	public Customer(String birthday, String name) throws ParseException {
		super(formater.parse(birthday));
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void buy(String productId) {
		System.out.println("Buy " + productId);
	}
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}
