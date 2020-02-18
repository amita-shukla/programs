/**
 *

 Given a matrix, A of size M x N of 0s and 1s. If an element is 0, set its entire row and column to 0.

 Note: This will be evaluated on the extra memory used. Try to minimize the space and time complexity.


 Input Format:

 The first and the only argument of input contains a 2-d integer matrix, A, of size M x N.

 Output Format:

 Return a 2-d matrix that satisfies the given conditions.

 Constraints:

 1 <= N, M <= 1000
 0 <= A[i][j] <= 1

 Examples:

 Input 1:
 [   [1, 0, 1],
 [1, 1, 1],
 [1, 1, 1]   ]

 Output 1:
 [   [0, 0, 0],
 [1, 0, 1],
 [1, 0, 1]   ]

 Input 2:
 [   [1, 0, 1],
 [1, 1, 1],
 [1, 0, 1]   ]

 Output 2:
 [   [0, 0, 0],
 [1, 0, 1],
 [0, 0, 0]   ]


 */

package main.java.com.amita;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {

	// TLE
	public void setZeroes(int[][] a){
		int m = a.length;
		int n = a[0].length;

		//iterate over matrix
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(a[i][j] == 0){
					// set the entire row and column as -1
					for (int k = 0; k < n; k++) {
						if(a[i][k]!=0) a[i][k] = -1;
					}
					for (int l = 0; l < m; l++) {
						if(a[l][j]!=0) a[l][j] = -1;
					}
				}
			}
		}

		//iterate again
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(a[i][j]==-1) a[i][j] = 0;
			}
		}

//		return a;
	}

	public void setZeroes2(ArrayList<ArrayList<Integer>> a){
		int m = a.size();
		int n = a.get(0).size();

		//iterate over matrix
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(a.get(i).get(j) == 0){
					// set the entire row and column as -1
					for (int k = 0; k < n; k++) {
						if(a.get(i).get(k)!=0) a.get(i).set(k,-1);
					}
					for (int l = 0; l < m; l++) {
						if(a.get(l).get(j)!=0) a.get(i).set(l,-1);
					}
				}
			}
		}

		//iterate again
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(a.get(i).get(j)==-1) a.get(i).set(j,0);
			}
		}

//		return a;
	}

	// this is good, but there is a better solution: treat the first row and column in the matrix as the rows and column array to store the info
	public void setZeroes3(ArrayList<ArrayList<Integer>> a){
		int m = a.size();
		int n = a.get(0).size();

		Set<Integer> rows = new HashSet<>();
		Set<Integer> cols = new HashSet<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(a.get(i).get(j) == 0){
					rows.add(i);
					cols.add(j);
				}
			}
		}


		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(rows.contains(i) || cols.contains(j)){a.get(i).set(j,0);}
			}
		}

	}

	public static void main(String[] args) {
		SetMatrixZeroes obj = new SetMatrixZeroes();
		int[][] a = {{1,0,1},{1,1,1},{1,0,1}};
		obj.setZeroes(a);
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(" " + a[i][j]);
			}
			System.out.println();
		}

		int[][] b = {{1,0,1},{1,1,1},{1,1,1}};
		obj.setZeroes(b);

		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				System.out.print(" " + b[i][j]);
			}
			System.out.println();
		}
	}
}
