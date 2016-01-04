/**
I define the height as the number of edgest from a given node to the bootom most leaf node.
So, a balanced tree with 3 nodes, height = 1;
a tree, with 2 nodes, height = 1;
a tree, with 1 node, height = 0;
a null tree, height = -1;
**/

public class TreeHeight{
	public static int findHeight(TreeNode root){
		if(root==null)
			return -1;
		
		int height = Math.max(findHeight(root.left),findHeight(root.right))+1;
		return height;
	}
}
