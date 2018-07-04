package joker.j8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Reduce {

	public static void main(String[] args) {
		List<User> users = new ArrayList<>();
		users.add(new User("Ashok"));
		users.add(new User("Arun"));
		
		System.out.println(users.stream().map(u -> u.toString()).collect(Collectors.joining(", ")));
	}

}

class User {

	public User(String name) {
		super();
		this.name = name;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}

}
