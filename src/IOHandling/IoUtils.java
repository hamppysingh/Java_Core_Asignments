package IOHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import Generic_lambda_streams.Product;
import Generic_lambda_streams.Student;

public interface IoUtils {
	
	public static void Writeonlist(List<Product> list,String filename) throws IOException {
		PrintWriter pw=new PrintWriter(new FileWriter(filename));
		list.stream().forEach(pw::println);
		pw.close();
	}
	public static void Writeonmap(Map<String,Student> SM,String filename) throws IOException {
		PrintWriter pw=new PrintWriter(new FileWriter(filename));
		SM.entrySet().forEach(pw::println);
		pw.close();
	}
	public static void DisplayDetails(String filename) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader(filename));
		br.lines().forEach(System.out::println);
		br.close();
	}
}