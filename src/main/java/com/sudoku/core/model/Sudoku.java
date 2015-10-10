package com.sudoku.core.model;

public class Sudoku {
	
	private int model[][];
	
	public Sudoku(){
		model = new int[9][9];
	}

	public int[][] getModel() {
		return model;
	}

	public void setModel(int[][] model) {
		this.model = model;
	}

}
