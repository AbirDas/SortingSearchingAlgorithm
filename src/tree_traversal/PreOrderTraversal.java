package tree_traversal;

import java.util.Stack;

import tree_traversal.helper.BinaryTree;
import tree_traversal.helper.Node;

public class PreOrderTraversal {

	public static void main(String[] args) {
		// root - left - right
		withRecursion(BinaryTree.getBinaryTree());
		System.out.println();
		withOutRecursion(BinaryTree.getBinaryTree());
	}

	private static void withRecursion(Node head) {
		if(head==null) return;
		
		System.out.print(head.key+" ");
		withRecursion(head.left);
		withRecursion(head.right);
	}
	
	private static void withOutRecursion(Node head) {
		if(head==null) return;
		
		Stack<Node> st = new Stack<Node>();
		st.push(head);
		
		while(!st.isEmpty()) {
			Node curr = st.pop();
			System.out.print(curr.key+" ");
			
			if(curr.right!=null) st.push(curr.right);
			if(curr.left!=null) st.push(curr.left);
		}
	}
}
