package trees;

public class TreeNode {
	int data;
	int label; //use as per convenience
	TreeNode left;
	TreeNode right;
	
	TreeNode(int data){
		this.data = data;
		this.label = -1; //indicating that the node is not labeled
		left = null;
		right = null;
	}
}
