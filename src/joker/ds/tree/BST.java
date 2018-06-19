package joker.ds.tree;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BST {

	Node root;

	public static void main(String[] args) {
		BST bst = new BST();
		bst.insert(12);
		bst.insert(42);
		bst.insert(112);
		bst.insert(1);
		bst.insert(5);
		bst.insert(7);

		System.out.println("in order :");
		bst.inOrderTravsel();
		System.out.println("------------------------------------------------------------");

		System.out.println("pre order :");
		bst.preOrderTravsel();
		System.out.println("------------------------------------------------------------");

		System.out.println("post order :");
		bst.postOrderTravsel();
		System.out.println("------------------------------------------------------------");

		System.out.println("Is a BST :" + bst.checkForBST());
		System.out.println("------------------------------------------------------------");

		System.out.println("minimum in BST :" + bst.minimumInBST());
		System.out.println("------------------------------------------------------------");

		System.out.println("Delete 12 from BST");
		bst.delete(12);
		System.out.println("After 12 deletion in order");
		bst.inOrderTravsel();
		System.out.println("------------------------------------------------------------");

		System.out.println("Number of Node in BST - " + bst.countNodeInBST());
		System.out.println("------------------------------------------------------------");

		BST bst1 = new BST();
		BST bst2 = new BST();
		Node root1 = null, root2 = null;
		root1 = bst1.insert(root1, 12);
		root1 = bst1.insert(root1, 1112);
		root1 = bst1.insert(root1, 132);
		root1 = bst1.insert(root1, 182);
		root1 = bst1.insert(root1, 1323);

		root2 = bst2.insert(root2, 12);
		root2 = bst2.insert(root2, 1112);
		root2 = bst2.insert(root2, 132);
		root2 = bst2.insert(root2, 182);
		root2 = bst2.insert(root2, 1323);

		System.out.println("Check if BST are identical  - " + bst.checkIfBSTEqual(root1, root2));
		System.out.println("Check if BST are identical recursive  - " + bst.checkIfBSTEqualRecursive(root1, root2));
		System.out.println("BST 1 data : ");
		bst1.inOrderTravsel(root1);
		System.out.println("BST 2 data : ");
		bst2.inOrderTravsel(root2);

		root2 = bst.delete(root2, 12);

		System.out.println("Check if BST are identical after delete node 12 from BST2 - " + bst.checkIfBSTEqual(root1, root2));
		System.out.println("Check if BST are identical after delete node 12 from BST2 recursive- " + bst.checkIfBSTEqualRecursive(root1, root2));
		System.out.println("BST 1 data : ");
		bst1.inOrderTravsel(root1);
		System.out.println("BST 2 data : ");
		bst2.inOrderTravsel(root2);
		System.out.println("------------------------------------------------------------");

		System.out.println(" Before Mirro BST : ");
		bst.inOrderTravsel();
		bst.mirrorBST();
		System.out.println(" After Mirro BST : ");
		bst.inOrderTravsel();
		System.out.println("Back to normal:");
		bst.mirrorBST();
		bst.inOrderTravsel();
		System.out.println("------------------------------------------------------------");
	}

	public void postOrderTravsel() {
		postOrderTravsel(root);
	}

	private void postOrderTravsel(Node r) {
		if (r != null) {
			postOrderTravsel(r.getLeft());
			postOrderTravsel(r.getRight());
			System.out.println(r.getData());
		}
	}

	public void preOrderTravsel() {
		preOrderTravsel(root);
	}

	private void preOrderTravsel(Node r) {
		if (r != null) {
			System.out.println(r.getData());
			preOrderTravsel(r.getLeft());
			preOrderTravsel(r.getRight());
		}
	}

	public void inOrderTravsel() {
		inOrderTravsel(root);
	}

	public void insert(int data) {
		root = insert(root, data);
	}

	private Node insert(Node root, int data) {
		if (null == root) {
			root = new Node(data);
		} else if (data <= root.getData()) {
			root.left = insert(root.getLeft(), data);
		} else if (data > root.getData()) {
			root.right = insert(root.getRight(), data);
		}

		return root;
	}

	private void inOrderTravsel(Node r) {
		if (r != null) {
			inOrderTravsel(r.getLeft());
			System.out.println(r.getData());
			inOrderTravsel(r.getRight());
		}

	}

	public boolean checkForBST() {
		return checkForBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean checkForBST(Node r, int min, int max) {
		if (null == r) {
			return true;
		}
		if (r.getData() < min || r.getData() > max) {
			return false;
		}
		return checkForBST(r.getLeft(), min, r.getData()) && checkForBST(r.getRight(), r.getData(), max);
	}

	public void delete(int data) {
		root = delete(root, data);
	}

	public Node delete(Node r, int data) {
		if (null == r) {
			return r;
		}
		if (data < r.getData()) {
			r.left = delete(r.getLeft(), data);
		} else if (data > r.getData()) {
			r.right = delete(r.getRight(), data);
		} else {
			if (r.getLeft() == null) {
				return r.getRight();
			}
			if (r.getRight() == null) {
				return r.getLeft();
			}

			r.data = minimumInBST(r.getRight());
			r.right = delete(r.right, r.data);
		}

		return r;
	}

	public void mirrorBST() {
		mirrorBST(root);
	}

	private void mirrorBST(Node r) {
		if (null == r) {
			return;
		}
		mirrorBST(r.getLeft());
		mirrorBST(r.getRight());
		Node temp = r.getLeft();
		r.setLeft(r.getRight());
		r.setRight(temp);
	}

	public int minimumInBST() {
		return minimumInBST(root);
	}

	public int minimumInBST(Node r) {
		while (r.getLeft() != null) {
			r = r.getLeft();
		}
		return r.getData();

	}

	public int countNodeInBST() {
		return countNodeInBST(root);
	}

	private int countNodeInBST(Node root) {
		Queue<Node> q = new LinkedList<>();
		if (null == root) {
			return 0;
		}
		q.add(root);
		int count = 0;
		while (!q.isEmpty()) {
			Node temp = q.poll();
			++count;
			if (temp.getLeft() != null) {
				q.add(temp.getLeft());
			}
			if (temp.getRight() != null) {
				q.add(temp.getRight());
			}
		}
		return count;
	}

	public boolean checkIfBSTEqual(Node root1, Node root2) {
		Queue<Node> q1 = new LinkedList<>();
		Queue<Node> q2 = new LinkedList<>();
		if (null == root1 && null == root2) {
			return true;
		}
		q1.add(root1);
		q2.add(root2);
		while (!q1.isEmpty() || !q2.isEmpty()) {
			Node t1 = q1.poll();
			Node t2 = q2.poll();
			if (t1.getData() != t2.getData()) {
				return false;
			} else if ((t1.getLeft() == null && t2.getLeft() != null) || (t1.getLeft() != null && t2.getLeft() == null)) {
				return false;
			} else if ((t1.getRight() == null && t2.getRight() != null) || (t1.getRight() != null && t2.getRight() == null)) {
				return false;
			} else {
				if ((t1.getLeft() != null && t2.getLeft() != null)) {
					q1.add(t1.getLeft());
					q2.add(t2.getLeft());
				}
				if ((t1.getRight() != null && t2.getRight() != null)) {
					q1.add(t1.getRight());
					q2.add(t2.getRight());
				}
			}
		}
		return true;
	}

	public boolean checkIfBSTEqualRecursive(Node root1, Node root2) {
		if (null == root1 && null == root2) {
			return true;
		}
		if (root1 != null && root2 != null) {
			if (root1.getData() == root2.getData() && checkIfBSTEqualRecursive(root1.getLeft(), root2.getLeft())
					&& checkIfBSTEqualRecursive(root1.getRight(), root2.getRight())) {
				return true;
			}
		}
		return false;
	}
}

class Node {
	int data;
	Node left;
	Node right;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node(int data) {
		super();
		this.data = data;
		this.left = null;
		this.right = null;
	}

}
