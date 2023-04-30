import java.util.*;
public class CarQueue 
{
	private Queue<Integer> myQ;
	private Random r = new Random();
	CarQueue()
	{
		myQ = new LinkedList<>(); 
		myQ.add(r.nextInt(4));
		myQ.add(r.nextInt(4));
		myQ.add(r.nextInt(4));
		myQ.add(r.nextInt(4));
		myQ.add(r.nextInt(4));
		myQ.add(r.nextInt(4));
		//System.out.println(myQ);
	}
	
	public void addToQueue()
	{
		class add implements Runnable
		{
			public void run()
			{
				while(true)
				{
					myQ.add(r.nextInt(4));
					try
					{
						Thread.sleep(4000);
					} catch(InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			}
		}
		add runObj = new add();
		Thread t = new Thread(runObj);
		t.start();
		
	}
	
	public int deleteQueue()
	{
		return myQ.remove();
	}
}
