/**
Given a collection of numbers, return all possible permutations.

For Example:

[1,2,3] will have the following permutations:

[1,2,3]
[1,3,2]
[2,1,3] 
[2,3,1] 
[3,1,2] 
[3,2,1]

For each element from left to right, you generate all the permutations of the remaining elements. 
You can do this recursively, (or iteratively if you like pain)
until you get to the last element at which point there is only one possible order.

So, given a list: [1,2,3,4]

You just generate all permutations that start with 1, 
then all the permutations that start with 2, then with 3 and 4.

This effectively reduces the problem from one of finding permutations of a list of four elements to a list of three elements. 
Once you continue reducing to 2 and then 1 element, you have all of them.

**/


public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(2);
		a.add(3);
		// output = new ArrayList<ArrayList<Integer>>();
		// System.out.println(a.toString());
		// System.out.println(generateAllPermutations(a).toString());
		 System.out.println(permute3(a).toString());
	}

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
	   ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		if(a.size()==1){
			ArrayList<Integer> seq = new ArrayList<>();
			seq.add(a.get(0));
			ans.add(seq);
			return ans;
		}
			
		//System.out.println(a);
		for(int i=0;i <a.size();i++){
			int number = a.get(i);
			//System.out.println("no= "+number);
			ArrayList<Integer> rem = new ArrayList<>(a);
			rem.remove(i);
			for(ArrayList<Integer> sequence: permute(rem)){
				sequence.add(0, number);
				ans.add(sequence);
				//System.out.println(ans.toString());
			}
		}
		return ans;
	}
}

