package com.umesh.model;

import java.util.HashMap;
import java.util.Map;

public class BattleArea {
	
	private int width;
	private char height; 
	private Map<Cell, Integer> battleMap;
	
	
	public BattleArea(int width, char height) {
		super();
		this.width = width;
		this.height = height;
		this.battleMap = new HashMap<>();
	}
	
	public BattleArea(BattleArea battleArea) {
		this.width = battleArea.width;
		this.height = battleArea.height;
		this.battleMap = new HashMap<>();
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public char getHeight() {
		return height;
	}
	public void setHeight(char height) {
		this.height = height;
	}
	public Map<Cell, Integer> getBattleMap() {
		return battleMap;
	}
	public void setBattleMap(Map<Cell, Integer> battleMap) {
		this.battleMap = battleMap;
	}
	
	

}
