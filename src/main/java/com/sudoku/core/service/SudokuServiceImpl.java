package com.sudoku.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudoku.core.model.MovementApproved;
import com.sudoku.core.model.Sudoku;

@Service
public class SudokuServiceImpl implements SudokuService {

	@Autowired
	private Sudoku sudoku;
	
	@Override
	public Sudoku createSudoku(){
		sudoku = new Sudoku();
		return sudoku;
	}
	
	@Override
	public MovementApproved setMovement(int col, int row, int num){
		boolean isApproved = sudoku.setNumber(col, row, num);
		return new MovementApproved(isApproved, row, col);
	}

	@Override
	public Sudoku getBoard() {
		return sudoku;
	}
	
	@Override
	public Sudoku solve(){
		try {
			sudoku.solve(0, 0);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return sudoku;
	}
	
}