/**
Given a 2 * N Grid of numbers, choose numbers such that the sum of the numbers
is maximum and no two chosen numbers are adjacent horizontally, vertically or diagonally, and return it.

Example:

Grid:
	1 2 3 4
	2 3 4 5
so we will choose
3 and 5 so sum will be 3 + 5 = 8


Note that you can choose more than 2 numbers

**/

/**

We know that within a column, we can choose at max 1 element. 
And choosing either of those elements is going to rule out choosing anything from the previous or next column. 
This means we can choose either of V[0][i] or V[1][i] and can rule out the next and prvs columns.
So, instead we replace each column with a single element which is the max of V[0][i], V[1][i].

Now we have the list as : 
2 3 4 5

Here we can see that we have reduced our problem into another simpler problem.
Now we want to find maximum sum of values where no 2 values are adjacent. 

we take a dp where we keep the max and compare the sum of dp[i] and dp[i-2] with that stored in dp[i-1]

**/

public class DpAdjacent {
	public int adjacent(ArrayList<ArrayList<Integer>> a) {
	    int n = a.get(0).size();
	    
	    if(n==0)
	        return 0;
	    
	    if(n == 1)
	        return Math.max(a.get(0).get(0), a.get(1).get(0));
	    
	    int[] dp = new int[n];
	    
	    
	    for(int i = 0; i < n; i++){
	        dp[i] = Math.max(a.get(0).get(i), a.get(1).get(i));
	    }
	    
	    dp[1] = Math.max(dp[0],dp[1]);
	    
	    for(int i = 2; i < n; i++){
	        dp[i] = Math.max(dp[i-2]+dp[i], dp[i-1]);
	    }
	    
	    return dp[n-1];
	}
}

/**
A memoised recursive c++ solution
that may be helpful to understand tha approach

#include <bits/stdc++.h>
#define R 2
#define C 4
using namespace std;
int dp[100000];
 
int getmaxsum(int arr[][C], int c) {
     
    if(c < 0) return 0;
     
    if(dp[c] != -1) return dp[c];
     
    return dp[c] = max(max(arr[0][c], arr[1][c]) + getmaxsum(arr, c-2), getmaxsum(arr, c-1));
}
 
int solve(int arr[][C]) {
     
    memset(dp, -1, sizeof dp);  
    cout << getmaxsum(arr, C-1) << endl;
}
 
int main() {
    
    int b[][4] = {  {1, 2, 3, 4},
                    {2, 3, 4, 5}
                 };
    solve(b);
    return 0;
}
**/
