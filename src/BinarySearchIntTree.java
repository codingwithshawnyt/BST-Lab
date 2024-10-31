import java.util.Collection;

//BinarySearchIntTree.java
//Shawn Ray
//Period 4
//Integer Implementation of a Binary Search Tree (BST) class to understand what goes on behind the scenes

public class BinarySearchIntTree {
	// this is the reference to the root node of the tree.
	IntTreeNode overallRoot;

	// this is a counter for the number of nodes (or integers) in the tree.
	int size = 0;

	// this is the default constructor for the Binary Search Tree  
	public BinarySearchIntTree()
	{
	    // set the root of the tree to null, indicating the tree is empty.
	    overallRoot = null;
	}

	// this is a constructor for the Binary Search Tree that takes an integer as an argument  
	public BinarySearchIntTree(int value)
	{
	    // create a new tree node with the given value and set it as the root of the tree.
	    overallRoot = new IntTreeNode(value);

	    // increment the size of the tree as we have added a new node.
	    size++;
	}	
	
	public BinarySearchIntTree(Collection<Integer> list)
	{
	    // Initialize the overallRoot as null.
	    this.overallRoot = null;

	    // Add each value from the list into the tree.
	    for(Integer value : list) {
	        this.add(value);
	    }
	    // After adding all elements from the list to the tree, 
	    // the size will correctly reflect the number of elements in the tree.
	}	
	
    // This method returns the size of the tree, which represents the number of nodes (or integers) in the tree.
    public int getSize()
    {
        // returns the number of nodes in the tree.
        return size;
    }

    // This method clears the tree, i.e., it removes all elements from the tree.
    public void clear()
    {
        // we set the root of the tree to null, effectively removing all nodes from the tree as
        // they cannot be accessed anymore.
        overallRoot = null;
        // we reset the size to 0, as there are no nodes in the tree anymore.
        size = 0;
    }
    
 // This method returns the smallest value in the tree.
 public int smallest()
 {
     // if the tree is empty, we throw an exception.
     if (isEmpty()) throw new IllegalStateException("Empty tree");

     // Start from the root node.
     IntTreeNode temp = overallRoot;

     // Move to the left-most node. The left-most node contains the smallest value in a Binary Search Tree.
     while(temp.left != null)
     {
         temp = temp.left;
     }

     // return the smallest value
     return temp.data;
 }

 // This method returns the largest value in the tree.
 public int largest()
 {
     // if the tree is empty, we throw an exception.
     if (isEmpty()) throw new IllegalStateException("Empty tree");
   
     // Start from the root node.
     IntTreeNode temp = overallRoot;

     // Move to the right-most node. The right-most node contains the largest value in a Binary Search Tree.
     while(temp.right != null)
     {
         temp = temp.right;
     }

     // return the largest value
     return temp.data;
 }	
 
 // This method returns the number of leaf nodes in the tree.
 // A leaf node is a node that has no children.
 public int countLeaves()
 {
     // It's calling a helper function that performs a recursive count of leaf nodes, starting from the root.
     return countTheLeaves(overallRoot);
 }

 // This method checks if the tree is empty.
 public boolean isEmpty()
 {
     // If the root of the tree is null, it means that there are no nodes in the tree and thus it is empty.
     // So, if the overallRoot is null, we return true indicating that the tree is empty.
     if(overallRoot == null) return true;

     // If the overallRoot is not null, it means that there's at least one node in the tree, so the tree is not empty.
     // So, we return false.
     return false;
 }	
 public boolean add(int value)
 {
     // Check if the value already exists in the tree.
     if(ifExists(value, overallRoot)) {
         // If it does, return false without adding it (since our tree does not allow duplicates).
         return false;
     }

     // Add the new node to the tree.
     overallRoot = addNode(overallRoot, value);
     // Increment the size of the tree, as we have successfully added a new node.
     size++;
     // Return true, as the value was successfully added.
     return true;
 }

 // Helper method to add the node to the tree at the right place.
 private IntTreeNode addNode(IntTreeNode root, int value) {
     // If the node is null, we have found the right spot.
     if (root == null) {
         return new IntTreeNode(value);
     } else if (value < root.data) {
         // If the value is smaller than the root's value, go to the left subtree.
         root.left = addNode(root.left, value);
     } else {
         // If the value is larger than the root's value, go to the right subtree.
         root.right = addNode(root.right, value);
     }
     // Return the root of the (potentially new) subtree.
     return root;
 }	
	
 // This method checks whether a certain value is in the tree.
 public boolean contains(int value)
 {
     // It calls the private helper method "ifExists" to check if the value exists.
     // The second parameter is the root of the tree to start the search.
     return ifExists(value, overallRoot);
 }

 // This is a helper method that finds the node with the smallest value in the (sub-)tree rooted at the parameter node.
 private static IntTreeNode minNode(IntTreeNode root)
 {
     // A temporary variable initialized as the root node.
     IntTreeNode temp = root;

     // While left child of temp exists, move to the left child.
     while(temp.left != null)
     {
         temp = temp.left;
     }

     // After iterating all the way to the left we have found the node with the smallest value.       
     return temp;
 }
 
//This method tries to remove the node with a value equal to 'num'.
public boolean remove(int num)
{
  // First, it checks if the num exists in the tree.
  if(!ifExists(num, overallRoot)){
      // If it does not exist, then it returns false.
      return false;
  }
  // If it exists, it calls the private helper method removeNode, which removes the node.
  overallRoot = removeNode(overallRoot, num);
  // Since a node is removed, it decrements the size of the tree.
  size--;
  // It then return true to indicate the successful removal.
  return true;
}

//This is a helper method that removes a node from the tree.
private IntTreeNode removeNode(IntTreeNode root, int num)
{
  // If the root is null, then the tree is empty or the node is not found (base case of recursion).
  if(root == null){
      return null;
  }
  // If the num is less than the root's data, then the num is in the left subtree.
  if(num < root.data){
      // Make a recursive call to remove the num in the left subtree.
      root.left = removeNode(root.left, num);
  }
  // If the num is greater than the root's data, then the num is in the right subtree.
  else if(num > root.data){
      // Make a recursive call to remove the num in the right subtree.
      root.right = removeNode(root.right, num);
  }
  // If the root's data is equal to num, then this is the node to be removed.
  else{
      // If the node's left child is null (i.e., the node has one child or no child),
      // then return the right child, which could also be null.
      if(root.left == null){
          return root.right;
      } 
      // If the node's right child is null, then return the left child.
      else if(root.right == null){
          return root.left;
      }
      // If the node has two children, then find the inorder successor of the node (the smallest
      // in the right subtree). Replace the node's data with the inorder successor's data.
      root.data = minNode(root.right).data;
      // Remove the inorder successor from the right subtree.
      root.right = removeNode(root.right, root.data);
  }
  // Return the updated node/subtree.
  return root;
}
	
// In-order traversal of the tree nodes as a string.
public String toString()
{
    return printTree(overallRoot);
}

// Recursive helper function to print the tree in-order.
private String printTree(IntTreeNode root)
{
    if (root == null) {
        return "";
    }

    // Start with all nodes in the left subtree.
    String inOrderTree = printTree(root.left);

    // Then visit the node itself.
    inOrderTree += root.data + " ";

    // Finally, all nodes in the right subtree.
    inOrderTree += printTree(root.right);
    
    return inOrderTree;
}

// Recursive helper function to check if a value exists in the tree.
private boolean ifExists(int value, IntTreeNode node)
{
    // Check if the node is null (base case).
    if (node == null) {
        return false;
    }

    // If the value of the node is what we are looking for, return true.
    if(node.data == value) {
        return true;
    }

    // If the value is less than the node's value, go to the left subtree.
    // If it's more, go to the right subtree.
    return value < node.data 
        ? ifExists(value, node.left) //Ternary if.
        : ifExists(value, node.right); //Ternary else.
}

// Recursive function to count the leaves in the tree.
private int countTheLeaves(IntTreeNode node)
{
    if (node == null)
        return 0;
    
    // A node is a leaf if both its left and right children are null.
    if (node.left == null && node.right == null)
        return 1;
    else
        // Recursively find the leaves in the left and right subtrees.
        return countTheLeaves(node.left) + countTheLeaves(node.right);
}

}
