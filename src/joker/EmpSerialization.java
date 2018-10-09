package joker;

//Java code for serialization and deserialization  
//of a Java object 
import java.io.*;

class Emp implements Serializable {
	private static final long serialVersionUID = -8927253915422953556L;
	transient int a;
	static int b;
	String name;
	int age;
	public Emp(String name, int age, int a, int b) {
		this.name = name;
		this.age = age;
		this.a = a;
		Emp.b = b;
	}

}

public class EmpSerialization {
	public static void printdata(Emp object1) {
		System.out.println("name = " + object1.name);
		System.out.println("age = " + object1.age);
		System.out.println("a = " + object1.a);
		System.out.println("b = " + Emp.b);
	}

	public static void main(String[] args) {

		String filename = "shubham.txt";

		writeObject(filename);

		readObject(filename);
	}

	protected static void readObject(String filename) {
		try {
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);
			Object object1 =  in.readObject();
			in.close();
			file.close();
			System.out.println("Object has been deserialized\n" + "Data after Deserialization." + object1);
		} catch (IOException ex) {
			System.out.println("IOException is caught");
		} catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException" + " is caught");
		}
	}

	protected static void writeObject(String filename) {
		try {
			Emp object = new Emp("ab", 20, 2, 1000);
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(object);
			out.close();
			file.close();
			System.out.println("Object has been serialized\n" + "Data before Deserialization.");
			printdata(object);
		} catch (IOException ex) {
			System.out.println("IOException is caught");
		}
	}
}
