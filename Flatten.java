package trees;
/**
 * 
 * Given a binary tree, flatten it to a linked list in-place.

Example :
Given


         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 *
 */

public class Flatten {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		
		TreeNode flattened = flatten(root);
		
		Tree.intrav(flattened);
	}
	
	public static TreeNode flatten(TreeNode root){
		if(root==null)
			return null;
		
	//	TreeNode left = root.left;
		//TreeNode right  = root.right;
		TreeNode left = flatten(root.left);
		 TreeNode right = flatten(root.right);
		//System.out.println("left data= "+left.data+" right data= "+right.data);
		root.left = null;
		root.right = left;
		
		if(root.right == null)
			root.right = right;
		else{
			TreeNode temp = root.right;
			while(temp.right != null)
				temp = temp.right;
			temp.right = right;
		}
			
		return root;
	}

}
