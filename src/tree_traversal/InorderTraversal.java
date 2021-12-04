package tree_traversal;

import java.util.Stack;

import tree_traversal.helper.BinaryTree;
import tree_traversal.helper.Node;

public class InorderTraversal {

	public static void main(String[] args) {
		// left - node - right
		withRecursion(BinaryTree.getBinaryTree());
		System.out.println();
		withOutRecursion(BinaryTree.getBinaryTree());
	}
	
	public static void withRecursion(Node head) {
		if(head==null) return;
		withRecursion(head.left);
		System.out.print(head.key+" ");
		withRecursion(head.right);
	}
	
	public static void withOutRecursion(Node head) {
		if(head==null) return;
		
		Stack<Node> st = new Stack<Node>();
		//tree traversing
		while(head!=null || !st.isEmpty()) {
			
			//Go to left most node of tree
			while(head!=null) {
				st.push(head);
				head = head.left;
			}
			
			//head must be null now
			head = st.pop();
			
			System.out.print(head.key+" ");
			
			//go one step right
			head = head.right;
		}
	}

}
