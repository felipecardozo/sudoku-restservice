package com.sudoku.core;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sudoku.core.model.Sudoku;

public class SudokuTest {

	
	private Sudoku sudoku;
	
	@Before
	public void init(){
		sudoku = new Sudoku();
	}
	
	@Test
	public void sudokuHasABoardTest() {
		assertArrayEquals(createModel(), sudoku.getModel() );
	}
	
	private int[][] createModel() {
		int [][] model = new int[9][9];

		// Clear all cells
		for (int row = 0; row < 9; row++)
			for (int col = 0; col < 9; col++)
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
		
		return model;
	}


}
