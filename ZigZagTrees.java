package trees;

import java.util.ArrayList;

public class ZigZagTrees {

	static ArrayList<ArrayList<Integer>> sol;
	static int flag = 0;
	public static void main(String[] args) {
		sol = new ArrayList<ArrayList<Integer>>();
		TreeNode root = new TreeNode(1);
		int height = findHeight(root);
		for(int i =0; i <= height;i++){
			sol.add(addLevel(root,i));
		}

	}
	private static ArrayList<Integer> addLevel(TreeNode root, int height) {
		ArrayList<Integer> level = new ArrayList<>();
		if(height == 0){
			level.add(root.data);
			return level;
		}else{
			if(flag == 0){
				level.addAll(addLevel(root.left,height-1));
				level.addAll(addLevel(root.right,height-1));
			}else{
				level.addAll(addLevel(root.right,height-1));
				level.addAll(addLevel(root.left,height-1));
			}
		}
		
		return level;
	}
	
	
	public static int findHeight(TreeNode root){
		if(root==null)
			return -1;
		
		int height = Math.max(findHeight(root.left),findHeight(root.right))+1;
		return height;
	}
	

}
