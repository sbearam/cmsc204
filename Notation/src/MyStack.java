import java.util.*;

public class MyStack<T> implements StackInterface<T> 
{
	/**
	 * Provide two constructors
	 * 1. takes in an int as the size of the stack
	 * 2. default constructor - uses default as the size of the stack
	 */
	int maxSize = 0;
	int currentSize = 0;
	Stack<T> myStack;
	
	public MyStack(int size)
	{
		myStack = new Stack<T>();
		maxSize = size;
		myStack.setSize(maxSize);
		this.currentSize = 0;
	}
	
	public MyStack()
	{
		myStack = new Stack<T>();
		maxSize = 30;
		myStack.setSize(maxSize);
		this.currentSize = 0;
	}
	
	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	public boolean isEmpty()
	{
		if(this.currentSize == 0)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	public boolean isFull()
	{
		/* int i = 0;
		while(i < myStack.size())
		{
			if(myStack.get(i) == null)
			{
				return false;
			}
			i++;
		}
		return true; */
		if(this.currentSize == maxSize)
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}

	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	
	public T pop() throws StackUnderflowException
	{
		if(this.currentSize == 0)
		{
			throw new StackUnderflowException();
		}
		else
		{
			T top = myStack.pop();
			myStack.remove(this.currentSize - 1);
			this.currentSize--;
			return top;
		}
		
	}
	
	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	public T top() throws StackUnderflowException
	{
		if(isEmpty())
		{
			throw new StackUnderflowException();
		}
		else
		{
			return myStack.peek();
		}
	}
	
	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	public int size()
	{
		/*int i = 0;
		while(i < myStack.size())
		{
			if(myStack.get(i) == null)
			{
				continue;
			}
			i++;
		}
		return i; */
		return this.currentSize;
	}
	
	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 * @throws StackOverflowException if stack is full
	 */
	public boolean push(T e) throws StackOverflowException
	{
		boolean status = false;
		if(isFull())
		{
			throw new StackOverflowException();
		}
		else
		{
			myStack.add(e);
			this.currentSize++;
			status = true;
		}
		return status;
		
	}
	
	
	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	public String toString()
	{
		/*int i = 0;
		String items = "";
		while(i < this.currentSize)
		{
			if(myStack.get(i) == null)
			{
				continue;
			}
			items += myStack.get(i) + " ";
			i++;
		}
		return items; */
		
		String items = "";
		for(T i : myStack)
		{
			if(i != null)
			{
				items += i;
			}
			
		}
		return items;
	}
	
	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	public String toString(String delimiter)
	{
		String items = "";
		int count = 0;
		for (T i : myStack)
		{
			if(i != null)
			{
				if(count == myStack.size() - 1)
				{
					items += i;
				}
				else
				{
					items += i + delimiter;
					
				}
				
			}
			count++;
		}
		return items;
	}
	
	
	 /**
	  * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
	  * is the first bottom element of the Stack
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE STACK, if you use the
	  * list reference within your Stack, you will be allowing direct access to the data of
	  * your Stack causing a possible security breech.
	  * @param list elements to be added to the Stack from bottom to top
	  * @throws StackOverflowException if stack gets full
	  */
	public void fill(ArrayList<T> list) throws StackOverflowException
	{
		ArrayList<T> dummyList;
		dummyList = new ArrayList<T>(list);
		for(int i = 0; i < dummyList.size(); i++)
		{
			if(isFull())
			{
				throw new StackOverflowException();
			}
			push(dummyList.get(i));
			this.currentSize = dummyList.size();
		} 
	}
}
