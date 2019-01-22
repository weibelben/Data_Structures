import static org.junit.Assert.*;

import org.junit.Test;
/*
 * @author Ben Weibel weibelben@gmail.com
 * Stack Tests. 
 */

public class Stack_Tests 
{
	@Test
	public void constructor_test() 
	{
		Stack<Integer> s = new Stack<Integer>(new Stack_Item<Integer>(1));
		
		if (s.size() != 1)
			fail();
	}
	
	@Test
	public void push_test() 
	{
		Stack<Integer> s = new Stack<Integer>(new Stack_Item<Integer>(1));
		s.push(new Stack_Item<Integer>(2));
		s.push(new Stack_Item<Integer>(3));
		s.push(new Stack_Item<Integer>(4));
		
		if (s.size() != 4)
			fail();
	}
	
	@Test
	public void pop_test() 
	{
		Stack<Integer> s = new Stack<Integer>(new Stack_Item<Integer>(1));
		s.push(new Stack_Item<Integer>(2));
		s.push(new Stack_Item<Integer>(3));
		s.push(new Stack_Item<Integer>(4));
		
		s.pop();
		s.pop();
		s.pop();
		
		if (s.size() != 1)
			fail();
	}
	
	@Test
	public void pop_val_test() 
	{
		Stack<Integer> s = new Stack<Integer>(new Stack_Item<Integer>(1));
		s.push(new Stack_Item<Integer>(2));
		s.push(new Stack_Item<Integer>(3));
		s.push(new Stack_Item<Integer>(4));
		
		if (s.pop().get_val() != 4)
			fail();
		
		if (s.pop().get_val() != 3)
			fail();
		
		if (s.pop().get_val() != 2)
			fail();
		
		if (s.pop().get_val() != 1)
			fail();
	}
}
