package com.sudoku.core.service;

import com.sudoku.core.model.MovementApproved;
import com.sudoku.core.model.Sudoku;

public interface SudokuService {
	
	public Sudoku createSudoku();
	
	public MovementApproved setMovement(int col, int row, int num);
	
	public Sudoku getBoard();
	
	public Sudoku solve();

}
