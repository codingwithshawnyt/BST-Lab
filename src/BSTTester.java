import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Iterator;
import java.io.PrintStream;

public class BSTTester
{
	public static void main(String args[]) 
	{
		BinarySearchIntTree tree = new BinarySearchIntTree();
		BinaryTreePrinter treePrinter = new BinaryTreePrinter();
		
		//Populating the Tree
		System.out.println("Adding values to Tree:");
		int[] data = {18, 12, 35, 4, 15, 22, 58, -2, 7, 13, 16, 19, 31, 40, 87};
		for(int i = 0; i < data.length; i++)
		{
			System.out.printf("\tAdding %d: ", data[i]);
			try{System.out.println(tree.add(data[i]) ? "Successful": "FAILED - returned false");}catch(Exception e){System.out.println("FAILED - Got "+e);}
		}
		System.out.println(tree);
		
		//Testing 1 aspect of size
		boolean initialSize;
		try{initialSize = tree.getSize() == 15 ? true : false;}catch(Exception e){initialSize = false;}
		
		//Printing a visual of the tree
		System.out.println("\nPrinting Tree as a tree: ");
		try{treePrinter.printPreOrder(System.out, tree.overallRoot);}catch(Exception e){System.out.println("FAILED - Got "+e);}
		
		//Printing a the tree as a list of numbers (in-order)
		System.out.println("\nDisplay all value in the tree using the toString() method: ");
		try{System.out.println("\t"+tree);}catch(Exception e){System.out.println("FAILED - Got "+e);}
		
		
		//Checking to ensure the numbers are in numerical order
		System.out.print("Checking if Items are stored in-order: ");
		try{
			String[] stringParse = tree.toString().split(" ");
			int[] inOrderCheck = new int[stringParse.length];
			for(int i = 0;i < stringParse.length;i++)
			{
			   inOrderCheck[i] = Integer.parseInt(stringParse[i]);
			}
			int index = 0;
			while(index!=inOrderCheck.length-1)
			{
				if(inOrderCheck[index]>=inOrderCheck[index+1])
				{
					System.out.println("FAILED - Values are not in Order");
					break;
				}
				else if(index == inOrderCheck.length-2)
				{
					System.out.println("PASSED");
				}
				index++;
			}
		}
		catch(Exception e)
		{
			System.out.println("FAILED - got " + e);
		}
		
		//Testing the remove method
		System.out.println("Remove Test: ");
		String[] type = {"Leaf", "Branch", "Branch", "Branch", "Overall Root"};
		int[] num =     {  -2,      15,       22,      12,           18};
		
		for(int x = 0; x < type.length; x++)
		{
			System.out.print("\tRemove "+type[x]+" Node ["+num[x]+"]: ");
			removeTestCase(tree, num[x]);
		}
		
		System.out.println();
		
		try{System.out.println("\tTo String (in-order): "+tree+"\n");}catch(Exception e){System.out.println("FAILED - Got "+e);}
		try{treePrinter.printPreOrder(System.out, tree.overallRoot);}catch(Exception e){System.out.println("FAILED - Got "+e);}
	
		//Size Test, part 2
		System.out.println("\n\nTest Size: ");
		System.out.println("\tAdd Updating Size? " + initialSize);
		System.out.print("\tRemove Updating Size? ");
		int sizeBefore;
		try{
			sizeBefore = tree.getSize();
			tree.remove(40);
			System.out.println(sizeBefore-1 == tree.getSize()? "true" : "false");
		}	
		catch(Exception e) {System.out.println("FAILED - got " + e);}
	}
	
	private static void removeTestCase(BinarySearchIntTree tree, int data)
	{
		Boolean removed;
		try{
			removed = tree.remove(data); 
			System.out.print(tree);
			if (removed == false)
				System.out.println("FAILED, "+data+" not found!");
			else
				System.out.println(tree.contains(data)? data+" is still in the tree":"PASSED");
		}
		catch(Exception e){
			System.out.println("FAILED - Got "+e);
		}
	}
}


class BinaryTreePrinter {

    public BinaryTreePrinter() {}
    
	private String traversePreOrder(IntTreeNode root) {

        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.data);
        
        String pointerRight ="[R]--";
        String pointerLeft = (root.right != null) ? "[L]--" : "[L]--";

        traverseNodes(sb, "", pointerLeft, root.left, root.right != null);
        
        traverseNodes(sb, "", pointerRight, root.right, false);

        return sb.toString();
    }
    private void traverseNodes(StringBuilder sb, String padding, String pointer, IntTreeNode node, boolean hasRightSibling) {

        if (node != null) {

            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.data);

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("|    ");
            } else {
                paddingBuilder.append("     ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "[R]--";
            String pointerLeft = (node.right != null) ? "[L]--" : "[L]--";

            traverseNodes(sb, paddingForBoth, pointerLeft, node.left, node.right != null);
            traverseNodes(sb, paddingForBoth, pointerRight, node.right, false);

        }

    }

    public void printPreOrder(PrintStream os, IntTreeNode overallRoot) {
        os.print(traversePreOrder(overallRoot));
    }


}
