import java.io.*;
import java.util.*;
import java.lang.*;

public class CourseDBStructure implements CourseDBStructureInterface
{
	
	final double lFactor = 1.5;
	int tableLength = 0;
	int numOfElements = 0;
	LinkedList<CourseDBElement>[] hTable;
	
	CourseDBStructure(int n)
	{
		boolean nextFound = false;
		int result = (int) ((int)n/lFactor);
		if(result <= 1)
		{
			tableLength = 2;
		}
		if(result % 2 == 0)
		{
			result++;
		}
		while(!nextFound)
		{
			if(is4KPrime(result))
			{
				nextFound = true;
				tableLength = result;
			}
			result += 2;
		}
		hTable = new LinkedList[tableLength];
	}
	 
	public CourseDBStructure(String string, int i) 
	{
		tableLength = i;
		hTable = new LinkedList[tableLength];
	}

	public void add(CourseDBElement element)
	{
		LinkedList<CourseDBElement> list;
		String crn = String.valueOf(element.crn);
		int hashCode = crn.hashCode();
		int hashIndex = hashCode % tableLength;
		while(hashIndex >= tableLength)
		{
			hashIndex %= tableLength;
		}
		//list = hTable[hashIndex];
		if(hTable[hashIndex] == null || numOfElements == 0)
		{
			hTable[hashIndex] = new LinkedList<CourseDBElement>();
			hTable[hashIndex].add(element);
			numOfElements++;
		}
		else if((hTable[hashIndex].get(0).getCRN() == element.getCRN()))
		{
//			System.out.println("Same crn");
			hTable[hashIndex].set(0, element);
		}
		else
		{
			hTable[hashIndex].add(element);
			numOfElements++;
		}
//		System.out.println(showAll().size());
//		System.out.println("Hashcode: " + hashCode);
//		System.out.println("Hash Index: " + hashIndex);
//		System.out.println("-------------");
		
	}
	
	public CourseDBElement get(int crn) throws IOException
	{
		String Scrn = String.valueOf(crn);
		int hashCode = Scrn.hashCode();
		int hashIndex = hashCode % tableLength;
		while(hashIndex >= tableLength)
		{
			hashIndex %= tableLength;
		}
		if(hTable[hashIndex] == (null))
		{
			throw new IOException();
		}
		else
		{
			return hTable[hashIndex].get(0);
		}
	}
	
	public ArrayList<String> showAll()
	{
		ArrayList<String> c = new ArrayList<>();
		String s = "";
		CourseDBElement e;
		for(int i = 0; i < tableLength; i++)
		{
			if(hTable[i] == null)
			{
				continue;
			}
			else
			{
				for(int b = 0; b < hTable[i].size(); b++)
				{
					e = (CourseDBElement)hTable[i].get(b);
					s = e.toString();
					c.add("\n" + s);
					//System.out.println(s);
				}
			}
		}
		return c;
	}
	
	
	public int getTableSize()
	{
		return tableLength;
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
		for(int i = 5; i >= n; i+=2)
		{
			//System.out.println("isPrime for loop is running");
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
	
	/*private int hashCode(String s)
	{
		int hashCode = 0;
		int g = 0;
		int size = s.length();
		for (int i = 0; i < size; i++)
		{
			g = (int)Math.pow(31, (size-(i+1)));
		    hashCode = g * hashCode + s.charAt(i);
		}
		return hashCode;
	}*/
	
}