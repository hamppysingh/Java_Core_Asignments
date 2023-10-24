public class MathOperation {
	public int add(int a,int b)
	{
		return a+b;
	}
	public int add(int a,double b)
	{
		return a+(int)b;
	}
	public int add(double a, double b)
	{
		return (int)a+(int)b;
	}
	public int add(int.../*know as varargs */ num)
	{	int sum=0;
		for(int i:num)
			sum+=i;
		return sum;
	}
}
