package com.umesh.model;

public class Cell {

	private char row;
	private int column;
	
	
	public Cell(char row, int column) {
		super();
		this.row = row;
		this.column = column;
	}
	
	public char getRow() {
		return row;
	}
	public void setRow(char row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	
	
	@Override
	public String toString() {
		return Character.toString(row)+column;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + row;
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cell other = (Cell) obj;
		if (column != other.column)
			return false;
		if (row != other.row)
			return false;
		return true;
	}
	
	
	
	
}
