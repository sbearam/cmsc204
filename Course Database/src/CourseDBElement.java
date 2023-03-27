import java.util.*;

public class CourseDBElement
{
	String id, roomNum, instructor;
	int crn, credits;
	//Comparator<T> c;
	
	CourseDBElement()
	{
		this.id = null;
		this.roomNum = null;
		this.instructor = null;
		this.crn = 0;
		this.credits = 0;
	}
	
	CourseDBElement(String id, int crn, int credits, String roomNum, String instructor)
	{
		this.id = id;
		this.crn = crn;
		this.credits = credits;
		this.roomNum = roomNum;
		this.instructor = instructor;
	}
	
	public String getID()
	{
		return this.id;
	}
	
	public void setID(String id)
	{
		this.id = id;
	}
	
	public String getRoomNum()
	{
		return this.roomNum;
	}
	
	public void setRoomNum(String roomNum)
	{
		this.roomNum = roomNum;
	}
	
	public int getCRN()
	{
		return this.crn;
	}

	public void setCRN(int crn) 
	{
		this.crn = crn;
	}
	
	public String getInstructor()
	{
		return this.instructor;
	}
	
	public void setInstructor(String instructor)
	{
		this.instructor = instructor;
	}
	
	public int getCredits()
	{
		return this.credits;
	}
	
	public void setCredits(int credits)
	{
		this.credits = credits;
	}
}