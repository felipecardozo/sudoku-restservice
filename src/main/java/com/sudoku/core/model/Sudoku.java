package com.sudoku.core.model;

import org.springframework.stereotype.Component;

@Component
public class Sudoku {
	/** The model */
	private int model[][];
	
	private String message;
	
	protected static final int ROWS = 9;
	protected static final int COLS = 9;
	
	/** This method is called by the browser when the applet is loaded */
	public Sudoku() {
		createModel();
		message = "solution not found, keep trying";
	}

	/** Creates the model and sets up the initial situation */
	protected void createModel() {
		model = new int[Sudoku.ROWS][Sudoku.COLS];

		// Clear all cells
		for (int row = 0; row < Sudoku.ROWS; row++)
			for (int col = 0; col < Sudoku.COLS; col++)
				model[row][col] = 0;

		// Create the initial situation
		model[0][0] = 9;
		model[0][4] = 2;
		model[0][6] = 7;
		model[0][7] = 5;

		model[1][0] = 6;
		model[1][4] = 5;
		model[1][7] = 4;

		model[2][1] = 2;
		model[2][3] = 4;
		model[2][7] = 1;

		model[3][0] = 2;
		model[3][2] = 8;

		model[4][1] = 7;
		model[4][3] = 5;
		model[4][5] = 9;
		model[4][7] = 6;

		model[5][6] = 4;
		model[5][8] = 1;

		model[6][1] = 1;
		model[6][5] = 5;
		model[6][7] = 8;

		model[7][1] = 9;
		model[7][4] = 7;
		model[7][8] = 4;

		model[8][1] = 8;
		model[8][2] = 2;
		model[8][4] = 4;
		model[8][8] = 6;
	}

	/** return true if the number was correctly set in the model*/
	public boolean setNumber( int col, int row, int num ){
		if (checkRow(row, num) && checkCol(col, num) && checkBox(row, col, num) && num>0 && num<=Sudoku.ROWS){
			model[row][col] = num;
			return true;
		}
		return false;
	}
	
	/** Checks if num is an acceptable value for the given row */
	protected boolean checkRow(int row, int num) {
		for (int col = 0; col < 9; col++)
			if (model[row][col] == num)
				return false;
		return true;
	}

	/** Checks if num is an acceptable value for the given column */
	protected boolean checkCol(int col, int num) {
		for (int row = 0; row < 9; row++)
			if (model[row][col] == num)
				return false;
		return true;
	}

	/** Checks if num is an acceptable value for the box around row and col */
	protected boolean checkBox(int row, int col, int num) {
		row = (row / 3) * 3;
		col = (col / 3) * 3;

		for (int r = 0; r < 3; r++)
			for (int c = 0; c < 3; c++)
				if (model[row + r][col + c] == num)
					return false;
		return true;
	}

	/** Recursive function to find a valid number for one single cell */
	public void solve(int row, int col) throws Exception {
		// Throw an exception to stop the process if the puzzle is solved
		if (row > 8){
			message = "Solution found";
			throw new Exception("Solution found");
		}
			

		// If the cell is not empty, continue with the next cell
		if (model[row][col] != 0)
			next(row, col);
		else {
			// Find a valid number for the empty cell
			for (int num = 1; num < 10; num++) {
				if (checkRow(row, num) && checkCol(col, num) && checkBox(row, col, num)) {
					model[row][col] = num;

					// Delegate work on the next cell to a recursive call
					next(row, col);
				}
			}
			// No valid number was found, clean up and return to caller
			model[row][col] = 0;
		}
	}

	/** Calls solve for the next cell */
	public void next(int row, int col) throws Exception {
		if (col < 8)
			solve(row, col + 1);
		else
			solve(row + 1, 0);
	}

	public int[][] getModel() {
		return model;
	}

	public void setModel(int[][] model) {
		this.model = model;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}