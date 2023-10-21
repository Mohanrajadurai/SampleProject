package org.day.one;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Prop_Test {
	public static void prop_read() {
		try {
			FileReader read = new FileReader("C:\\Users\\Mohan Rajadurai N\\eclipse-workspace\\Test\\src\\test\\resources\\TestData\\config.properties");
			Properties prop = new Properties();
			prop.load(read);
			String user = prop.getProperty("username");
			System.out.println(user);
			String pass = prop.getProperty("password");
			System.out.println(pass);
			
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		prop_read();
	}
}
