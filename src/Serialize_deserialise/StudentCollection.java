package Serialize_deserialise;

import static java.time.LocalDate.parse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Generic_lambda_streams.Address;
import Generic_lambda_streams.Student;
import Generic_lambda_streams.Subject;

public interface StudentCollection {
	 public static List<Student> populateList() {
			List<Student> students = new ArrayList<>(
					Arrays.asList(new Student("dac-001", "ravi", parse("1990-12-13"), Subject.ANGULAR, 3.2),
							new Student("dac-009", "riya", parse("1992-12-13"), Subject.REACT, 6.9),
							new Student("dac-004", "shekhar", parse("1991-12-13"), Subject.DBT, 8.9),
							new Student("dac-002", "priya", parse("1990-02-23"), Subject.JAVA, 7.7),
							new Student("dac-007", "kiran", parse("1993-02-13"), Subject.DBT, 8.1),
							new Student("dac-003", "meeta", parse("1993-12-13"), Subject.DBT, 7.9),
							new Student("dac-008", "sameer", parse("1991-12-06"), Subject.JAVA, 8.2)));
			List<Address> adrs = Arrays.asList(new Address("pune", "MH", "452446"), new Address("pune", "MH", "652446"),
					new Address("nagpur", "MH", "852446"), new Address("indore", "MP", "752446"),
					new Address("mumbai", "MH", "672446"), new Address("pune", "MH", "692446"),
					new Address("chennai", "TN", "862446"));
			students.forEach(s -> 
			{    int i = 0;
				 s.assignAddress(adrs.get(i++));
			});
			return students;// rets populated growable list of students with adr
		}

		// add a static method to accept list of student details & rets a map populated with the same
		public static Map<String, Student> populateMap(List<Student> list) {
			HashMap<String, Student> hm = new HashMap<>();
			list.forEach(s -> hm.put(s.getRollNo(), s));
			return hm;

		}
}
