package joker.ds.tree;

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

		System.out.println("pre order :");
		bst.preOrderTravsel();

		System.out.println("post order :");
		bst.postOrderTravsel();
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
