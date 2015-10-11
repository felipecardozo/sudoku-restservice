package com.sudoku.core.model;

public class MovementApproved {

	private boolean isApproved;
	private int row;
	private int col;

	public MovementApproved(boolean isApproved, int row, int col) {
		super();
		this.isApproved = isApproved;
		this.row = row;
		this.col = col;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

}

