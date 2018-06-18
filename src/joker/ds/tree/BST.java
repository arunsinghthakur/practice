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

		System.out.println("Delete 42 from BST");
		bst.delete(42);
		System.out.println("After 42 deletion in order");
		bst.inOrderTravsel();
		System.out.println("------------------------------------------------------------");

		System.out.println("Delete 12 from BST");
		bst.delete(12);
		System.out.println("After 12 deletion in order");
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

	public int minimumInBST() {
		return minimumInBST(root);
	}

	public int minimumInBST(Node r) {
		while (r.getLeft() != null) {
			r = r.getLeft();
		}
		return r.getData();

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
