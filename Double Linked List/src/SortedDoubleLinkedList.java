import java.util.*;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>
{
	Comparator<T> comparison;
	Node curr;
	Node newNode, previous;
	boolean success = false;
	SortedDoubleLinkedList(Comparator<T> comperableObject)
	{
		comparison = comperableObject; 
	}
	
	public void add(T data)
	{
		newNode = new Node(data);
		if(this.size ==  0)
		{
			super.addToFront(data);
			tail = newNode;
			head = newNode;
		}
		else if(comparison.compare(data, head.data) == 0)
		{
			super.addToFront(data);
		}
		else if(comparison.compare(data, head.data) < 0)
		{
			super.addToFront(data);
		}
		else if(comparison.compare(data, tail.data) == 0)
		{
			super.addToEnd(data);
		}
		else if(comparison.compare(data, tail.data) > 0)
		{
//			System.out.println("Bigger than tail: " + data);
			super.addToEnd(data);
		}
		else
		{
			curr = head.next;
//			System.out.println("Testing:" + data);
			do
			{
//				if(curr == tail)
//				{
//					tail.next = newNode;
//					newNode.prev = tail;
//					newNode.next = head;
//					head.prev = newNode;
//					tail = newNode;
//					this.size++;
//					success = true;
//					break;
//				}
				if(comparison.compare(data, curr.data) == 0)
				{
					newNode.next = curr.next;
					curr.next = newNode;
					this.size++;
					success = true;
					break;
				}
				else if(comparison.compare(data, curr.data) < 0)
				{
//					newNode.prev = curr.prev;
//					curr.prev = newNode;
					curr.prev.next = newNode;
					newNode.next = curr;
					newNode.prev = curr.prev;
					curr.prev = newNode;
					this.size++;
					success = true;
					break;
				}
				else if(comparison.compare(data,curr.data) > 0)
				{
//					newNode.next = curr.next;
//					newNode.prev = curr;
//					curr.next = newNode;
					curr.prev.next = newNode;
					newNode.next = curr;
					newNode.prev = curr.prev;
					curr.prev = newNode;
					this.size++;
					success = true;
					break;
				}
				previous = curr;
				curr = curr.next;
			} while(success == false);
		}
		
//		if(this.size > 3)
//		{
//			System.out.println("Head: " + head.data);
//			System.out.println("head.next " + head.next.data);
//			System.out.println("head.next.next " + head.next.next.data);
//			//System.out.println("tail.prev " + tail.prev.data);
//			System.out.println("Tail: " + tail.data);
//			System.out.println("----------------------");
//			System.out.println("Head: " + head.data);
//			System.out.println("tail.prev.prev " + tail.prev.prev.data);
//			System.out.println("tail.prev " + tail.prev.data);
//			System.out.println("Tail: " + tail.data);
//		}
		
		
		
	}
	
	public void addToEnd(T data) throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException();
	}
	
	public void addToFront(T data) throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException();
	}
	
	public ListIterator<T> iterator()
	{
		return super.iterator();
	}
	
	public Node remove(T data, Comparator<T> comparator)
	{
		return super.remove(data, comparator);
	}
}
