package Serialize_deserialise;

import static Serialize_deserialise.Io_serial_Utils.restoreProductDetails;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

import Generic_lambda_streams.Product;
import Generic_lambda_streams.ShopUtils;
import Generic_lambda_streams.Student;
import Generic_lambda_streams.StudentCollectionUtils;
import Generic_lambda_streams.Subject;


public class Io_serial_Tester {

	public static void main(String[] args) throws IOException,FileNotFoundException,ClassNotFoundException{
		boolean t=false;
		Map<Integer, Product> PM = ShopUtils.populateProductMap(ShopUtils.populateProductList());
		Map<String, Student> SM = StudentCollectionUtils.populateMap(StudentCollectionUtils.populateList());
			try(Scanner sc = new Scanner(System.in)){
				Io_serial_Utils.storeProductDetails(PM,"Product");
				Io_serial_Utils.storeStudentDetails(SM,"Student");	
			while(!t) {
				System.out.println(" Enter the choice to run the following queries:- ");
				System.out.println(" 1. Display all Product ");
				System.out.println(" 2. Display all Student ");
				System.out.println(" 3. Cancel Admission ");
				System.out.println(" 4. Store student details of given subject and city ");
				System.out.println(" 5. Store passed student details(GPA > 6)  as per the specified subject n city , sorted as per DoB , in a text file using buffer.");
				System.out.println(" 0. Exit ");
				System.out.println(" Files you have for Reading { Student ,Product } : ");
				switch(sc.nextInt()) 
				{
					case 1:	System.out.println(" Here are your P details...\n");
							Map<Integer,Product> NP=new HashMap<>(restoreProductDetails("Product"));
							NP.entrySet().forEach(m->System.out.println(m));
							break;
					case 2:	System.out.println(" Here are the Student details...\n");
							Map<String,Student> NS= new HashMap<>(Io_serial_Utils.restoreStudentDetails("Student"));
							NS.entrySet().forEach(s->System.out.println(s));
							break;
					case 3: System.out.println("Enter file name");
							String filename=sc.next();
							System.out.println(" Enter the roll number you want to remove or cancel: ");
							String Rollnum=sc.next().toLowerCase();
							Map<String,Student> stu=SM.entrySet().stream().filter(k->!(k.getValue().getRollNo().equals(Rollnum))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1, e2) -> e2, LinkedHashMap::new));
							Io_serial_Utils.storeStudentDetails(stu,filename);
							System.out.println("Stored Student details in "+filename+" ....\n Here are your Stored details...\n");
							Map<String,Student> case3= new HashMap<>(Io_serial_Utils.restoreStudentDetails(filename));
							case3.entrySet().forEach(s->System.out.println(s));
							break;
					case 4: System.out.println("Enter file name");
							String filename1=sc.next();
							System.out.println(" Enter the Student's Subject and city whose details you want to see : ");
							Subject Sub=Subject.valueOf(sc.next().toUpperCase());
							String city=sc.next().toLowerCase();
							Map<String,Student> stu1=SM.entrySet().stream().filter(k->k.getValue().getSubject().equals(Sub)&&k.getValue().getAddress().getCity().equals(city)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1, e2) -> e2, LinkedHashMap::new));
							Io_serial_Utils.storeStudentDetails(stu1,filename1);
							System.out.println("Stored Student details in "+filename1+" ....\n Here are your Stored details...\n");
							Map<String,Student> case4= new HashMap<>(Io_serial_Utils.restoreStudentDetails(filename1));
							case4.entrySet().forEach(s->System.out.println(s));
							break;				
					case 5: System.out.println("Enter file name");
							String filename2=sc.next();
							System.out.println(" Enter the Student's Subject and city whose details you want to see : ");
							Subject Sub1=Subject.valueOf(sc.next().toUpperCase());
							String city1=sc.next().toLowerCase();
							Comparator<? super Entry<String,Student>> comp=(e1,e2)->(e1.getValue().getDob().compareTo(e2.getValue().getDob()));
							Map<String,Student> stu2=SM.entrySet().stream().filter(k->k.getValue().getSubject().equals(Sub1)&&k.getValue().getAddress().getCity().equals(city1)&&(k.getValue().getGpa()>6)).sorted(comp).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1, e2) -> e2, LinkedHashMap::new));
							Io_serial_Utils.storeStudentDetails(stu2,filename2);
							System.out.println("Stored Student details in "+filename2+" ....\n Here are your Stored details...\n");
							Map<String,Student> case5= new HashMap<>(Io_serial_Utils.restoreStudentDetails(filename2));
							case5.entrySet().forEach(s->System.out.println(s));
							break;	
					case 0: t=true;
							break;
				}
				
			} 	
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	
		System.out.println("main over...");
	}

}