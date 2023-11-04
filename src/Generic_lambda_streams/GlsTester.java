package Generic_lambda_streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GlsTester {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		List<Product> P= new ArrayList<>();
		P.addAll(ShopUtils.populateProductList());
		List<Student> S= new ArrayList<>();
		S.addAll(StudentCollectionUtils.populateList());
		Map<String,Student> SM= new HashMap<>();
		SM.putAll(StudentCollectionUtils.populateMap(S));
		boolean t=false;
		try{while(!t) {
			System.out.println(" Enter the choice to run the following queries:- ");
			System.out.println(" 1. Display the Product details (from Product list) ");
			System.out.println(" 2. Display all product names of a particular category , exceeding specific price. (from product list) ");
			System.out.println(" 3. Prompt user for category n discount. (from product map) ");
			System.out.println(" 4. Use  student based scenario.Display all Students ");
			System.out.println(" 5. Display all student details(list) sorted as per GPA (from product map) ");
			System.out.println(" 6. Write a tester to print average of  gpa of students for the specified course/subject ");
			System.out.println(" 7. Print name of specified subject topper ");
			System.out.println(" 8. Print no of  failures for the specified subject from the specified city ,chosen  from user. ");
			System.out.println(" 9. Given a List of strings, write a program to count the number of strings that start with a specific character using streams. ");
			System.out.println(" 0. Exit .... Your Choice : ");
			switch(sc.nextInt()) 
			{
				case 1: P.forEach(p->System.out.println(p));
						break;
				case 2:	Category cat=Category.valueOf(sc.next().toUpperCase());
						double price=sc.nextDouble();
						P.stream().filter(p->p.getProductCategory()==cat).filter(p->p.getPrice()>price).map(p->p.getName()).forEach(name-> System.out.println(name));
						break;
				case 3:	Category cat1=Category.valueOf(sc.next().toUpperCase());
						double discount=sc.nextDouble();
						P.stream().filter(p->p.getProductCategory()==cat1).forEach(p->{p.setPrice(p.getPrice()-discount);System.out.println(p);});
						break;
				case 4:	SM.values().stream().forEach(s->System.out.println(s));
						break;
				case 5: Comparator<? super Entry<String, Student>> comp=(e1,e2)->((Double)e1.getValue().getGpa()).compareTo(e2.getValue().getGpa());
						Map<String, Student> sortedMap = SM.entrySet().stream().sorted(comp).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1, e2) -> e2, LinkedHashMap::new));
						for (Map.Entry<String, Student> entry : sortedMap.entrySet()) {
						    Student value = entry.getValue();
						    System.out.println(" Student : " + value);
						};
						break;
				case 6: System.out.println(" Enter the subject whose average gpa you want to see : ");
						String sub=sc.next();
						double sum = SM.values().stream().filter(p -> p.getSubject().equals(Subject.valueOf(sub.toUpperCase()))).mapToDouble(p->p.getGpa()).sum();		
						int count= (int)SM.values().stream().filter(p -> p.getSubject()==Subject.valueOf(sub.toUpperCase())).count();
						System.out.println(" Average for the subject "+sub.toUpperCase()+" is : "+(sum/count));
						break;
				case 7: System.out.println(" Enter the subject whose Toppers name you want to see : ");
						String sub1=sc.next();
						double maxgpa=SM.values().stream().filter(p -> p.getSubject().equals(Subject.valueOf(sub1.toUpperCase()))).mapToDouble(p->p.getGpa()).max().orElseThrow();
						SM.values().stream().filter(p -> p.getGpa()== maxgpa).forEach(p -> System.out.println(p.getName()+" "+p.getGpa()));
						break;
				case 8: System.out.println(" Enter the subject whose failure count you want to see : ");
						String sub3=sc.next();
						System.out.println(SM.values().stream().filter(p -> p.getSubject().equals(Subject.valueOf(sub3.toUpperCase()))).filter(p -> p.getGpa()<5).count());
						break;
				case 9: System.out.println(" Enter the subject whose failure count you want to see : ");
						System.out.println(P.stream().filter(s -> s.getName().startsWith("A")).count());
						break;
				case 0: t=true;
						break;
						
			}
		}}catch(Exception E)
		{	sc.nextLine();
			E.printStackTrace();
		}
		sc.close();
	}
}
