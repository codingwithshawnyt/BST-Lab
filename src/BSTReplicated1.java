/*
 * BSTReplicated.java
 * amar nangia 
 * period 4
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class BSTReplicated1  {
 
    public static void main(String s[]) 
    {
    	BinarySearchIntTree tree1 = new BinarySearchIntTree();
    	BinarySearchIntTree tree2 = new BinarySearchIntTree(2);
    	ArrayList<Integer> arr = new ArrayList<Integer> (Arrays.asList(1, 1, 3, 4, 5,6 ));
    	BinarySearchIntTree tree3 = new BinarySearchIntTree(arr);
    	System.out.println("tree1: " + tree1);
    	System.out.println("tree2: " + tree2);
    	System.out.println("tree3: " + tree3);
    	
    	//testing duplicate values
    	tree2.add(2); 
    	System.out.println("tree2: " + tree2);
    	
    	tree2.add(3); 
    	tree2.add(4); 
    	tree2.add(6); 
    	tree2.add(7); 
    	tree2.add(1); 
    	System.out.println("tree2 size: " + tree2.getSize());//shoudl be 6
    	
    	System.out.println("tree2 empty before cleared: " + tree2.isEmpty());//shoudl be true
    	tree2.clear(); 
    	System.out.println("tree2 empty after cleared: " + tree2.isEmpty());//shoudl be false

    	System.out.println("tree3: " + tree3);
    	System.out.println("tree3 contains 1: " + tree3.contains(1));//shoudl be true
    	System.out.println("tree3 contains 90: " + tree3.contains(90));//shoudl be false

    	System.out.println("tree3: " + tree3);
    	tree3.remove(1); 
    	System.out.println("tree3 removed 1: " + tree3);
    	tree3.remove(90); 
    	System.out.println("tree3 removed 90(doesnt exist): " + tree3);
    	//remove was in depth tested already


    	

    	//testing 1
    	

		//Students create 2 BinarySearchInt objects.
    		// a) Uses the default constructor
    		// b) Uses the the construtor that allows an integer value to be passed in.
    	
		
      	//Test out each of your various methods (getSize, clear, isEmpty, add, findParent, contains, remove, toString)) 
      		//using either of the instantiated BinarySearchIntTree objects
      		
    }
    
	//Create your BinarySearchIntTree class in another file called "BinarySearchIntTree"
}
