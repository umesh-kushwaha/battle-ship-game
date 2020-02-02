package com.umesh.utils;

import java.security.KeyStore.Entry;
import java.util.List;
import java.util.Map;

import com.umesh.exception.BattleShipOverlappingException;
import com.umesh.model.Cell;
import com.umesh.model.Ship;

public class Util {
	
	
	private Util() {
		super();
		
	}

	public static void initializeBattleMap(int width, char height, Map<Cell, Integer> battleMap) {
		
		for(int i = 1; i<= width; i++) {
			for(int k = 65; k<= height;k++) {
				Cell cell = new Cell((char)k,i);
				battleMap.put(cell, 0);
			}
		}
	}
	
	
	public static void updateBattleMapWithShipLoc(Map<Cell, Integer> battleMap, List<Ship> ships) {
		
		for(int i =0; i< ships.size(); i ++) {
			Ship ship = ships.get(i);
			List<Cell> cells = ship.getShipCell();
			for(int j = 0; j< cells.size(); j++) {
				Cell cell = cells.get(j);
				int value = battleMap.get(cell);
				if(value > 0) {
					throw new BattleShipOverlappingException();
				}
				
				battleMap.put(cell, ship.getShipType().getHitPerCell());
			}
			
		}
		
		
	}

	
	public static boolean isMissileHitShip(Cell missileLoc, Map<Cell,Integer> battleMap) {
		int value = battleMap.get(missileLoc);
		if(value > 0) {
			battleMap.put(missileLoc,value-1);
			return true;
		}else {
			return false;
		}
	}

	public static boolean isWin(Map<Cell,Integer> battleMap) {
		for (Map.Entry<Cell,Integer> entry : battleMap.entrySet())  {
			if(entry.getValue() > 0) {
				return false;
			}
		}
        return true;
	}
	
	public static void printBattleMap(Map<Cell,Integer> battleMap) {
		for (Map.Entry<Cell,Integer> entry : battleMap.entrySet())  {
			System.out.println("key : " + entry.getKey().toString() + ", value: " + entry.getValue());
		}
	}
}
