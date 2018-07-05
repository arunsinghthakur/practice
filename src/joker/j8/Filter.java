package joker.j8;

import java.util.ArrayList;
import java.util.List;

public class Filter {

	public static void main(String[] args) {
		List<Employee> users = new ArrayList<>();
		List<Address> add1 = new ArrayList<>();
		add1.add(new Address("Gurgaon"));
		add1.add(new Address("Delhi"));

		List<Address> add2 = new ArrayList<>();
		add2.add(new Address("Gurgaon"));
		add2.add(new Address("Delhi"));

		List<Address> add3 = new ArrayList<>();
		add3.add(new Address("Jaipur"));

		users.add(new Employee("Arun", 12, add1));
		users.add(new Employee("Rakesh", 23, add2));
		users.add(new Employee("Anil", 19, add3));

		users.stream().filter(u -> u.name.startsWith("A") && u.age / 10 == 1 &&  u.address.stream().anyMatch(a -> a.city.equals("Gurgaon"))).
		forEach(e -> System.out.println(e.name + " --- " + e.age));
	}
}

class Employee {
	String name;
	int age;
	List<Address> address;

	public Employee(String name, int age, List<Address> address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

}

class Address {
	String city;

	public Address(String city) {
		super();
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
