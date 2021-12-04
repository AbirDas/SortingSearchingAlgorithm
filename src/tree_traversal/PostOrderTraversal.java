package tree_traversal;

import java.util.Stack;

import tree_traversal.helper.BinaryTree;
import tree_traversal.helper.Node;

public class PostOrderTraversal {

	public static void main(String[] args) {
		// left - right - root
		withRecursion(BinaryTree.getBinaryTree());
		System.out.println();
		withOutRecursion(BinaryTree.getBinaryTree());
	}

	private static void withRecursion(Node head) {
		if(head==null) return;
		
		withRecursion(head.left);
		withRecursion(head.right);
		System.out.print(head.key+" ");
	}
	
	private static void withOutRecursion(Node head) {
		if(head==null) return;
		
		Stack<Node> fst = new Stack<Node>();
		Stack<Node> sst = new Stack<Node>();
		
		fst.push(head);
		
		while(!fst.isEmpty()) {
			
			Node curr = fst.pop();
			sst.push(curr);
			
			if(curr.left!=null) fst.push(curr.left);
			if(curr.right!=null) fst.push(curr.right);
		}
		
		while(!sst.isEmpty())
			System.out.print(sst.pop().key+" ");
	}

}
