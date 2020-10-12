package hello.model;

import java.util.Date;

public abstract class Person {
	
	Date birthday;
	
	
	
	public Person(Date birthday) {
		super();
		this.birthday = birthday;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public abstract String getName();
	
	public abstract void setName(String name);
	
	public abstract void buy(String productId);
}
