import java.util.*;

public class BasicDoubleLinkedList<T> extends Object implements Iterable<T>
{
	protected int size;
	protected LinkedList<T> link;
	Node head, tail;
	//BasicDoubleLinkedList<T> d = new BasicDoubleLinkedList<T>();
	BasicDoubleLinkedList<T>.Node n = new Node();
	BasicDoubleLinkedList()
	{
		link = new LinkedList<T>();
		this.size = 0;
		head = null;
		tail = null;
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	public void addToEnd(T data)
	{
		Node newNode = new Node(data);
		if(this.size == 0) 
		{
			head = newNode;
			tail = newNode;
		}
		else
		{
			newNode.prev = tail;
			tail.next = newNode;
			//newNode.prev = tail;
			tail = newNode;
		}
		/*System.out.println("Tail: " + tail.data);
		if(this.size != 0)
		{
			System.out.println("Prev tail: " + tail.prev.data);
		}*/
		this.size++;
	}
	
	public void addToFront(T data)
	{
		Node newNode = new Node(data);
		//Node temp = new Node();
		if(this.size == 0)
		{
			head = newNode;
			tail = newNode;
		}
		else
		{
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		this.size++;
	}
	
	public T getFirst()
	{
		if(this.size > 0)
		{
			return head.data;
		}
		else
		{
			return null;
		}
	}
	
	public T getLast()
	{
		if(this.size > 0)
		{
			return tail.data;
		}
		else
		{
			return null;
		}
	}
	
	public ListIterator<T> iterator()
	{
		return new DoubleLinkedListIterator();
	}
	
	public Node remove(T targetData, Comparator<T> comparator)
	{
		Node dataF = null;
		Node curr = null;
		//Node previous = null;
		//boolean success = false;
		if(this.size == 1)
		{
			if (comparator.compare(head.data, targetData) == 0)
			{
				dataF = head;
				head = null;
				tail = null;
				this.size--;
				return dataF;
			}
			else
			{
				return null;
			}
		}
		else if(this.size == 0)
		{
			return null;
		}
		else
		{
			curr = head;
			do
			{
				if(comparator.compare(targetData, curr.data) == 0)
				{
					if(comparator.compare(targetData, head.data) == 0)
					{
						head = curr.next;
						curr.next.prev = null;
						this.size--;
					}
					else if(comparator.compare(targetData, tail.data) == 0)
					{
						tail = curr.prev;
						curr.prev.next = null;
						this.size--;
					}
					else
					{
						curr.prev.next = curr.next;
						curr.next.prev = curr.prev;
						this.size--;
					}
					dataF = curr;
					break;
				}
				curr = curr.next;
			}while(curr != null);
		}
		return dataF;
	}
	
	public T retrieveFirstElement()
	{
		if(this.size > 0)
		{
			if(this.size == 1)
			{
				T firstEl = head.data;
				head = null;
				tail = null;
				this.size--;
				return firstEl;
			}
			T firstEl = head.data;
			head = head.next;
			this.size--;
			return firstEl;
		}
		else
		{
			return null;
		}
	}
	
	public T retrieveLastElement()
	{
		if(this.size > 0)
		{
			if(this.size == 1)
			{
				T lastEl = tail.data;
				head = null;
				tail = null;
				this.size--;
				return lastEl;
			}
			T lastEl = tail.data;
			tail = tail.prev;
			this.size--;
			return lastEl;
		}
		else
		{
			return null;
		}
	}
	
	public ArrayList<T> toArrayList()
	{
		ArrayList<T> copy = new ArrayList<T>();
		ListIterator<T> i = iterator();
		if(this.size == 1)
		{
			copy.add(head.data);
		}
		else
		{
			while(i.hasNext())
			{
				copy.add(i.next());
			}
		}
		return copy;
		
	}
	
	public class Node extends Object
	{
		protected T data;
		protected Node prev;
		protected Node next;
		
		Node()
		{
			this.data = null;
			this.prev = null;
			this.next = null;
		}
		
		public Node (T dataNode)
		{
			this.data = dataNode;
		}
	}
	
	public class DoubleLinkedListIterator extends Object implements ListIterator<T>
	{
		//protected Node head;
		protected Node prev;
		protected Node current;
		
		DoubleLinkedListIterator()
		{
			prev = null;
			current = head;
		}
		
		public boolean hasNext()
		{
			if(current != null)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		public T next() throws NoSuchElementException
		{
			if(!hasNext())
			{
				throw new NoSuchElementException();
			}
			else
			{
				prev = current;
				current = current.next;
			}
			return prev.data;
		}
		
		public boolean hasPrevious()
		{
			if(prev != null)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		public T previous() throws NoSuchElementException
		{
			if(!hasPrevious())
			{
				throw new NoSuchElementException();
			}
			else
			{
				current = prev;
				prev = prev.prev;
			}
			return current.data;
		}
		
		public void remove() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}
		
		public void add (T arg0) throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}
		
		public int nextIndex() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}
		
		public int previousIndex() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}
		
		public void set(T arg0) throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}
	}
}
