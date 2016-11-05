package algorism.binary.search.tree;

import algorism.utils.BaseUtils;

public class BinarySearchTree {
	public TreeNode root = new TreeNode();
	
	public TreeNode insert(TreeNode parent, Integer param) {
		TreeNode newNode = new TreeNode(param);
		if(parent == null) {
			return newNode;
		} else if(parent.getData() > param) {
			parent.setLeft(insert(parent.left, param));
			return parent;
		} else if(parent.getData() < param) {
			parent.setRight(insert(parent.right, param));
			return parent;
		} else {
			return parent;
		}
	}
	
	public TreeNode search(int param) {
		TreeNode parent = root;
		while(parent != null) {
			if(parent.getData() > param) {
				parent = parent.getLeft();
			} else if(parent.getData() < param) {
				parent = parent.getRight();
			} else {
				return parent;
			}
		}
		return parent;
	}
	
	public TreeNode delete(int param) {
		TreeNode deleteNode = search(param);
		return null;
	}
	
	public void inOrder(TreeNode root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		Integer[] intArray = BaseUtils.getRandomIntegerArrayNoDup(30, 50);
		bst.root.setData(51);
		for(Integer integer : intArray) {
			bst.insert(bst.root, integer);
		}
		System.out.println("입력을 완료하였습니다.");
		bst.inOrder(bst.root);
		System.out.println("");
		
		TreeNode searchTn = bst.search(intArray[17]);
		if(searchTn != null) {
			System.out.println(intArray[17]+"에 대한 탐색을 완료했습니다.");
			bst.inOrder(searchTn);
		} else {
			System.out.println("탐색을 실패했습니다.");
		}
		
		
	}
	
	class TreeNode {
		private TreeNode right, left;
		private int data;
		
		public TreeNode() {
			
		}
		
		public TreeNode(int data) {
			this.data = data;
		}
		public TreeNode getRight() {
			return right;
		}
		public void setRight(TreeNode right) {
			this.right = right;
		}
		public TreeNode getLeft() {
			return left;
		}
		public void setLeft(TreeNode left) {
			this.left = left;
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		
	}

}
