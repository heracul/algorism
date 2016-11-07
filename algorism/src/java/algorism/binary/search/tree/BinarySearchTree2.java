package algorism.binary.search.tree;

public class BinarySearchTree2 {
	private Node root;
	class Node {
		private Node left;
		private Node right;
		private Integer value;
		
		public Node(Integer value) {
			this.value = value;
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
		public Integer getValue() {
			return value;
		}
		public void setValue(Integer value) {
			this.value = value;
		}
	}
	public Node getRoot() {
		if(root == null) {
			root = new Node(0);
		}
		return root;
	}
	
	public Node insert(Node parentNode, Integer value) {
		Node newNode = new Node(value);
		if(parentNode == null) {
			return newNode;
		}
		
		if(value > parentNode.getValue()) {
			insert(parentNode.getRight(), value);
			return parentNode;
		} else if(value < parentNode.getValue()){
			insert(parentNode.getLeft(), value);
			return parentNode;
		}
		return parentNode;
	}
	
	public Node search(Integer value) {
		Node parentNode = getRoot();
		while(parentNode != null ) {
			if(getRoot().getValue() > value) {
				parentNode = getRoot().getLeft();
			} else if(getRoot().getValue() < value) {
				parentNode = getRoot().getRight();
			} else {
				return parentNode;
			}
		}
		return parentNode;
	}
}
