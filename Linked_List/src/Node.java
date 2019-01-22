/*
 * @author Ben Weibel weibelben@gmail.com
 * Singly linked list node. 
 */
public class Node<E>
{
	E val;
	Node<E> next;
	
	Node(E val) 
	{ 
		this.val = val; 
		next = null; 
	}
	
	Node<E> next()
	{
		return next;
	}
	
	void print()
	{
		System.out.println("\t[" + val + "]");
	}
}
