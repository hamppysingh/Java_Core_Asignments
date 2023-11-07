package SurpriseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public interface IoUtils {
	public static void Writemapinbinfile(Map<Integer,Customer> mp,String filename) throws FileNotFoundException, IOException
	{
		try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(filename))){
			oos.writeObject(mp);
		}
	}
	@SuppressWarnings("unchecked")
	public static Map<Integer,Customer> Readmapfrombinfile(String filename) 
	{
		try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(filename))){
			return (Map<Integer, Customer>)ois.readObject();
		}
		catch(Exception E) {
			E.printStackTrace();
		}
		return new HashMap<>();
		
	}
}
