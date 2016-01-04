/**
Check if two trees are completely identical,
that is, have same data and structure.
**/
public class SameTree {
	public boolean isSameTree(TreeNode a, TreeNode b) {
	    if(a == null && b == null)
	        return true;
	   if(a == null || b == null)
	    return false;
	   
	   if((a.val == b.val) &&(isSameTree(a.left,b.left)) && (isSameTree(a.right,b.right)) )
	    return true;
	    
	   return false;
	}
}

