/*
 * @author Ben Weibel weibelben@gmail.com
 * Stack. 
 */

public class Stack<E>
{
	private int num_items;
	private Stack_Item<E> stack_top;
	
	public Stack(Stack_Item<E> item)
	{
		stack_top = item;
		num_items = 1;
	}
	
	public void push(Stack_Item<E> item)
	{
		item.set_prev(stack_top);
		stack_top = item;
		num_items++;
	}
	
	public Stack_Item<E> pop()
	{
		if (num_items <= 0)
		{
			System.out.println("There are no items in the stack!");
			return null;
		}
		
		Stack_Item<E> item = stack_top;
		stack_top = stack_top.get_prev();
		num_items--;
		return item;
	}
	
	public int size()
	{
		return num_items;
	}
	
	public void print()
	{
		Stack_Item<E> curr = pop();
		for (int i = 0; i < num_items; i++)
		{
			curr.print();
			curr = pop();
		}
	}
}
