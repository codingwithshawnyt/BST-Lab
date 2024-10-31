/*
 * BSTReplicated.java
 * Shawn Ray
 * Period 4
 * The purpose of this file as part of the whole application is to test out BinarySearchIntTree,
 * its constructors, and its methods.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class BSTReplicated {

    public static void main(String[] args) {

        // Students create 2 BinarySearchIntTree objects.
        // a) Uses the default constructor
        BinarySearchIntTree tree1 = new BinarySearchIntTree();

        // b) Uses the constructor that allows an integer value to be passed in.
        BinarySearchIntTree tree2 = new BinarySearchIntTree(50);

        // Test out each of your various methods (getSize, clear, isEmpty, add, findParent, contains, remove, toString))
        // using either of the instantiated BinarySearchIntTree objects

        // Testing tree1 (default constructor)
        System.out.println("Tree 1 (Default Constructor):");
        testBinarySearchTree(tree1);

        // Testing tree2 (constructor with initial value 50)
        System.out.println("\nTree 2 (Constructor with Initial Value 50):");
        testBinarySearchTree(tree2);
    }

    // Utility method to test various methods of BinarySearchIntTree
    private static void testBinarySearchTree(BinarySearchIntTree tree) {
        System.out.println("Initial State:");
        System.out.println("Tree Size: " + tree.getSize());
        System.out.println("Is Tree Empty? " + tree.isEmpty());
        System.out.println("Tree Contents: " + tree.toString());

        // Add elements to the tree
        tree.add(30);
        tree.add(70);
        tree.add(20);
        tree.add(40);
        tree.add(60);
        tree.add(80);

        System.out.println("\nAfter Adding Elements:");
        System.out.println("Tree Size: " + tree.getSize());
        System.out.println("Is Tree Empty? " + tree.isEmpty());
        System.out.println("Tree Contents: " + tree.toString());

        // Testing contains method
        int valueToCheck = 40;
        System.out.println("\nDoes Tree Contain " + valueToCheck + "? " + tree.contains(valueToCheck));

        // Testing remove method
        int valueToRemove = 70;
        System.out.println("\nRemoving " + valueToRemove + " from the Tree:");
        tree.remove(valueToRemove);
        System.out.println("Tree Size after Removal: " + tree.getSize());
        System.out.println("Tree Contents after Removal: " + tree.toString());

        // Testing clear method
        System.out.println("\nClearing the Tree:");
        tree.clear();
        System.out.println("Tree Size after Clearing: " + tree.getSize());
        System.out.println("Is Tree Empty after Clearing? " + tree.isEmpty());
        System.out.println("Tree Contents after Clearing: " + tree.toString());
    }
}
