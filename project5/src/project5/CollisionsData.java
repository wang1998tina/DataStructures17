package project5;

/**
 * This class creates an instance of an AVL tree that can only hold
 * Collision objects, as well as appropriate add/remove/rotate/print/etc
 * methods and an internal Node<Collision> class to hold objects to be stored
 * in tree.
 * Add, remove, recRemove, removeNode, getPredecessor, toStringTreeFormat, 
 * preorderPrint, node class all retrieved from BST_Recursive class provided.
 * updateHeight and rotation methods are based off of pseudocode provided in 
 * class. 
 * 
 * @author wang1998tina
 *
 */

public class CollisionsData {
	
	// root of the tree
	protected Node<Collision> root;
	// current number of nodes in the tree
	protected int numOfElements;
	//helper variable used by the remove methods 
	private boolean found;

	
	/**
	 * Default constructor. Creates instance of AVL Tree.
	 */
	public CollisionsData() {
		super();
	}
	
	
	
	/**
	 * Add the given data item to the tree, called by user. This class
	 * will call overloaded add(node, item) method, which actually handles 
	 * adding to the tree. 
	 * 
	 * @param item the new Collision element to be added to the tree
	 */
	public void add(Collision item) {
		if (item == null)
			return;
		root = add (root, item);
		
	}

	/*
	 * Actual recursive implementation of add. Will recursively find
	 * a spot in the leaves such that it satisfies order property of tree
	 * and then calls methods to update height and then balance the three. 
	 * 
	 * @param item the new Collision element to be added to the tree
	 * @return the node that was added
	 */
	private Node<Collision> add(Node<Collision> node, Collision item) {
		if(node==null) {
			numOfElements++;
			return new Node<Collision>(item);
		}
		if (node.data.compareTo(item) > 0)
			node.left = add(node.left, item);
		else if (node.data.compareTo(item) < 0)
			node.right = add(node.right, item);
		
		updateHeight(node);	
		node = balanceTree(node); 
		return node; 
	}

	
	/**
	 * Remove the item from the tree. If item is null the tree remains unchanged. If
	 * item is not found in the tree, the tree remains unchanged.
	 * 
	 * @param target the item to be removed from this tree 
	 * @return true if removed, false if not
	 */
	public boolean remove(Collision target)
	{
		root = recRemove(target, root);
		return found;
	}

	

	/*
	 * Actual recursive implementation of remove method: find the node to remove. 
	 * Also will update height and balance the tree after removal. Calls the method
	 * that will actually perform the removal. 
	 * 
	 * @param target the item to be removed from this tree 
	 * @return node that was removed
	 */
	private Node<Collision> recRemove(Collision target, Node<Collision> node)
	{
		if (node == null) {
			found = false;
		}else if (target.compareTo(node.data) < 0)
			node.left = recRemove(target, node.left);
		else if (target.compareTo(node.data) > 0)
			node.right = recRemove(target, node.right );
		else {
			node = removeNode(node); //replaces node
			found = true;
			numOfElements--;
			
		}
		if(node!= null) {
			updateHeight(node); 
			node = balanceTree(node);
		}
		
		return node;
	}

	
	/*
	 * Actual recursive implementation of remove method: perform the removal.  
	 * Replaces the node to be removed with another on the tree.
	 * 
	 * @param target the item to be removed from this tree 
	 * @return a reference to the node itself, or to the modified subtree 
	 */
	private Node<Collision> removeNode(Node<Collision> node){
		Collision data;
		if (node.left == null)
			return node.right;
		else if (node.right  == null)
			return node.left;
		else {
			data = getPredecessor(node.left); 
			node.data = data;
			node.left = recRemove(data, node.left);
			return node;
		}
	}
	
	/*
	 * Returns the information held in the rightmost node of subtree. Used for
	 * removeNode method, in order to find a node to replace a removed node with.
	 * 
	 * @param subtree root of the subtree within which to search for the rightmost node 
	 * @return returns data stored in the rightmost node of subtree  
	 */
	private Collision getPredecessor(Node<Collision> subtree)
	{
		if (subtree==null) throw new NullPointerException("getPredecessor called with "
				+ "an empty subtree");
		Node<Collision> temp = subtree;
		while (temp.right  != null)
			temp = temp.right ;
		return temp.data;
	}
	
	/**
	 * Balances tree. If balance factor is -2 or 2, will perform one of four rotations
	 * based on balance factor of the node.
	 * 
	 * @return node, whether or not it was rotated. 
	 * 
	 */
	protected Node<Collision> balanceTree(Node<Collision> n){
		
		/* LL rotation
		 * First checks if balance factor is 1-, meaning left heavy. Then checks if 
		 * left subtree is larger than node. If conditions met, LL rotate.
		 */
		if(n.left!=null) {
			if(balanceFactor(n)<-1 && balanceFactor(n.left)<=0) {
				n = rotateLL(n);
			}
		}
		
		/*RR rotation
		 * Checks if balance is 1+, meaning right heavy, then checks if right subtree
		 * is smaller than node. If cond met, RR rotate.
		 */
		if(n.right!=null) {
			if(balanceFactor(n)>1 && balanceFactor(n.right)>=0) {
				n = rotateRR(n);
			}
		}

		/*LR rotation
		 * Checks if left heavy, then checks if left subtree is smaller than node.
		 */
		if(n.left!=null) {
			if(balanceFactor(n)<-1 && balanceFactor(n.left)>0) {
				n = rotateLR(n);
			}
		}
		
		/*RL rotation
		 * Checks if right heavy, then checks if right subtree is larger than node.
		 */
		if(n.right!=null) {
			if(balanceFactor(n)>1 && balanceFactor(n.right)<0){
				n = rotateRL(n);
			}
		}
		
		return n;
	}
	
	/**
	 * Balances LL if left subtree has two more levels than right
	 * and left subtree either is balanced, or the left subtree of that
	 * is one longer.
	 * @return new root of subtree after rotation
	 */
	protected Node<Collision> rotateLL(Node<Collision> n){
		Node<Collision> b = n.left;
		n.left = b.right;
		b.right = n;
		updateHeight(n); 
		updateHeight(b); 
		return b;
	}
	
	/**
	 * Balances RR if right subtree has two more levels than left
	 * and right subtree either is balance or right subtree of that
	 * is one longer.
	 * @return new root of subtree after rotation
	 */
	protected Node<Collision> rotateRR(Node<Collision> n){
		Node<Collision> b = n.right;
		n.right = b.left;
		b.left = n;
		updateHeight(n); 
		updateHeight(b); 
		return b;
	}
	
	/**
	 * Balances LR if left subtree has two more levels than right
	 * and left subtree's right subtree is one longer.
	 */
	protected Node<Collision> rotateLR(Node<Collision> n){
		Node<Collision> b = n.left;
		Node<Collision> c = b.right;
		n.left = c.right;
		b.right = c.left;
		c.left = b;
		c.right = n;
		updateHeight(n); 
		updateHeight(b); 
		updateHeight(c);
		return c;
	}
	
	/**
	 * Balances LL if left subtree has two more levels than right
	 * and right subtree's left subtree is one longer.
	 */
	protected Node<Collision> rotateRL(Node<Collision> n){
		Node<Collision> b = n.right;
		Node<Collision> c = b.left;
		n.right = c.left;
		b.left = c.right;
		c.right = b;
		c.left = n;
		updateHeight(n); 
		updateHeight(b); 
		updateHeight(c);
		return c;
	}
	
	/**
	 * Calculates height difference. Always between -2 and 2, and if it's negative, we know
	 * left is large, and positive if right is larger. 0 if balanced.
	 */
	protected int balanceFactor(Node<Collision> n) {
		if(n.right==null) {
			return -n.height;
		}
		if(n.left==null) {
			return n.height;
		}
		return n.right.height - n.left.height;
	}
	
	/**
	 * Updates height in order to properly compute balance factor. Will take
	 * the maximum out of the right and left subtree heights.
	 * @param n to determine height
	 * 
	 */
	protected void updateHeight(Node<Collision> n) {
		if(n.left == null && n.right == null) {
			n.height = 0;
		} else if(n.left==null) {
			n.height = n.right.height + 1;
		} else if (n.right == null) {
			n.height = n.left.height + 1;
		} else {
			n.height = max(n.right.height, n.left.height) + 1;
		}
	}
	
	/**
	 * Determines the larger of two heights, for modularity purposes.
	 * @return the larger of the two heights.
	 */
	protected int max(int height1, int height2) {
		if(height1 > height2) {
			return height1;
		}
		return height2;
	}
	
	
	/**
	 * Returns the number of elements stored in this BST.
	 * @return number of elements in this BST
	 */
	public int size() {
		return numOfElements;
	}
	
	/**
	 * Returns string containing information about number of injuries
	 * and fatalities in a zip code between a certain date range. StringBuilder
	 * holds the string that will format and contain the report, and method calls
	 * BSReport to find information on the collisions.
	 * Creates an array of length 9 to be passed to BSReport. Each index corresponds
	 * with specific information on collisions (eg index 0 is number of collisions).
	 * 
	 * @param zip code
	 * @param begin date as Date obj
	 * @param end date as Date obj
	 * @return formatted String report of collision information
	 */
	public String getReport(String zip, Date dateBegin, Date dateEnd) {
		
		int[] reportArray = new int[9]; 
		BSReport(root, zip, dateBegin, dateEnd, reportArray);
		
		StringBuilder report = new StringBuilder();
		report.append("Motor Vehicle Collisions for zipcode ");
		report.append(zip);
		report.append(" (");
		report.append(dateBegin.toString());
		report.append(" - ");
		report.append(dateEnd.toString());
		report.append(") \n");
		report.append("====================================================================");
		report.append("\n");
		report.append("Total number of collisions: ");
		report.append(reportArray[0]);
		report.append("\n");
		report.append("Number of fatalities: ");
		report.append(reportArray[2]);
		report.append("\n");
		report.append(String.format("%22s", "pedestrians: "));
		report.append(reportArray[4]);
		report.append("\n");
		report.append(String.format("%22s", "cyclists: "));
		report.append(reportArray[6]);
		report.append("\n");
		report.append(String.format("%22s", "motorists: "));
		report.append(reportArray[8]);
		report.append("\n");
		report.append("Number of injuries: ");
		report.append(reportArray[1]);
		report.append("\n");
		report.append(String.format("%20s", "pedestrians : "));
		report.append(reportArray[3]);
		report.append("\n");
		report.append(String.format("%20s", "cyclists: "));
		report.append(reportArray[5]);
		report.append("\n");
		report.append(String.format("%20s", "motorists: "));
		report.append(reportArray[7]);
		report.append("\n");
	
		return report.toString();
		
	}
	
	/**Takes in an array of length 9 and binary searches thru it in order to 
	 * find node that match zip and date range. If it does, appropriate indexes
	 * of array are incremented, and BSReport will be called on both sides of the 
	 * tree, as another matching zip may be either on left or right side of tree.
	 * If no zip match is found with the node, though, BSReport will only be called
	 * on one side of the tree.
	 * 
	 * @param n node to be visited
	 * @param zip
	 * @param startDate
	 * @param endDate
	 * @param reportArray
	 */
	protected void BSReport(Node<Collision> n, String zip, Date startDate, Date endDate, 
			int[] reportArray) {
		if(n==null) {return;}
		//if node matches zip and date range
		if(n.data.zip.compareTo(zip)==0){
			if(n.data.date.compareTo(startDate)>=0 
					&& n.data.date.compareTo(endDate)<=0) {
				reportArray[0] = reportArray[0] + 1;
				reportArray[1] = reportArray[1] + n.data.personsInjured;
				reportArray[2] = reportArray[2] + n.data.personsKilled;
				reportArray[3] = reportArray[3] + n.data.pedestriansInjured;
				reportArray[4] = reportArray[4] + n.data.pedestriansKilled;
				reportArray[5] = reportArray[5] + n.data.cyclistsInjured;
				reportArray[6] = reportArray[6] + n.data.cyclistsKilled;
				reportArray[7] = reportArray[7] + n.data.motoristsInjured;
				reportArray[8] = reportArray[8] + n.data.motoristsKilled;
				
			}
		}
		if(n.data.zip.compareTo(zip)<0) {
			BSReport(n.right, zip, startDate, endDate, reportArray);
		}  else if(n.data.zip.compareTo(zip)>0) {
			BSReport(n.left, zip, startDate, endDate, reportArray);
		} else {
			BSReport(n.right, zip, startDate, endDate, reportArray);
			BSReport(n.left, zip, startDate, endDate, reportArray);
		}
		
		
	}
	
	
	
	/**
	 * Produces tree like string representation of this BST.
	 * @return string containing tree-like representation of this BST.
	 */
	public String toStringTreeFormat() {
	
		StringBuilder s = new StringBuilder();

		preOrderPrint(root, 0, s);
		return s.toString();
	}

	
	
	
	/*
	 * Actual recursive implementation of preorder traversal to produce tree-like string
	 * representation of this tree.
	 * 
	 * @param tree the root of the current subtree
	 * @param level level (depth) of the current recursive call in the tree to
	 *   determine the indentation of each item
	 * @param output the string that accumulated the string representation of this
	 *   BST
	 */
	private void preOrderPrint(Node<Collision> tree, int level, StringBuilder output) {
		if (tree != null) {
			String spaces = "\n";
			if (level > 0) {
				for (int i = 0; i < level - 1; i++)
					spaces += "   ";
				spaces += "|--";
			}
			output.append(spaces);
			output.append(tree.data);
			preOrderPrint(tree.left, level + 1, output);
			preOrderPrint(tree.right , level + 1, output);
		}
		// uncomment the part below to show "null children" in the output
		else {
			String spaces = "\n";
			if (level > 0) {
				for (int i = 0; i < level - 1; i++)
					spaces += "   ";
				spaces += "|--";
			}
			output.append(spaces);
			output.append("null");
		}
	}
	
	
	
	
	//-------------NODE CLASS-----------
	/**
	 * Internal class to hold Collision data. I've updated the source code
	 * to only include Collision objects.
	 * @author Joanna Klukowska
	 *
	 * @param <Collision>
	 */
	protected static class Node <Collision extends Comparable <Collision>> 
		implements Comparable <Node <Collision> > {


		protected Node <Collision> left;  //reference to the left subtree 
		protected Node <Collision> right; //reference to the right subtree
		protected Collision data;            //data item stored in the node

		protected int height; 


		/**
		 * Constructs a BSTNode initializing the data part 
		 * according to the parameter and setting both 
		 * references to subtrees to null.
		 * @param data
		 *    data to be stored in the node
		 */
		protected Node(Collision data) {
			this.data = data;
			left = null;
			right = null;
			height = 0; 
		}

		public Collision getData() {
			return data;
		}
		
		/**
		 * Compares two nodes based on Collision compareTo.
		 */
		/* (non-Javadoc)
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(Node<Collision> other) {
			return this.data.compareTo(other.data);
		} 

		/**
		 * Converts data to string format using method defined in Collision.
		 */
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return data.toString();
		}



	}
	
	
	//------End of internal node class------
	
	
}
