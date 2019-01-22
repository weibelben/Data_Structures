
/*
 * @author Ben Weibel weibelben@gmail.com 1/18/2019
 * Red Black Tree. 
 */

public class Tree<E>
{
	private Tree_Node<E> root;
	private int num_items;
	
	public Tree(Tree_Node<E> node)
	{
		root = node;
		root.set_color(Tree_Node.Color.black);
		num_items = 1;
	}
	
	/*
	 * add the node to its respective spot in the sorted tree;
	 */
	public void add_node(Tree_Node<E> node)
	{
		if (node == null)
		{
			System.out.println("Cannot add a null node.");
			return;
		}
		
		if (num_items == 0)
		{
			// adding to an empty tree
			root = node;
			node.set_color(Tree_Node.Color.black);
			num_items = 1;
			return;
		}
		
		add_node(root, node);
	}
	
	/*
	 * recursive helper of add node method, standard BST insertion
	 */
	private void add_node(Tree_Node<E> parent, Tree_Node<E> node)
	{
		if (node.compare(parent) == 0)
		{
			System.out.println("Attempt to add an existing item to the tree.");
			return;
		}
		else if (node.compare(parent) < 0)
		{
			if (parent.get_left() != null)
			{
				add_node(parent.get_left(), node);
			}
			else
			{
				num_items++;
				parent.set_left(node);
				node.set_parent(parent);				
				balance(node);
			}
		}
		else
		{
			if (parent.get_right() != null)
			{
				add_node(parent.get_right(), node);
			}
			else
			{
				num_items++;
				parent.set_right(node);
				node.set_parent(parent);				
				balance(node);
			}
		}
	}
	
	private void balance(Tree_Node<E> node)
	{		
		if (node.get_parent() == null)
		{
			root = node;
			root.set_color(Tree_Node.Color.black);
			return;
		}
		
		if (node.get_parent().get_color() == Tree_Node.Color.black)
		{
			// new red child of black node, no recoloring needed
			return;
		}
		
		// grandparent
		Tree_Node<E> gparent = node.get_parent().get_parent();
		
		if (gparent != null)
		{			
			Tree_Node<E> uncle = null;
			
			// node's grandparent exists
			if (gparent.compare(node) < 0)
			{
				// uncle will be left of grand parent
				if (gparent.get_left() != null)
				{
					uncle = gparent.get_left();		
				}
			}
			else
			{
				// uncle will be right of grand parent
				if (gparent.get_right() != null)
				{
					uncle = gparent.get_right();
				}
			}
			
			if (uncle != null)
			{
				if (uncle.get_color() == Tree_Node.Color.red)
				{
					// uncle is red
					gparent.set_color(Tree_Node.Color.red);
					node.get_parent().set_color(Tree_Node.Color.black);
					uncle.set_color(Tree_Node.Color.black);		
					balance(gparent);
					return;
				}
			}
			
			// uncle is black or no uncle
			Tree_Node<E> r = gparent.get_parent();
			Tree_Node<E> parent = node.get_parent();
			
			if (node.compare(gparent) < 0)
			{		
				if (node.compare(parent) < 0)
				{
					// left left case
					parent = rotate_right(gparent);
					Tree_Node.Color clr = parent.get_color();
					parent.set_color(parent.get_right().get_color());
					parent.get_right().set_color(clr);
				}
				else
				{
					// left right case
					parent = rotate_left(parent);
					parent = rotate_right(gparent);
					Tree_Node.Color clr = parent.get_color();
					parent.set_color(parent.get_right().get_color());
					parent.get_right().set_color(clr);
				}				
			}
			else
			{
				if (node.compare(parent) < 0)
				{
					// right left case
					parent = rotate_right(parent);
					parent = rotate_left(gparent);
					Tree_Node.Color clr = parent.get_color();
					parent.set_color(parent.get_left().get_color());
					parent.get_left().set_color(clr);
				}
				else
				{
					// right right case
					parent = rotate_left(gparent);
					Tree_Node.Color clr = parent.get_color();
					parent.set_color(parent.get_left().get_color());
					parent.get_left().set_color(clr);
				}		
			}	
		}
		else
		{
			// grandparent is null
			// shouldn't happen because the root is black always
			System.err.println("ERROR: root is red...");
		}
	}
	
	/*
	 * rotates the subtree left, does not handle recoloring
	 */
	private Tree_Node<E> rotate_right(Tree_Node<E> node)
	{
		if (node == null)
		{
			return null;
		}	
		
		Tree_Node<E> left = node.get_left();
		
		if (left == null)
		{
			System.err.println("Cannot rotate right with no left node");
			System.exit(1);
		}
			
		if (node.get_parent() != null)
		{
			left.set_parent(node.get_parent());
			
			if (left.get_parent().compare(left) < 0)
			{
				left.get_parent().set_right(left);
			}
			else
			{
				left.get_parent().set_left(left);
			}
		}
		else
		{
			root = left;
			root.set_parent(null);
		}
		
		node.set_left(left.get_right());
		left.set_right(node);		
		node.set_parent(left);
				
		return left;
	}
	
	/*
	 * rotates the subtree right, does not handle recoloring
	 */
	private Tree_Node<E> rotate_left(Tree_Node<E> node)
	{
		if (node == null)
		{
			return null;
		}	
		
		Tree_Node<E> right = node.get_right();
		
		if (right == null)
		{
			System.err.println("Cannot rotate left with no right node");
			System.exit(1);
		}
			
		if (node.get_parent() != null)
		{
			right.set_parent(node.get_parent());
			
			if (right.get_parent().compare(right) < 0)
			{
				right.get_parent().set_right(right);
			}
			else
			{
				right.get_parent().set_left(right);
			}
		}
		else
		{
			root = right;
			root.set_parent(null);
		}
		
		node.set_right(right.get_left());
		right.set_left(node);		
		node.set_parent(right);
				
		return right;
	}
	
	/*
	 * deletes a node from the tree, returning the root of the updated tree
	 */
	public Tree_Node<E> delete(Tree_Node<E> node)
	{
		if (node == null)
		{
			System.out.println("Attempt to delete a null node.");
			return root;
		}
		
		if (num_items <= 0)
		{
			System.out.println("Cannot delete node from an empty tree.");
			System.exit(1);
		}
		
		
			
		
		return null;
	}
	
	/*
	 * returns true if the node exists in the tree
	 */
	public boolean contains(Tree_Node<E> node)
	{
		if (null == node)
		{
			return false;
		}
		
		return contains(root, node);
	}
	
	/*
	 * recursive helper of contains method
	 */
	private boolean contains(Tree_Node<E> root, Tree_Node<E> node)
	{
		if (null == root)
		{
			return false;
		}
		
		if (root.compare(node) == 0)
		{
			return true;
		}
		else if (root.compare(node) < 0)
		{
			return contains(root.get_right(), node);
		}
		else 
		{
			return contains(root.get_left(), node);
		}
	}
	
	/*
	 * returns the number of nodes in the tree
	 */
	public int size()
	{
		return num_items;
	}
	
	/*
	 * prints the tree
	 */
	public void print()
	{
		root.print();
	}
	
	/*
	 * testing main method
	 */
	public static void main(String[] args)
	{
		Tree<Integer> tree = new Tree<Integer>(new Tree_Node<Integer>(5));
		tree.add_node(new Tree_Node<Integer>(6));
		tree.add_node(new Tree_Node<Integer>(15));
		tree.add_node(new Tree_Node<Integer>(7));
		tree.add_node(new Tree_Node<Integer>(8));
		tree.add_node(new Tree_Node<Integer>(9));
		tree.add_node(new Tree_Node<Integer>(10));
		tree.add_node(new Tree_Node<Integer>(11));
				
		tree.print();
	}
}
