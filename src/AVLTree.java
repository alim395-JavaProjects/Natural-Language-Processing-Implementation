 /* Class AVLTree */

 class AVLTree

 {

     private AVLNode root;     

 

     /* Constructor */

     public AVLTree()

     {

         setRoot(null);

     }

     /* Function to check if tree is empty */

     public boolean isEmpty()

     {

         return getRoot() == null;

     }

     /* Make the tree logically empty */

     public void makeEmpty()

     {

         setRoot(null);

     }

     /* Function to insert data */

     public void insert(int data)

     {

         setRoot(insert(data, getRoot()));

     }

     /* Function to get height of node */

     private int height(AVLNode t )

     {

         return t == null ? -1 : t.height;

     }

     /* Function to max of left/right node */

     private int max(int lhs, int rhs)

     {

         return lhs > rhs ? lhs : rhs;

     }
     
     /* Function to max of left/right node */

     private int min(int lhs, int rhs)

     {

         return lhs < rhs ? lhs : rhs;

     }

     /* Function to insert data recursively */

     private AVLNode insert(int x, AVLNode t)

     {

         if (t == null)

             t = new AVLNode(x);

         else if (x < t.data)

         {

             t.left = insert( x, t.left );

             if( height( t.left ) - height( t.right ) == 2 )

                 if( x < t.left.data )

                     t = rotateWithLeftChild( t );

                 else

                     t = doubleWithLeftChild( t );

         }

         else if( x > t.data )

         {

             t.right = insert( x, t.right );

             if( height( t.right ) - height( t.left ) == 2 )

                 if( x > t.right.data)

                     t = rotateWithRightChild( t );

                 else

                     t = doubleWithRightChild( t );

         }

         else

           ;  // Duplicate; do nothing

         t.height = max( height( t.left ), height( t.right ) ) + 1;

         return t;

     }

     /* Rotate binary tree node with left child */     

     private AVLNode rotateWithLeftChild(AVLNode k2)

     {

         AVLNode k1 = k2.left;

         k2.left = k1.right;

         k1.right = k2;

         k2.height = max( height( k2.left ), height( k2.right ) ) + 1;

         k1.height = max( height( k1.left ), k2.height ) + 1;

         return k1;

     }

 

     /* Rotate binary tree node with right child */

     private AVLNode rotateWithRightChild(AVLNode k1)

     {

         AVLNode k2 = k1.right;

         k1.right = k2.left;

         k2.left = k1;

         k1.height = max( height( k1.left ), height( k1.right ) ) + 1;

         k2.height = max( height( k2.right ), k1.height ) + 1;

         return k2;

     }

     /**

      * Double rotate binary tree node: first left child

      * with its right child; then node k3 with new left child */

     private AVLNode doubleWithLeftChild(AVLNode k3)

     {

         k3.left = rotateWithRightChild( k3.left );

         return rotateWithLeftChild( k3 );

     }

     /**

      * Double rotate binary tree node: first right child

      * with its left child; then node k1 with new right child */      

     private AVLNode doubleWithRightChild(AVLNode k1)

     {

         k1.right = rotateWithLeftChild( k1.right );

         return rotateWithRightChild( k1 );

     }    

     /* Functions to count number of nodes */

     public int countNodes()

     {

         return countNodes(getRoot());

     }

     private int countNodes(AVLNode r)

     {

         if (r == null)

             return 0;

         else

         {

             int l = 1;

             l += countNodes(r.left);

             l += countNodes(r.right);

             return l;

         }

     }

     /* Functions to search for an element */

     public boolean search(int val)

     {

         return search(getRoot(), val);

     }

     private boolean search(AVLNode r, int val)

     {

         boolean found = false;

         while ((r != null) && !found)

         {

             int rval = r.data;

             if (val < rval)

                 r = r.left;

             else if (val > rval)

                 r = r.right;

             else

             {

                 found = true;

                 break;

             }

             found = search(r, val);

         }

         return found;

     }
     
     /* Function for getting Node */
     
     public AVLNode getNode(int val) 
     
     {
    	 
    	 return getNode(getRoot(), val);
    	 
     }
     
     private AVLNode getNode(AVLNode r, int val)

     {

    	 boolean found = false;

         while ((r != null) && !found)

         {

             int rval = r.data;

             if (val < rval)

                 r = r.left;

             else if (val > rval)

                 r = r.right;

             else

             {

                 found = true;

                 break;

             }

             found = search(r, val);

         }
         
         return r;

     }

     /* Function for inorder traversal */

     public void inorder()

     {

         inorder(getRoot());

     }

     private void inorder(AVLNode r)

     {

         if (r != null)

         {

             inorder(r.left);
             
             System.out.print(r.data +" ");

             inorder(r.right);

         }

     }

     /* Function for preorder traversal */

     public void preorder()

     {

         preorder(getRoot());

     }

     private void preorder(AVLNode r)

     {

         if (r != null)

         {

             System.out.print(r.data +" ");

             preorder(r.left);             

             preorder(r.right);

         }

     }

     /* Function for postorder traversal */

     public void postorder()

     {

         postorder(getRoot());

     }

     private void postorder(AVLNode r)

     {

         if (r != null)

         {

             postorder(r.left);             

             postorder(r.right);

             System.out.print(r.data +" ");

         }

     }
     
     public boolean isBST() {
    	 
    	 return isBST(root, root.left, root.right);
    	 
     }
     
     private boolean isBST(AVLNode root, AVLNode l, AVLNode r) {
    	    if (root == null)
    	        return true;
    	 
    	    if (l != null && root.data <= l.data)
    	        return false;
    	 
    	    if (r != null && root.data >= r.data)
    	        return false;
    	    
    	    return isBST(root.left, l, root) &&
    	        isBST(root.right, root, r);
     }
     
     public boolean isBalanced() {
    	 
    	 return isBalanced(root);
    	 
     }
     
     private boolean isBalanced(AVLNode r) {
    	 if (r == null)
    		 return true;
    	 
    	 int leftHeight = r.left.height;
    	 int rightHeight = r.right.height;
    	 
    	 if (Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(r.left) && isBalanced(r.right))
    		 return true;
    	 
    	 return false;
     }

	/**
	 * @return the root
	 */
	public AVLNode getRoot() {
		return root;
	}

	/**
	 * @param root the root to set
	 */
	public void setRoot(AVLNode root) {
		this.root = root;
	}
	
	public boolean isExternal(AVLNode node) {
	    if (node == null)
	        return false;    
	    if (node.right == null && node.left == null)
	        return true;
	    return false; 
	}

	public void modifyValue() {
		// TODO Auto-generated method stub
		
	}
	
	

 }
