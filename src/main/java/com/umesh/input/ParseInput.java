package com.umesh.input;

import java.util.ArrayList;
import java.util.List;

import com.umesh.constants.Constants;
import com.umesh.constants.ShipType;
import com.umesh.exception.InvalidInputException;
import com.umesh.model.BattleArea;
import com.umesh.model.Cell;
import com.umesh.model.Input;
import com.umesh.model.Player;
import com.umesh.model.Ship;
import com.umesh.model.ShipSize;

public class ParseInput {
	
	private ValidateInput validateInput;
	
	
	public ParseInput(ValidateInput validateInput) {
		super();
		this.validateInput = validateInput;
	}

	public Input parse( List<String> inputData) {
		if(inputData.isEmpty()) {
			throw new InvalidInputException();
		}
		Input input = new Input();
		
		input.setBattleArea(parseBattleArea(inputData.get(0)));
		input.setNumberOfBattleShip(parseNumberOfBattleShip(inputData.get(1),input));
		
		input.setPlayers(parsePlayerDetails( input.getBattleArea(), inputData, getPlayerStartInputIndex(), getPlayerEndInputIndex(input.getNumberOfBattleShip())));
		
		return input;
	}

	private int getPlayerStartInputIndex() {
		return Constants.PLAYER_INPUT_START_LINE;
	}
	
	private int getPlayerEndInputIndex(final int numberOfbattleShip) {
		return Constants.PLAYER_INPUT_START_LINE + numberOfbattleShip-1;
	}
	
	private BattleArea parseBattleArea(final String battleArea) {
		String[] splitArea = battleArea.split(Constants.INPUT_SEPERATOR);
		validateInput.validateBattleWidth(Integer.parseInt(splitArea[0]));
		validateInput.validateBattleHieght(splitArea[1].charAt(0));
		return new BattleArea(Integer.parseInt(splitArea[0]), splitArea[1].charAt(0));
	}
	
	private int parseNumberOfBattleShip(final String battleShip, Input input) {
		validateInput.validateNumberOfBattleShip(Integer.parseInt(battleShip), input.getBattleArea().getWidth(), input.getBattleArea().getHeight());
		return Integer.parseInt(battleShip);
	}
	
	
	private List<Player> parsePlayerDetails(BattleArea battleArea, List<String> inputData, final int startLoc, final int endLoc) {
		List<Player> players = new ArrayList<>();
		Player player1 = new Player();
		List<Ship> ships1 = new ArrayList<>();
		List<Cell> cells1 = new ArrayList<>();
		player1.setMissileLocation(cells1);
		player1.setShips(ships1);
		player1.setBattleArea(battleArea);
		player1.setPlayerName("Player-1");
 		Player player2 = new Player();
		List<Ship> ships2 = new ArrayList<>();
		List<Cell> cells2 = new ArrayList<>();
		player2.setMissileLocation(cells2);
		player2.setShips(ships2);
		player2.setBattleArea(new BattleArea(battleArea));
		player2.setPlayerName("Player-2");
		for(int i = startLoc; i<=endLoc; i++) {
		  String[] splitInput = inputData.get(i).split(Constants.INPUT_SEPERATOR);
		  ShipType shipType = getShipType(splitInput[0]);
		  validateInput.validateShipSize(Integer.parseInt(splitInput[1]), Integer.parseInt(splitInput[2]), battleArea.getWidth(), battleArea.getHeight());
		  ShipSize shipSize = new ShipSize(Integer.parseInt(splitInput[2]),Integer.parseInt(splitInput[1]));
		  Ship player1ship = new Ship(shipType, shipSize, getShipCell(splitInput[3], shipSize));
		  Ship player2Ship = new Ship(shipType, shipSize, getShipCell(splitInput[4], shipSize));
		  player1.getShips().add(player1ship);
		  player2.getShips().add(player2Ship);
	
		}
		
		String missileLocPlayer1 = inputData.get(endLoc+1);
		List<Cell> missileCells = new ArrayList<>();
		String[] splitMissileCell = missileLocPlayer1.split(Constants.INPUT_SEPERATOR);
		
		for(int i=0;i<splitMissileCell.length;i++) {
			missileCells.add(parseCell(splitMissileCell[i]));
		}
		player1.getMissileLocation().addAll(missileCells);
		
		String missileLocPlayer2 = inputData.get(endLoc+2); 
		List<Cell> missileCells2 = new ArrayList<>();
		String[] splitMissileCell2 = missileLocPlayer2.split(Constants.INPUT_SEPERATOR);
		
		for(int i=0;i<splitMissileCell2.length;i++) {
			missileCells2.add(parseCell(splitMissileCell2[i]));
		}
		player2.getMissileLocation().addAll(missileCells2);
		
		players.add(player1);
		players.add(player2);
		return players;
	}
	
	private ShipType getShipType(String shipType) {
		switch(shipType) {
		case "Q":
			return ShipType.QTYPE;
		case "P":
			return ShipType.PTYPE;
		default:
				throw new InvalidInputException("Invalid Ship type : " + shipType);
		}
	}
	
	private List<Cell> getShipCell(final String shipCoordinate, ShipSize shipSize){
		Cell currentCell = parseCell(shipCoordinate);
		int currentRow = currentCell.getRow();
		int currentColumn = currentCell.getColumn();
		List<Cell> cells = new ArrayList<>();
		for(int i=0; i< shipSize.getRow(); i++) {
			int col = currentColumn;
			for(int j =0; j < shipSize.getColumn(); j++ ) {
				Cell cell = new Cell((char)currentRow, col++);
				cells.add(cell);
				
			}
			currentRow++;
		}
		
		return cells;
	}
	
	private Cell parseCell(String cellStr) {
		char[] arr = cellStr.toCharArray();
		
		int column = Integer.parseInt(Character.toString(arr[1]));
		return new Cell(arr[0], column);
	}
	
}
