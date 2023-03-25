import java.util.*;

public class CourseDBStructure implements CourseDBStructureInterface
{
	
	final double lFactor = 1.5;
	int tableLength = 0;
	
	CourseDBStructure(int n)
	{
		boolean nextFound = false;
		int result = (int) ((int)n/lFactor);
		if(result <= 1)
		{
			tableLength = 2;
		}
		while(!nextFound)
		{
			result++;
			if(is4KPrime(result))
			{
				nextFound = true;
				tableLength = result;
			}
		}
	}
	
	public void add(CourseDBElement element)
	{
		
	}
	
	public CourseDBElement get(int crn) throws IOException
	{
		
	}
	
	public ArrayList<String> showAll()
	{
		
	}
	
	public int getTableSize()
	{
		
	}
	
	public boolean isPrime(int n)
	{
		if(n <= 1)
		{
			return false;
		}
		if(n <= 3)
		{
			return true;
		}
		if(n % 2 == 0 || n % 3 == 0)
		{
			return false;
		}
		for(int i = 5; i <= n; i+=2)
		{
			if(n % i == 0)
			{
				return false;
			}
		}
		return true;
	}
	
	public boolean is4KPrime(int n)
	{
		boolean is4KPrime = false;
		if(isPrime(n))
		{
			if(((n - 3)%4) == 0)
			{
				is4KPrime = true;
			}
		}
		return is4KPrime;
	}
	
	public int next4KPrime(int n)
	{
		boolean isFound = false;
		if(is4KPrime(n))
		{
			while(!isFound)
			{
				
			}
		}
	}
}
