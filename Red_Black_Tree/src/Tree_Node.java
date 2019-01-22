/*
 * @author Ben Weibel weibelben@gmail.com 1/18/2019
 * Red Black Tree Node. 
 */

public class Tree_Node<E>
{
	public enum Color {red, black};
	private Color color;
	private Tree_Node<E> parent;
	private Tree_Node<E> left;
	private Tree_Node<E> right;
	private E val;
	
	public Tree_Node(E val)
	{
		this.val = val;
		color = Color.red;
		parent = null;
		left = null;
		right = null;
	}
	
	/*
	 * compares the values of 2 nodes, will need to be changed depending
	 * on type. This is now for Integers.
	 */
	int compare(Tree_Node<E> node)
	{
		return ((Integer)val).compareTo((Integer)node.get_val());
	}
	
	void set_parent(Tree_Node<E> node)
	{
		this.parent = node;
	}
	
	void set_left(Tree_Node<E> node)
	{
		this.left = node;
	}
	
	void set_right(Tree_Node<E> node)
	{
		this.right = node;
	}
	
	void set_color(Color color)
	{
		this.color = color;
	}
	
	E get_val()
	{
		return val;
	}
	
	Tree_Node<E> get_parent()
	{
		return this.parent;
	}
	
	Tree_Node<E> get_left()
	{
		return this.left;
	}
	
	Tree_Node<E> get_right()
	{
		return this.right;
	}
	
	Color get_color()
	{
		return this.color;
	}
	
	void print()
	{
		System.out.println("val = " + val + " color = " + color);
		if (this.left != null) 
		{
			System.out.print("Left  of " + val + " is ");
			this.left.print();
		}
		
		if (this.right != null)
		{
			System.out.print("Right of " + val + " is ");
			this.right.print();
		}
	}
}
