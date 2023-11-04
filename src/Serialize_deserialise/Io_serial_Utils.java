package Serialize_deserialise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import Generic_lambda_streams.Product;
import Generic_lambda_streams.Student;


public interface Io_serial_Utils {
//add a method to restore product details from a bin file using de-ser.
	@SuppressWarnings("unchecked")
	static Map<Integer,Product> restoreProductDetails(String fileName) throws IOException{
		// chain of i/o strms
		// Java App <---- OIS <---- FIS (bin file)
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
			return (Map<Integer,Product>)in.readObject();
		}catch (Exception e) {
			//in case of any errs : return empty map to the caller
			//e.printStackTrace();
			System.out.println(e);
			return new HashMap<>();
			
		}
	}
	//add a method to store product details in a bin file using ser.
		static void storeProductDetails(Map<Integer, Product> map, String FileName) throws IOException{
			// Java App --> OOS --> FOS (bin file)
			try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FileName))) {
				out.writeObject(map);//ser.
			}
		}
		
		static void storeStudentDetails(Map<String,Student> map,String FileName) throws IOException{
			try(ObjectOutputStream O=new ObjectOutputStream(new FileOutputStream(FileName))){
				O.writeObject(map);			
			}
		}
		@SuppressWarnings("unchecked")
		static Map<String,Student> restoreStudentDetails(String fileName) throws IOException{
			// chain of i/o strms
			// Java App <---- OIS <---- FIS (bin file)
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
				return (Map<String,Student>)in.readObject();
			}catch (Exception e) {
				//in case of any errs : return empty map to the caller
				//e.printStackTrace();
				System.out.println(e);
				return new HashMap<>();
				
			}
		}
		
}