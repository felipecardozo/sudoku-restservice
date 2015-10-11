package com.sudoku.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudoku.core.model.MovementApproved;
import com.sudoku.core.model.Sudoku;
import com.sudoku.core.service.SudokuService;

@RestController
@RequestMapping("/sudoku")
public class SudokuController {
	
	@Autowired
	private SudokuService sudokuService;
	
	//http://localhost:8080/core/sudoku/create
	@RequestMapping("/create")
	public Sudoku createSudoku(){
		return sudokuService.createSudoku();
	}
	
	//http://localhost:8080/core/sudoku/put-number/row/1/col/1/number/3
	@RequestMapping("/put-number/row/{row}/col/{col}/number/{number}")
	public MovementApproved putNumber( @PathVariable("row") int row, @PathVariable("col") int col, @PathVariable("number") int number ){
		return sudokuService.setMovement(col, row, number);
	}
	
	//http://localhost:8080/core/sudoku/get-board
	@RequestMapping("/get-board")
	public Sudoku getBoard( ){
		return sudokuService.getBoard();
	}
	
	//http://localhost:8080/core/sudoku/solve
	@RequestMapping("/solve")
	public Sudoku solve(){
		return sudokuService.solve();
	}

}
