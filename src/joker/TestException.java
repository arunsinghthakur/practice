package joker;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.omg.CORBA.SystemException;

public class TestException {
	public static void main(String[] args) {
		try {
			Go();
		} catch (SystemException | IOException s) {
		}
	}

	static void Go() throws IOException, FileNotFoundException, SystemException {

	}
}
