  
  // The AVLTree class is provided 
  
   import java.util.Scanner;
   public class Test{    
        public static void main(String[] args)  
        {              
        //creating Scanner class object to get input from user  
            Scanner sc = new Scanner(System.in);  
  
        // create object of ConstructAVLTree class object for costructing AVL Tree  
           AVLTree obj = new AVLTree();   
  
            char choice;    //initialize a character type variable to choice   
          
        // perform operation of AVL Tree using switch  
            //do      
            //{  
            System.out.println("\nSelect an operation:\n");  
            System.out.println("1. Insert a node");  
            System.out.println("2. Search a node");  
            System.out.println("3. Get total number of nodes in AVL Tree");  
            System.out.println("4. Is AVL Tree empty?");  
            System.out.println("5. Remove all nodes from AVL Tree");  
            System.out.println("6. Display AVL Tree in Post order");  
            System.out.println("7. Display AVL Tree in Pre order");  
            System.out.println("8. Display AVL Tree in In order");  
            System.out.println("9. Display if P is an external node");  
            System.out.println("10. Display if key is present in a tree, changes the value of this field of this entry to new value");  
            //}
        
       //get choice from user  
            int ch = sc.nextInt();              
            switch (ch)  
            {  
                case 1 :   
                    System.out.println("Please enter an element to insert in AVL Tree");  
                    obj.insert(sc.nextInt());                       
                    break;                            
                case 2 :   
                    System.out.println("Enter integer element to search");  
                    System.out.println(obj.search(sc.nextInt()));  
                    break;                                            
                case 3 :   
                    System.out.println(obj.countNodes());  
                    break;       
                case 4 :   
                    System.out.println(obj.isEmpty());  
                    break;       
                case 5 :   
                    obj.makeEmpty();  
                    System.out.println("\nTree Cleared successfully");  
                    break;  
                case 6 :   
                    System.out.println("\nDisplay AVL Tree in Post order");  
                    obj.postorder();  
                    break;  
                case 7 :   
                    System.out.println("\nDisplay AVL Tree in Pre order");  
                    obj.preorder();  
                    break;  
                case 8 :   
                    System.out.println("\nDisplay AVL Tree in In order");  
                    obj.inorder();  
                    break;  
                case 9 :   
                    System.out.println("\nDisplay if p is external node");  
                    obj.isExternal(obj.getNode(sc.nextInt()));  
                    break;      
                case 10 :   
                    System.out.println("\nDisplay if key is present in a tree, changes the value field of this entry to new value");  
                    obj.modifyValue();  
                    break;      
                default :   
                    System.out.println("\n ");  
                    break;      
         
            
                }        
     // CASE 11 to check if the Tree is valid AVL tree. Here you will check the AVL tree generated by reading the file word.txt is a valid AVL.
//        In another test for case 11, you will consider the following and provide these values to your AVL tree program to check if it will create a balance tree?
//        Remember isBST() and isBalanced() are the functions you will create and pass them the values of t1 and t2 as specified below. For valid AVL tree, it should be BST first then we can check 		if its AVL or not

            System.out.println("11. Check the tree is it is valid AVL Tree");  
            

     
       
            AVLTree t1 = new AVLTree();
            t1.insert(1);

            t1.getRoot().left = new AVLNode(2);

            t1.getRoot().right = new AVLNode(3);

            t1.getRoot().right.left = new AVLNode(4);

            t1.getRoot().right.right = new AVLNode(5);

     

            AVLTree t2 = new AVLTree();
            t2.insert(15);

            t2.getRoot().left = new AVLNode(5);

            t2.getRoot().right = new AVLNode(20);

            t2.getRoot().right.left = new AVLNode(18);

            t2.getRoot().right.right = new AVLNode(23);

            t2.getRoot().left.left = new AVLNode(4);

            t2.getRoot().left.right = new AVLNode(6);

     

            if (t1.isBST() && t1.isBalanced())

                System.out.println("Tree t1 is AVL tree");

            else

                System.out.println("Tree t1 is not AVL tree");

     

            if (t2.isBST() && t2.isBalanced())

                System.out.println("Tree t1 is AVL tree");

            else

                System.out.println("Tree t1 is not AVL tree");
            }
        }    
