package com.umesh.model;

import java.util.List;

public class Player {
	
	private List<Ship> ships;
	private List<Cell> missileLocation;
	private BattleArea battleArea;
	private int missileHitCount;
	private String playerName;
	
	public List<Ship> getShips() {
		return ships;
	}
	public void setShips(List<Ship> ships) {
		this.ships = ships;
	}
	public List<Cell> getMissileLocation() {
		return missileLocation;
	}
	public void setMissileLocation(List<Cell> missileLocation) {
		this.missileLocation = missileLocation;
	}
	public BattleArea getBattleArea() {
		return battleArea;
	}
	public void setBattleArea(BattleArea battleArea) {
		this.battleArea = battleArea;
	}
	public int getMissileHitCount() {
		return missileHitCount;
	}
	public void setMissileHitCount(int missileHitCount) {
		this.missileHitCount = missileHitCount;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	
	

}
