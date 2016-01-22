/**
Given a binary tree, return the level order traversal of its nodes’ values. (ie, from left to right, level by level).

Example :
Given binary tree

    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]


**/

public class Solution {
    int prvsLevel;
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
	    ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
	    prvsLevel = -1;
	    if(root == null)
	        return ans;
	   
	    TreeWrapper twRoot = new TreeWrapper(root,0);
	    Queue<TreeWrapper> q = new LinkedList<>();
	    q.add(twRoot);
	    
	    ArrayList<Integer> level;
	    
	    while(!q.isEmpty()){
	        TreeWrapper tw = q.remove();
	        int l = tw.l;
	        
	        if(l != prvsLevel){
	            //this node is at the new level
	            level = new ArrayList<>();
	            level.add(tw.t.val);
	            ans.add(level);
	        }else{
	            //the node discovered is at the same level
	            level = ans.get(l);
	            level.add(tw.t.val);
	        }
	            
	       TreeNode node = tw.t;
	       TreeNode left = node.left;
	       TreeNode right = node.right;
	       if(left != null){
	           TreeWrapper twL = new TreeWrapper(left,l+1);
	           q.add(twL);
	           
	       }
	       if(right != null){
	           TreeWrapper twR = new TreeWrapper(right, l+1);
	           q.add(twR);
	       }
	       prvsLevel = l;
	    }
	    
	    return ans;
	}
}

class TreeWrapper{
    TreeNode t;
    int l;//level
    
    TreeWrapper(TreeNode t, int level){
        this.t = t;
        l = level;
    }
}

