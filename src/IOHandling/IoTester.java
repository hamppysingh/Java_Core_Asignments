package IOHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

import Generic_lambda_streams.Category;
import Generic_lambda_streams.Product;
import Generic_lambda_streams.ShopUtils;
import Generic_lambda_streams.Student;
import Generic_lambda_streams.StudentCollectionUtils;
import Generic_lambda_streams.Subject;

public class IoTester {
	public static void main(String[] args) throws IOException {
		List<Product> P= new ArrayList<>();
		P.addAll(ShopUtils.populateProductList()); //Making product list
		List<Student> S= new ArrayList<>();
		S.addAll(StudentCollectionUtils.populateList());  //Student list 
		Map<String,Student> SM= new HashMap<>();
		SM.putAll(StudentCollectionUtils.populateMap(S));  //Map of Student
		IoUtils.Writeonlist(P, "Product1");
		IoUtils.Writeonmap(SM, "Student1");
		boolean t=false;
		try(Scanner sc =new Scanner(System.in)){while(!t) {		
			System.out.println(" Enter the choice to run the following queries:- ");
			System.out.println(" 1. Display all student details ");
			System.out.println(" 2. Cancel Admission ");
			System.out.println(" 3. Store student details of given subject and city ");
			System.out.println(" 4. Store passed student details(GPA > 6)  as per the specified subject n city , sorted as per DoB , in a text file using buffer.");
			System.out.println(" 0. Exit ");
			System.out.println(" Files you have for Reading { Student ,Product } :");
			switch(sc.nextInt()) 
			{
				case 1:	System.out.println(" Enter the File Name whose details you want to show: ");
						String filename=sc.next();
						IoUtils.DisplayDetails(filename);
						break;
				case 2: System.out.println(" Enter the roll number you want to remove or cancel: ");
						String Rollnum=sc.next().toLowerCase();
						Map<String,Student> stu=SM.entrySet().stream().filter(k->!(k.getValue().getRollNo().equals(Rollnum))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1, e2) -> e2, LinkedHashMap::new));
						IoUtils.Writeonmap(stu, "Case");
						IoUtils.DisplayDetails("Case");
						break;
				case 3: System.out.println(" Enter the Student's Subject and city whose details you want to see : ");
						Subject Sub=Subject.valueOf(sc.next().toUpperCase());
						String city=sc.next().toLowerCase();
						Map<String,Student> stu1=SM.entrySet().stream().filter(k->k.getValue().getSubject().equals(Sub)&&k.getValue().getAddress().getCity().equals(city)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1, e2) -> e2, LinkedHashMap::new));
						IoUtils.Writeonmap(stu1, "Case");
						IoUtils.DisplayDetails("Case");
						break;				
				case 4: System.out.println(" Enter the Student's Subject and city whose details you want to see : ");
						Subject Sub1=Subject.valueOf(sc.next().toUpperCase());
						String city1=sc.next().toLowerCase();
						Comparator<? super Entry<String,Student>> comp=(e1,e2)->(e1.getValue().getDob().compareTo(e2.getValue().getDob()));
						Map<String,Student> stu2=SM.entrySet().stream().filter(k->k.getValue().getSubject().equals(Sub1)&&k.getValue().getAddress().getCity().equals(city1)&&(k.getValue().getGpa()>6)).sorted(comp).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1, e2) -> e2, LinkedHashMap::new));
						IoUtils.Writeonmap(stu2, "Case");
						IoUtils.DisplayDetails("Case");
						break;	
				case 5:		
				case 0: t=true;
						break;
						
			}
		}}catch(Exception E)
		{		
			E.printStackTrace();
		}
	
	}
}
