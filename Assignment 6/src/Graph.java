/** @author Shawn Bearam Jr.  */
import java.util.*;

public class Graph<E,V> implements GraphInterface<Town, Road>
{
	protected Set<Road> rd = new HashSet<Road>(); 
	protected Set<Town> tn = new HashSet<Town>();
	//protected Map<Town, Town> pNode = new HashMap<>();
	protected Map<String, Town> map = new HashMap<>();
	
	public Road getEdge(Town sourceVertex, Town destinationVertex)
	{
		Road edge = null;
		for(Road r : rd)
		{
			if(r.contains(sourceVertex) && r.contains(destinationVertex))
			{
				edge = r;
				return new Road(sourceVertex, destinationVertex, r.getWeight(), r.getName());
			}
		}
		return edge;
	}
	
	 public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description)
	 {
		 if(!containsVertex(sourceVertex) || !containsVertex(destinationVertex))
		 {
			 throw new IllegalArgumentException();
		 }
		 if(sourceVertex == null || destinationVertex == null)
		 {
			 throw new NullPointerException();
		 }
		 else
		 {
			 Road r = new Road(sourceVertex, destinationVertex, weight, description);
			 rd.add(r);
			 return r;
		 }
	 }
	 
	 public boolean addVertex(Town v)
	 {
		 if(!(tn.contains(v)))
		 {
			 if(v.equals(null))
			 {
				 throw new NullPointerException();
			 }
			 else
			 {
				 tn.add(v);
				 return true;
			 }
		 }
		 else
		 {
			 return false;
		 }
	 }
	 
	 public boolean containsEdge(Town sourceVertex, Town destinationVertex)
	 {
		 boolean present = false;
			for(Road r : rd)
			{
				if(r.contains(sourceVertex) && r.contains(destinationVertex))
				{
					present = true;
				}
			}
			return present;
	 }
	 
	 public boolean containsVertex(Town v)
	 {
		 if(tn.contains(v))
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
	 }
	 
	 public Set<Road> edgeSet()
	 {
		 Set<Road> copyRd = new HashSet<Road>();
		 for(Road roads : rd)
		 {
			 copyRd.add(roads);
		 }
		 return copyRd;
	 }
	 
	 public Set<Road> edgesOf(Town vertex)
	 {
		 Set<Road> edgesO = new HashSet<Road>();
		 if(!(tn.contains(vertex)))
		 {
			 throw new IllegalArgumentException();
		 }
		 else if(vertex.equals(null))
		 {
			 throw new NullPointerException();
		 }
		 else
		 {
			 for(Road r : rd)
			 {
				 if(r.contains(vertex))
				 {
					 edgesO.add(r);
				 }
			 }
		 }
		 return edgesO;
	 }
	 
	 public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description)
	 {
		 for(Road r : rd)
		 {
			 System.out.println("Ran");
			 if(r.contains(sourceVertex) && r.contains(destinationVertex))
			 {
				 if(weight <= -1 || description == "null")
				 {
					 return null;
				 }
				 else
				 {
					 rd.remove(r);
					 break;
				 }
			 }
		 }
		 return null;
	 }
	 
	 public boolean removeVertex(Town v)
	 {
		 if(v.equals(null))
		 {
			 return false;
		 }
		 else
		 {
			 return tn.remove(v);
		 }
	 }
	 
	 public Set<Town> vertexSet()
	 {
		 Set<Town> copyTn = new HashSet<Town>();
		 for(Town towns : tn)
		 {
			 copyTn.add(towns);
		 }
		 return copyTn;
		
	 }
	 
	 public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex)
	 {
		 dijkstraShortestPath(sourceVertex);
		 ArrayList<String> sPath = new ArrayList<>();
		 Town cTown = destinationVertex;
		 Town pTown = null;
		 Road edge = null;
		 while(!(cTown.equals(sourceVertex)))
		 {
			//System.out.println("is running");
			 if(!(map.containsKey(cTown.getName())))
			 {
				 sPath.clear();
				 break;
			 }
			 pTown = map.get(cTown.getName());
			 if(pTown == null)
			 {
				 return sPath;
			 }
			 edge = getEdge(pTown, cTown);
			 sPath.add(0, pTown.getName() + " via " + edge.getName() + " to " + cTown.getName() + " " + edge.getWeight() + " mi");
			 cTown = pTown;
		 }
		 return sPath;
	 }
	 
	 public void dijkstraShortestPath(Town sourceVertex)
	 {
		 Set<Town> v = new HashSet<Town>();
		 HashMap<String, Integer> hMap = new HashMap<>();
		 ArrayList<Town> uV = new ArrayList<Town>();
		 int aD = 0;
		 int temp = 0;
		 Town uT = null;
		 Town cT = null;
		 Town aT = null;
		 for(Town towns : tn)
		 {
			 uV.add(towns);
			 map.put(towns.getName(), null);
			 hMap.put(towns.getName(), Integer.MAX_VALUE);
		 }
		 hMap.put(sourceVertex.getName(), 0);
		 while(!uV.isEmpty())
		 {
			 for(int i = 0; i < uV.size(); i++)
			 {
				 uT = uV.get(i);
				 if(hMap.get(uV.get(temp).getName()) > hMap.get(uT.getName()))
				 {
					 temp = i;
				 }
			 }
			 cT = uV.remove(temp);
			 v.add(cT);
			 for(Road road : edgesOf(cT))
			 {
				 aT  = road.getDestination();
				 if(cT.equals(aT))
				 {
					 aT = road.getSource();
				 }
				 if(!(v.contains(aT)))
				 {
					 aD = hMap.get(cT.getName()) + road.getWeight();
					 if(aD < hMap.get(aT.getName()))
					 {
						 hMap.put(aT.getName(), aD);
						 map.put(aT.getName(), cT);
					 }
				 }
			 }
			 temp = 0;
		 }
	 }
}
