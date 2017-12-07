package project5;



public class CollisionsData {
	
	// root of the tree
	protected Node<Collision> root;
	// current number of nodes in the tree
	protected int numOfElements;
	//helper variable used by the remove methods 
	private boolean found;

	
	/**
	 * Default constructor
	 */
	public CollisionsData() {
		super();
	}
	
	
	
	/**
	 * Add the given data item to the tree. If item is null, the tree does not
	 * change. If item already exists, the tree does not change. 
	 * 
	 * @param item the new element to be added to the tree
	 */
	public void add(Collision item) {
		if (item == null)
			return;
		root = add (root, item);
		
	}

	/*
	 * Actual recursive implementation of add.  
	 * 
	 * @param item the new element to be added to the tree
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
	 */
	public boolean remove(Collision target)
	{
		root = recRemove(target, root);
		return found;
	}

	

	/*
	 * Actual recursive implementation of remove method: find the node to remove.  
	 * 
	 * @param target the item to be removed from this tree 
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
	 * Returns the information held in the rightmost node of subtree  
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
	 * Balances tree. If balance factor is -2 or 2, will perform one of four rotations.
	 * 
	 */
	protected Node<Collision> balanceTree(Node<Collision> n){
		
		/* LL rotation
		 * First checks if balance factor is 1-, meaning left heavy. Then checks if 
		 * left subtree is larger than node. If conditions met, LL rotate.
		 */
		if(balanceFactor(n)<-1 && balanceFactor(n.left)<=0) {
			n = rotateLL(n);
		}
		
		/*RR rotation
		 * Checks if balance is 1+, meaning right heavy, then checks if right subtree
		 * is smaller than node. If cond met, RR rotate.
		 */
		if(balanceFactor(n)>1 && balanceFactor(n.right)>=0) {
			n = rotateRR(n);
		}

		/*LR rotation
		 * Checks if left heavy, then checks if left subtree is smaller than node.
		 */
		if(balanceFactor(n)<-1 && balanceFactor(n.left)>0) {
			n = rotateLR(n);
		}
		
		/*RL rotation
		 * Checks if right heavy, then checks if right subtree is larger than node.
		 */
		if(balanceFactor(n)>1 && balanceFactor(n.right)<0){
			n = rotateRL(n);
		}
		
		return n;
	}
	
	/**
	 * Balances LL if left subtree has two more levels than right
	 * and left subtree either is balanced, or the left subtree of that
	 * is one longer.
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
	 * Updates height in order to properly compute balance factor.
	 * @param n
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
	 * Determines the larger of two heights
	 */
	protected int max(int height1, int height2) {
		if(height1 > height2) {
			return height1;
		}
		return height2;
	}
	
	
	/**
	 * Determines the number of elements stored in this BST.
	 * 
	 * @return number of elements in this BST
	 */
	public int size() {
		return numOfElements;
	}
	
	/**
	 * Returns string containing information abt num of injuries
	 * and fatalities.
	 * @param zip
	 * @param dateBegin
	 * @param dateEnd
	 * @return
	 */
	public String getReport(String zip, Date dateBegin, Date dateEnd) {
		
		int[] reportArray = new int[9];
		BSReport(root, zip, dateBegin, dateEnd, reportArray);
		
		String report = "Motor Vehicle Collisions for zipcode " + zip + " (" + dateBegin.toString()
			+ " - " + dateEnd.toString() + ") /n" + "-----------------------------/n"
			+ "Total number of collisions: " + reportArray[0] + "/n"
			+ "Number of fatalities " + reportArray[2] + "/n"
			+ "pedestrians: " + reportArray[4] + "/n"
			+ "cyclists: " + reportArray[6] + "/n"
			+ "motorists: " + reportArray[8] + "/n"
			+ "Number of injuries: " + reportArray[1] + "/n"
			+ "pedestrians: " + reportArray[3] + "/n"
			+ "cyclists: " + reportArray[5] + "/n"
			+ "motorists: " + reportArray[7] + "/n";  
		return report;
	}
	
	protected void BSReport(Node<Collision> n, String zip, Date startDate, Date endDate, 
			int[] reportArray) {
		if(n==null) {return;}
		System.out.println(n.data.getZip());
		System.out.println(zip);
		if(n.data.getZip().equals(zip)){
			if(n.data.getDate().compareTo(startDate)>=0 
					&& n.data.getDate().compareTo(endDate)<=0) {
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
		if(n.data.zip.compareTo(zip)>0) {
			BSReport(n.right, zip, startDate, endDate, reportArray);
		}
		BSReport(n.left, zip, startDate, endDate, reportArray);
		
		
		
		
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
	 * Internal class to hold Collision data.
	 * @author wang1998tina
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
