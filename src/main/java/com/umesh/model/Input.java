package com.umesh.model;

import java.util.List;

public class Input {
	
	BattleArea battleArea;
	int numberOfBattleShip;
	List<Player> players;
	
	public BattleArea getBattleArea() {
		return battleArea;
	}
	
	public void setBattleArea(BattleArea battleArea) {
		this.battleArea = battleArea;
	}
	
	public int getNumberOfBattleShip() {
		return numberOfBattleShip;
	}
	
	public void setNumberOfBattleShip(int numberOfBattleShip) {
		this.numberOfBattleShip = numberOfBattleShip;
	}
	
	public List<Player> getPlayers() {
		return players;
	}
	
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	@Override
	public String toString() {
		return "Input [battleArea=" + battleArea + ", numberOfBattleShip=" + numberOfBattleShip + ", players=" + players
				+ "]";
	}
	
	
	

}
