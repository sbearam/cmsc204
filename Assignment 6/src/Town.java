/** @author Shawn Bearam Jr.  */

public class Town extends Object implements Comparable<Town>
{
	protected String name = null;
	
	Town(String name)
	{
		this.name = name;
		//System.out.println("Name: " + this.name);
	}
	
	Town(Town templateTown)
	{
		this(templateTown.getName());
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int compareTo(Town o)
	{
		int status = 1;
		if(this.name == o.name)
		{
			status = 0;
		}
		return status;
	}
	
	public String toString()
	{
		return "Town " + this.getName();
	}
	
	public int hashCode()
	{
		return this.name.hashCode();
	}
	
	public boolean equals(Object obj)
	{
		if(obj == null)
		{
			return false;
		}
		if(((Town)obj).getName().equals(this.name))
		{
			return true;
		}
		return false;
	}
}
