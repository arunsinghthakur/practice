package joker.ds.tree;

import java.util.Stack;

public class PreOrderToBST extends BST {

	public static void main(String[] args) {
		PreOrderToBST bst = new PreOrderToBST();
		Node root = bst.bstFromPreOrder(new int[] { 12, 9, 8, 10, 15, 16 });
		System.out.println("Tree from pre order is - Using in order travsel");
		bst.inOrderTravsel(root);
		System.out.println("------------------------------------------------------------");

		System.out.println("Check for valid preorder - { 12, 9, 8, 10, 15, 16 }" + bst.checkForValidPreOrder(new int[] { 12, 9, 8, 10, 15, 16 }));
		System.out.println("------------------------------------------------------------");

		System.out.println("Check for valid preorder - { 12, 9, 8, 10, 15, 2 }" + bst.checkForValidPreOrder(new int[] { 12, 9, 8, 10, 15, 2 }));
		System.out.println("------------------------------------------------------------");
	}

	public boolean checkForValidPreOrder(int[] a) {
		Stack<Integer> s = new Stack<>();
		int top = -1;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < top) {
				return false;
			}
			while (!s.empty() && a[i] > s.peek()) {
				top = s.peek();
				s.pop();
			}

			s.add(a[i]);
		}
		return true;

	}

	public Node bstFromPreOrder(int[] a) {
		Stack<Node> s = new Stack<>();
		Node r = new Node(a[0]);
		s.add(r);
		for (int i = 1; i < a.length; i++) {
			Node temp = null;
			while (!s.empty() && a[i] > s.peek().getData()) {
				temp = s.pop();
			}

			if (temp != null) {
				temp.setRight(new Node(a[i]));
				s.add(temp.getRight());
			} else {
				temp = s.peek();
				temp.setLeft(new Node(a[i]));
				s.add(temp.getLeft());
			}
		}
		return r;
	}
}
