import java.util.*;
import java.io.*;
public class CourseDBManager implements CourseDBManagerInterface
{
	public void add(String id, int crn, int credits, String roomNum, String instructor)
	{
		CourseDBStructure.add(id, crn, credits, roomNum, instructor);
	}
	
	public CourseDBElement get(int crn)
	{
		
	}
	
	public void readFile(File input) throws FileNotFoundException
	{
		
	}
	
	public ArrayList<String> showAll();
 }
