import java.util.*;
import java.io.*;
public class CourseDBManager implements CourseDBManagerInterface
{
	//LinkedList<CourseDBStructure> structList = new LinkedList();
	CourseDBStructure structList = new CourseDBStructure(15);
	//LinkedList<CourseDBElement> elementList;
	CourseDBElement elements;
	
	public void add(String id, int crn, int credits, String roomNum, String instructor)
	{
		//elementList = new LinkedList();
		elements = new CourseDBElement(id, crn, credits, roomNum, instructor);
		structList.add(elements);
	}
	
	public CourseDBElement get(int crn)
	{
		CourseDBElement temp = null;
//		for(int i = 0; i < elementList.size(); i++)
//		{
//			if(elementList.get(i).getCRN() == crn)
//			{
//				temp =  elementList.get(i);
//			}
//		}
//		return temp;
		try 
		{
			temp = structList.get(crn);
		} 
		catch (IOException e) 
		{
			e.getMessage();
		}
		return temp;
	}
	
	public void readFile(File input) throws FileNotFoundException
	{
		Scanner fileReader = new Scanner(input);
		String id, roomNum, instructor;
		int crn, credits;
		String[] info;
		while(fileReader.hasNextLine())
		{
			info = fileReader.nextLine().split(" ", 5);
			id = info[0];
			crn = Integer.parseInt(info[1]);
			credits = Integer.parseInt(info[2]);
			roomNum = info[3];
			instructor = info[4];
			elements = new CourseDBElement(id, crn, credits, roomNum, instructor);
			structList.add(elements);
		}
		fileReader.close();
	}
	
	public ArrayList<String> showAll()
	{
		//System.out.println(structList.showAll().get(1));
		return structList.showAll();
	}
 }