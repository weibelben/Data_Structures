import static org.junit.Assert.*;

import org.junit.Test;
/*
 * @author Ben Weibel weibelben@gmail.com
 * Doubly linked list. 
 */

public class Doubly_Linked_List_Tests 
{
	@org.junit.Test
	public void constructor_size_test() 
	{
		Doubly_Linked_List<Integer> list = 
				new Doubly_Linked_List<Integer>(new Node<Integer>(1));
		
		if (list.size() != 1)
			fail("List size did not increment when initialized.");
	}
	
	@org.junit.Test
	public void constructor_value_test() throws OutOfBoundsException 
	{
		Doubly_Linked_List<Integer> list = 
				new Doubly_Linked_List<Integer>(new Node<Integer>(1));
		
		if (list.remove_node().val != 1)
			fail("Value of head node not correct.");
	}

	@org.junit.Test
	public void add_node_test() throws OutOfBoundsException 
	{
		Doubly_Linked_List<Integer> list = 
				new Doubly_Linked_List<Integer>(new Node<Integer>(1));
		
		list.add_node(new Node<Integer>(2));
		list.add_node(new Node<Integer>(3));
		
		if (list.size() != 3)
			fail("List size did not increment when nodes were added.");
	}
	
	@org.junit.Test
	public void add_node_at_index_test() throws OutOfBoundsException 
	{
		Doubly_Linked_List<Integer> list = 
				new Doubly_Linked_List<Integer>(new Node<Integer>(1));
		
		list.add_node(new Node<Integer>(2));
		list.add_node(new Node<Integer>(3));
		list.add_node(new Node<Integer>(4), 3);
		
		if (list.size() != 4)
			fail("List size did not increment when nodes were added.");
	}
	
	@org.junit.Test
	public void add_node_at_start_test() throws OutOfBoundsException 
	{
		Doubly_Linked_List<Integer> list = 
				new Doubly_Linked_List<Integer>(new Node<Integer>(1));
		
		list.add_node(new Node<Integer>(2));
		list.add_node(new Node<Integer>(3));
		list.add_node(new Node<Integer>(4), 0);
		
		if (list.size() != 4)
			fail("List size did not increment when node added to start.");
	}
	
	@org.junit.Test
	public void remove_node_test() throws OutOfBoundsException 
	{
		Doubly_Linked_List<Integer> list = 
				new Doubly_Linked_List<Integer>(new Node<Integer>(1));
		
		list.add_node(new Node<Integer>(2));
		list.add_node(new Node<Integer>(3));
		Node<Integer> node = list.remove_node();
		
		if (list.size() != 2)
			fail("List size did not increment when initialized.");
		
		if (node.val != 3)
		{
			fail("Removed incorrect node from list.");
		}
	}
	
	@org.junit.Test
	public void remove_head_test() throws OutOfBoundsException 
	{
		Doubly_Linked_List<Integer> list = 
				new Doubly_Linked_List<Integer>(new Node<Integer>(1));
		
		list.add_node(new Node<Integer>(2));
		list.add_node(new Node<Integer>(3));
		Node<Integer> node = list.remove_node(0);
		
		if (list.size() != 2)
			fail("List size did not decrement when nodes were removed.");
		
		if (node.val != 1)
		{
			fail("Removed incorrect node from list.");
		}
	}
	
	@org.junit.Test
	public void contains_test() throws OutOfBoundsException 
	{
		Doubly_Linked_List<Integer> list = 
				new Doubly_Linked_List<Integer>(new Node<Integer>(1));
		
		list.add_node(new Node<Integer>(2));
		list.add_node(new Node<Integer>(3));
		
		if (!list.contains(new Node<Integer>(1)))
			fail("List claims not to contain a node that it does contain.");
		
		if (!list.contains(new Node<Integer>(2)))
			fail("List claims not to contain a node that it does contain.");
		
		if (!list.contains(new Node<Integer>(3)))
			fail("List claims not to contain a node that it does contain.");
		
		if (list.contains(new Node<Integer>(4)))
			fail("List claims to contain a node that it does not contain.");		
	}
	
	@org.junit.Test
	public void add_node_prev_test() throws OutOfBoundsException 
	{
		Doubly_Linked_List<Integer> list = 
				new Doubly_Linked_List<Integer>(new Node<Integer>(1));
		
		list.add_node(new Node<Integer>(2));
		list.add_node(new Node<Integer>(3));
		
		if (list.remove_node().prev.val !=2)
			fail("Previous node was not properly set.");
	}
}
