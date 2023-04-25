public class Road extends Object implements Comparable<Road>
{
	private Town destination, source;
	private String name = null;
	private int weight = 1;
	Road(Town source, Town destination, int degrees, String name)
	{
		this.source = source;
		this.destination = destination;
		this.name = name;
		this.weight = degrees;
	}
	
	Road(Town source, Town destination, String name)
	{
		this.source = source;
		this.destination = destination;
		this.name = name;
	}
	
	public boolean contains(Town town)
	{
//		if(town == null)
//		{
//			return false;
//		}
		if(source.getName().equals(town.getName()) || destination.getName().equals(town.getName()))
		{
			return true;
		}
		return false;
	}
	
	public String toString()
	{
		return this.name + " is " + weight + " miles long, and connects "  + this.destination.getName() + " and " + this.source.getName();
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public Town getDestination()
	{
		return this.destination;
	}
	
	public Town getSource()
	{
		return this.source;
	}
	
	public int compareTo(Road o)
	{
		int status = 1;
		if(this.name == o.name)
		{
			status = 0;
		}
		return status;
	}
	
	public int getWeight()
	{
		return this.weight;
	}
	
	public boolean equals(Object r)
	{
		if (source.equals(((Road) r).getSource()) && destination.equals(((Road) r).getDestination())) 
		{
			return true;
		}
		return false;
	}
}
