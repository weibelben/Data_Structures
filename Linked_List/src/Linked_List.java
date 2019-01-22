/*
 * @author Ben Weibel weibelben@gmail.com
 * Singly linked list. 
 */
public class Linked_List<E> 
{
	private Node<E> head;
	private int num_nodes;
	
	/* 
	 * constructor, starts the list with 1 node.
	 */
	public Linked_List(Node<E> node)
	{
		this.head = node;
		this.num_nodes = 1;
	}
	
	/*
	 * number of elements in the list
	 */
	public int size()
	{
		return num_nodes;
	}
	
	/*
	 * adds a node to the end of the list
	 */
	public void add_node(Node<E> node)
	{
		Node<E> curr = head;
		for (int i = 0; i < num_nodes - 1; i++)
		{
			curr = curr.next();
		}
		
		num_nodes++;
		curr.next = node;
	}
	
	/*
	 * adds a node at a specified index
	 */
	public void add_node(Node<E> node, int index) throws OutOfBoundsException
	{
		if (index < 0 || index > num_nodes)
		{
			throw new OutOfBoundsException("Attempt to add a node to a "
					+ "non-existing index.");
		}
		
		if (index == 0)
		{
			node.next = head;
			head = node;
		}
		else
		{
			Node<E> curr = head;
			for (int i = 0; i < index - 1; i++)
			{
				curr = curr.next;
			}
		
			node.next = curr.next;
			curr.next = node;
		}
		
		num_nodes++;
	}
	
	/*
	 * removes a node at a specific index
	 */
	public Node<E> remove_node(int index) throws OutOfBoundsException
	{
		if (index < 0 || index > num_nodes - 1)
		{
			throw new OutOfBoundsException("Attempt to remove a node to a "
					+ "non-existing index.");
		}
		
		if (index == 0)
		{
			Node<E> node = head;
			head = head.next;
			
			num_nodes--;
			return node;
		}
		
		Node<E> curr = head;
		for (int i = 0; i < index - 1; i++)
		{
			curr = curr.next;
		}
		
		Node<E> node = curr.next;
		curr.next = curr.next.next;

		num_nodes--;
		return node;
	}
	
	/*
	 * removes a node from the end of the list
	 */
	public Node<E> remove_node() throws OutOfBoundsException
	{
		return remove_node(num_nodes - 1);
	}
		
	/* 
	 * returns true if the node's value is contained in the list
	 */
	boolean contains(Node<E> node)
	{
		Node<E> curr = head;
		
		for (int i = 0; i < num_nodes; i++)
		{
			if (curr.val.equals(node.val))
			{
				return true;
			}
			
			curr = curr.next;
		}
		
		return false;
	}
	
	/*
	 * prints the list of nodes
	 */
	void print()
	{
		System.out.println("Linked List contains (" + num_nodes + ") nodes:");
		Node<E> curr = head;
		for (int i = 0; i < num_nodes; i++)
		{
			curr.print();
			curr = curr.next;
		}
	}	
}
