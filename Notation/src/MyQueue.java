import java.util.*;

 class MyQueue<T> implements QueueInterface<T> 
{
	 
	 Queue<T> myQueue = new LinkedList<T>();
	 int maxSize = 0;
	 int currentSize = 0;
	 /** provide two constructors 
		 * 1. takes an int as the size of the queue
		 * 2. default constructor - uses a default as the size of the queue
		 * 
		 */
	 public MyQueue(int size)
	 {
		 this.maxSize = size;
	 }
	 
	 public MyQueue()
	 {
		 this.maxSize = 30;
	 }
	 
		/**
		 * Determines if Queue is empty
		 * @return true if Queue is empty, false if not
		 */
		public boolean isEmpty()
		{
			return myQueue.isEmpty();
		}

		/**
		 * Determines of the Queue is Full
		 * @return true if Queue is full, false if not
		 */
		public boolean isFull()
		{
			if(this.currentSize == this.maxSize)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		/**
		 * Deletes and returns the element at the front of the Queue
		 * @return the element at the front of the Queue
		 * @throws QueueUnderflowException if queue is empty
		 */
		public T dequeue() throws QueueUnderflowException
		{
			if(isEmpty())
			{
				throw new QueueUnderflowException();
			}
			else
			{
				T top = myQueue.peek();
				myQueue.remove();
				this.currentSize--;
				return top;
			}
		}

		/**
		 * Returns number of elements in the Queue
		 * @return the number of elements in the Queue
		 */
		public int size()
		{
			return this.currentSize;
		}
		
		/**
		 * Adds an element to the end of the Queue
		 * @param e the element to add to the end of the Queue
		 * @return true if the add was successful
		 * @throws QueueOverflowException if queue is full
		 */
		public boolean enqueue(T e) throws QueueOverflowException
		{
			boolean added = false;
			if(isFull())
			{
				throw new QueueOverflowException();
			}
			else
			{
				myQueue.add(e);
				this.currentSize++;
				added = true;
			}
			return added;
		}
		
		
		/**
		 * Returns the string representation of the elements in the Queue, 
		 * the beginning of the string is the front of the queue
		 * @return string representation of the Queue with elements
		 */
		public String toString()
		{
			String items = "";
			for(T i : myQueue)
			{
				items += i;
			}
			return items;
		}
		
		/**
		 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
		 * Place the delimiter between all elements of the Queue
		 * @return string representation of the Queue with elements separated with the delimiter
		 */
		public String toString(String delimiter)
		{
			String items = "";
			int count = 0;
			for (T i : myQueue)
			{
				if(count == myQueue.size() - 1)
				{
					items += i;
				}
				else
				{
					items += i + delimiter;
					count++;
				}
				
			}
			return items;
		}
		
		 /**
		  * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
		  * is the first element in the Queue
		  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE QUEUE, if you use the
		  * list reference within your Queue, you will be allowing direct access to the data of
		  * your Queue causing a possible security breech.
		  * @param list elements to be added to the Queue
		  * @throws QueueOverflowException if queue is full
		 
		  */
		public void fill(ArrayList<T> list) throws QueueOverflowException
		{
			ArrayList<T> dummyList;
			dummyList = new ArrayList<T>(list);
			for(int i = 0; i < dummyList.size(); i++)
			{
				if(isFull())
				{
					throw new QueueOverflowException();
				}
				myQueue.add(dummyList.get(i));
				this.currentSize++;
			}
		}
}
