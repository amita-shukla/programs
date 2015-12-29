package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueens {

	private static boolean[][] board;
	static ArrayList<ArrayList<String>> solutions;
	private static int boardSize;
	private static boolean colEmpty[]; // true if no queens in col
	private static boolean upDiagEmpty[]; // true if no queens in diagonals
	private static boolean downDiagEmpty[];

	public static void main(String[] args) {
		
		solveNQueens(8);
		System.out.println(solutions.toString());

	}

	public static void solveNQueens(int n) {
		// take the board as a boolean array. A true value indicates the
		// presence of queen.
		board = new boolean[n][n];
		boardSize = n;
		solutions = new ArrayList<ArrayList<String>>();
		colEmpty = new boolean[n];
		upDiagEmpty = new boolean[2 * n - 1];
		downDiagEmpty = new boolean[2 * n - 1];
		Arrays.fill(colEmpty,true);
		Arrays.fill(upDiagEmpty, true);
		Arrays.fill(downDiagEmpty, true);

		// try one row at a time
		findSafeColumn(0);
		
		//return solutions;
	}

	private static void findSafeColumn(int row) {
		if (row == (boardSize)) {
			addBoard();
			return;
		}

		// iterate over each column
		for (int col = 0; col < boardSize; col++) {
			if (isSafe(row, col)) {
				placeQueen(row, col);
				
				// move on to next row
				findSafeColumn(row + 1);

				// when we have got here, means backTracked.
				// now remove the queen you have placed so as to check the next col

				removeQueen(row, col);
			}			
		}
	}

	private static void removeQueen(int row, int col) {
		board[row][col] = false;
		colEmpty[col] = true;
		upDiagEmpty[row + col] = true;
		downDiagEmpty[boardSize - 1 + row - col] = true;
	}

	private static void placeQueen(int row, int col) {
		board[row][col] = true;
		colEmpty[col] = false;
		upDiagEmpty[row + col] = false;
		downDiagEmpty[boardSize - 1 + row - col] = false;
	}

	private static boolean isSafe(int row, int col) {
		// if col & up diag & down diag is empty, then the given position is
		// safe
		if (colEmpty[col] && upDiagEmpty[row + col]
				&& downDiagEmpty[boardSize - 1 + row - col]) {
			return true;
		}
		return false;
	}

	private static void addBoard() {
		ArrayList<String> boardList = new ArrayList<>();
		for(int i=0; i<boardSize;i++){
			String row = "";
			for(int j=0;j<boardSize;j++){
				if(board[i][j])
					row = row.concat("Q");
				else
					row = row.concat(".");
			}
			boardList.add(row);
		}
		solutions.add(boardList);
	}

}
