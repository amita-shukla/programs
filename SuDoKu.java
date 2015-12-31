//It works!!
package backtracking;


public class SuDoKu {

	// static ArrayList<ArrayList<String>> solutions;
	static int[][] grid;
	static final int SIZE = 9;

	public static void main(String[] args) {
		// Grid Initialization
		grid = new int[][] { { 0, 0, 5, 3, 0, 0, 0, 0, 0 },
				{ 8, 0, 0, 0, 0, 0, 0, 2, 0 }, { 0, 7, 0, 0, 1, 0, 5, 0, 0 },
				{ 4, 0, 0, 0, 0, 5, 3, 0, 0 }, { 0, 1, 0, 0, 7, 0, 0, 0, 6 },
				{ 0, 0, 3, 2, 0, 0, 0, 8, 0 }, { 0, 6, 0, 5, 0, 0, 0, 0, 9 },
				{ 0, 0, 4, 0, 0, 0, 0, 3, 0 }, { 0, 0, 0, 0, 0, 9, 7, 0, 0 } };

		// solutions = new ArrayList<ArrayList<String>>();
		Cell first = new Cell(0, 0);
		solve(first);
		// if (solve(first))
		// System.out.println(solutions.toString());
		// else
		// System.out.println("No solutions found");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(" " + grid[i][j]);
			}
			System.out.println();
		}
	}

	private static boolean solve(Cell current) {
		// base case
		if (current == null) {
			// addGrid();
			return true; // A solution has been found.
		}

		// If the cell has a value, no processing needs to be done. Jump to next
		// cell.
		if (grid[current.row][current.col] != 0)
			return solve(nextCell(current));

		// now try each value 1-9
		for (int val = 1; val <= 9; val++) {
			if (!isValid(current, val)) // if this val is not valid
				continue; // check for next val

			grid[current.row][current.col] = val;

			if (solve(nextCell(current))) // if the next Cell also gets solved
				return true;
			else
				grid[current.row][current.col] = 0; // reset
		}

		// if we have get here, means none of the values satisfy the cell.
		return false;
	}

	private static Cell nextCell(Cell current) {
		int row = current.row;
		int col = current.col;

		// next cell => col++
		col++;

		// if col > 8, then col = 0, row++
		// reached end of row, got to next row
		if (col > 8) {
			// goto next line
			col = 0;
			row++;
		}

		// reached end of matrix, return null
		if (row > 8)
			return null; // reached end

		Cell next = new Cell(row, col);
		return next;

	}

	private static boolean isValid(Cell cell, int val) {
		// check if any cell has same value in cell row
		int row = cell.row;
		int col = cell.col;
		for (int i = 0; i < 9; i++) {
			if (grid[row][i] == val)
				return false;
		}

		// check if any cell has the same value in cell column
		for (int i = 0; i < 9; i++) {
			if (grid[i][col] == val)
				return false;
		}

		// check if any cell has same value in cell block
		// define limits

		int x1 = (row / 3) * 3;
		int x2 = x1 + 2;
		int y1 = (col / 3) * 3;
		int y2 = y1 + 2;
		System.out.println("x1 = " + x1 + " x2= " + x2 + "y1= " + y1 + " y2="
				+ y2);
		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				System.out.println("i= " + i + " j= " + j);
				if (grid[i][j] == val)
					return false;
			}
		}

		return true;
	}

	/**
	 * 
	 * Add the present state of grid to the solutions. When the grid has been
	 * declared as solution, this method is called.
	 */
	/*
	 * private static void addGrid() { ArrayList<String> gridList = new
	 * ArrayList<>(); for (int i = 0; i < 9; i++) { String row = ""; for (int j
	 * = 0; j < 9; j++) { row = row.concat((String.valueOf(grid[i][j]))); }
	 * gridList.add(row); } solutions.add(gridList); }
	 */
}

class Cell {
	int row;
	int col;

	public Cell(int row, int col) {
		this.row = row;
		this.col = col;
	}
}
