/**
create another array and interchange 1st row with n-1 th column
									 2nd row with n-1-1 the column and so on
refer geeks for geeks for above algorthm

to rotate a matrix in place (cannot create another array)

    http://stackoverflow.com/questions/3140797/rotate-a-2d-array-in-place-without-using-a-new-array-best-c-solution
	clockwise: interchange 1 st row with n-1 th row
						   2nd row with n-1-1 the row and so on
			    transpose.
**/
				int n=a.size();
	    //interchange the rows
	    for(int i=0;i<n/2;i++){
	        for(int j=0;j<n;j++){
	            int temp=a.get(i).get(j);
	            a.get(i).set(j,a.get(n-1-i).get(j));
	            a.get(n-1-i).set(j,temp); 
	        }
	    }
	    //transpose
	    for(int i=0;i<n;i++){
	        for(int j= i+1; j<n;j++){
	            //swap
	            int temp=a.get(i).get(j);
	            a.get(i).set(j,a.get(j).get(i));
	            a.get(j).set(i,temp);
	        }
	    }
/**	
	anticlockwise:
		transpose and then interchange rows
		
Another answer (the actual solution):
**/
	void rotate(vector<vector<int> > &matrix) {

        int len = matrix.size();
        for (int i = 0; i < len / 2; i++) {
            for (int j = i; j < len - i - 1; j++) {
            int tmp = matrix[i][j];
            matrix[i][j] = matrix[len - j - 1][i];
            matrix[len - j - 1][i] = matrix[len - i - 1][len - j - 1];
            matrix[len - i - 1][len - j - 1] = matrix[j][len - i - 1];
            matrix[j][len - i - 1] = tmp;
            }
        }
    }
