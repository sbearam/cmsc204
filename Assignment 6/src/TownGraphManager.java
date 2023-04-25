import java.util.*;

public class TownGraphManager implements TownGraphManagerInterface
{
	protected Graph<Town,Road> tGraph = new Graph<Town,Road>();
	
	public boolean addRoad(String town1, String town2, int weight, String roadName)
	{
		Town t1 = getTown(town1);
		Town t2 = getTown(town2);
		if((tGraph.addEdge(t1, t2, weight, roadName) == null))
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	public String getRoad(String town1, String town2)
	{
		Town t1 = getTown(town1);
		Town t2 = getTown(town2);
		if(tGraph.getEdge(t1, t2) == null)
		{
			return null;
		}
		else
		{
			return tGraph.getEdge(t1, t2).getName();
		}
	}
	
	public boolean addTown(String v)
	{
		if(tGraph.addVertex(new Town(v)) == false)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public Town getTown(String name)
	{
		for(Town towns : tGraph.vertexSet())
		{
			if(towns.getName().equals(name))
			{
				return towns;
			}
		}
		return null;
	}
	
	public boolean containsTown(String v)
	{
		Town t = getTown(v);
		for(Town towns: tGraph.vertexSet())
		{
			if(towns.equals(t))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean containsRoadConnection(String town1, String town2)
	{
		Town t1 = getTown(town1);
		Town t2 = getTown(town2);
		for(Road roads: tGraph.edgeSet())
		{
			if(roads.equals(tGraph.getEdge(t1, t2)))
			{
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<String> allRoads()
	{
		ArrayList<String> roads = new ArrayList<>();
		//Set<Road> copyRd = new HashSet<Road>();
		for(Road r : tGraph.edgeSet())
		{
			roads.add(r.getName());
		}
		Collections.sort(roads);
		return roads;
	}
	
	public boolean deleteRoadConnection(String town1, String town2, String road)
	{
		Town t1 = getTown(town1);
		Town t2 = getTown(town2);
		if(containsRoadConnection(town1, town2))
		{
			tGraph.removeEdge(t1, t2, 0, road);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean deleteTown(String v)
	{
		Town t = getTown(v);
		if(containsTown(v))
		{
			tGraph.removeVertex(t);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public ArrayList<String> allTowns()
	{
		ArrayList<String> towns = new ArrayList<>();
		//Set<Road> copyRd = new HashSet<Road>();
		for(Town t : tGraph.vertexSet())
		{
			towns.add(t.getName());
		}
		Collections.sort(towns);
		return towns;
	}
	
	public ArrayList<String> getPath(String town1, String town2)
	{
		Town t1 = getTown(town1);
		Town t2 = getTown(town2);
		return tGraph.shortestPath(t1, t2);
	}
	
}
