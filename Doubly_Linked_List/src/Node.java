/*
 * @author Ben Weibel weibelben@gmail.com
 * Doubly linked list node. 
 */
public class Node<E>
{
	E val;
	Node<E> next;
	Node<E> prev;
	
	Node(E val) 
	{ 
		this.val = val; 
		next = null; 
		prev = null;
	}
	
	Node<E> next()
	{
		return next;
	}
	
	Node<E> prev()
	{
		return prev;
	}
	
	void print()
	{
		System.out.println("\t[" + val + "]");
	}
}
