import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class Removedup {
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<>(Arrays.asList(2,4,3,1,5,22,25,23,2,1,4,5,77,45,25));
		Set<Integer> m=new HashSet<>(list);
		list.clear();
		list.addAll(m);
		list.forEach(System.out::println);
	}
}
