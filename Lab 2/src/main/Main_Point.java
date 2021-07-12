package main;

import abstractions.BinaryTreeSet;
import abstractions.Comparator;
import abstractions.Greater;
import abstractions.Set;
import abstractions.Point;

public class Main_Point {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Greater comp = new Comparator();
		Set binaryTree = new BinaryTreeSet(comp);
		Point point1 = new Point(0,0);
		Point point2 = new Point(0,0);
		
		binaryTree.insert(point1);
		binaryTree.insert(point2);
		System.out.println(binaryTree.size());
		System.out.println(binaryTree.toString());
	}
}

/*
 * 2. Open up BinaryTreeSet.java in Eclipse and remove the phrase "implements Set" from the definition of the BinaryTreeSet class. What happens in the IDE and why? 
The IDE gives an error because the BinaryTreeSet file is missing its method definitions that come from the Set interface. The set interface says what methods and variables will be implemented in the BinaryTreeSet file and the BinaryTreeSet file defines how each function works
 */
 