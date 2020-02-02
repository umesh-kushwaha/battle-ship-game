package com.umesh.model;

import java.util.List;

import com.umesh.constants.ShipType;

public class Ship {

	private ShipType shipType;
	
	private ShipSize shipSize;

	private List<Cell> shipCell;
	
	public Ship(ShipType shipType, ShipSize shipSize, List<Cell> shipCell) {
		super();
		this.shipType = shipType;
		this.shipSize = shipSize;
		this.shipCell = shipCell;
	}

	public ShipType getShipType() {
		return shipType;
	}

	public void setShipType(ShipType shipType) {
		this.shipType = shipType;
	}

	public ShipSize getShipSize() {
		return shipSize;
	}

	public void setShipSize(ShipSize shipSize) {
		this.shipSize = shipSize;
	}

	public List<Cell> getShipCell() {
		return shipCell;
	}

	public void setShipCell(List<Cell> shipCell) {
		this.shipCell = shipCell;
	}
	
	
}
