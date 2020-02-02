package com.umesh.constants;

public enum ShipType {
	QTYPE(2),PTYPE(1);
	
	int hitPerCell;
	
	ShipType(int hitPerCell){
		this.hitPerCell = hitPerCell;
	}

	public int getHitPerCell() {
		return hitPerCell;
	}

		
}
