/*
 * @author Ben Weibel weibelben@gmail.com
 * Stack Item. 
 */

public class Stack_Item<E>
{
	E val;
	Stack_Item<E> prev;
	
	public Stack_Item(E val)
	{
		this.val = val;
		prev = null;
	}
	
	public E get_val()
	{
		return val;
	}
	
	public Stack_Item<E> get_prev()
	{
		return prev;
	}
	
	public void set_prev(Stack_Item<E> item)
	{
		prev = item;
	}
	
	public void print()
	{
		System.out.println("\t[" + val + "]");
	}
}
