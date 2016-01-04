public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;
        invertTree(root.left);
        invertTree(root.right);
        //swap two trees
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        return root;
    }
}
