package trees;

import java.util.Scanner;

public class Tree {

	static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.println("Provide data for the root node\n");
		int rootData = sc.nextInt();
		int rootLabel = 0;
		TreeNode root = new TreeNode(rootData);
		root.label = rootLabel;
		createTree(root);
		System.out.println("==========PREORDER TRAVERSAL==========");
		pretrav(root);
		System.out.println("==========INORDER TRAVERSAL==========");
		intrav(root);
		System.out.println("==========POSTORDER TRAVERSAL==========");
		posttrav(root);
	}

	public static void pretrav(TreeNode root) {
		if (root != null) {
			System.out.println(root.data);
			pretrav(root.left);
			pretrav(root.right);
		}
	}

	public static void intrav(TreeNode root) {
		if (root != null) {
			intrav(root.left);
			System.out.println(root.data);
			intrav(root.right);
		}
	}

	public static void posttrav(TreeNode root) {
		if (root != null) {
			posttrav(root.left);
			posttrav(root.right);
			System.out.println(root.data);
		}
	}

	public static void createTree(TreeNode root) {
		if (root == null)
			return;

		TreeNode left = null;
		TreeNode right = null;
		int data = -1;
		System.out.println("Enter data for left child of node " + root.label
				+ " Enter -1 if left child doesn't exist");
		data = sc.nextInt();
		if (data != -1) {
			left = new TreeNode(data);
			left.label = 2 * root.label + 1;
			root.left = left;
		}

		data = -1;
		System.out.println("Enter data for right child of node " + root.label
				+ " Enter -1 if right child doesn't exist");
		data = sc.nextInt();
		if (data != -1) {
			right = new TreeNode(data);
			right.label = 2 * root.label + 2;
			root.right = right;
		}

		createTree(root.left);
		createTree(root.right);
	}
}
