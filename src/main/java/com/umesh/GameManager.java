package com.umesh;


import java.util.List;

import com.umesh.constants.PlayerTurn;
import com.umesh.exception.BattleShipOverlappingException;
import com.umesh.exception.FileReadException;
import com.umesh.exception.InvalidInputException;
import com.umesh.file.FileReaderImpl;
import com.umesh.file.FilerReader;
import com.umesh.input.ParseInput;
import com.umesh.input.ValidateInputImpl;
import com.umesh.model.Input;
import com.umesh.model.Player;
import com.umesh.utils.Util;

public class GameManager {
	
	private GameManager() {
		
	}
	
	
	private Input input;
	private PlayerTurn playerTurn;
	private boolean isGameFinish;
	
	public static GameManager getInstance() {
		
	  return SingletonHelper.INSTANCE;
	}
	
	private static final class SingletonHelper{
		private static final GameManager INSTANCE = new GameManager();
	}

	public void launchGame() {
			
		try {
			input = parseInput();
			playerTurn = PlayerTurn.FIRST_PLAYER;
			initBattleField();
			playGame();
		}catch (InvalidInputException|BattleShipOverlappingException|FileReadException e) {
			System.out.println(e.getLocalizedMessage());
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
	private void initBattleField() {
		List<Player> players = input.getPlayers();
		for(Player player: players) {
			Util.initializeBattleMap(player.getBattleArea().getWidth(), player.getBattleArea().getHeight(), player.getBattleArea().getBattleMap());
			Util.updateBattleMapWithShipLoc(player.getBattleArea().getBattleMap(), player.getShips());
		}
	}
	private List<String> readFile(){
		FilerReader fileReader = new FileReaderImpl();
	
		return fileReader.readFile();
	}
	
	private Input parseInput() {
		
		ParseInput parseInput = new ParseInput(new ValidateInputImpl());
		return parseInput.parse(readFile());
	}
	
	private void playGame() {
		Player player1 = input.getPlayers().get(0);
		Player player2 = input.getPlayers().get(1);
		
		do {
			if(PlayerTurn.FIRST_PLAYER == playerTurn) {
				throwMissile(player1, player2);
			}else {
				throwMissile(player2,player1);
			}
		}while(!(((player1.getMissileHitCount() >= player1.getMissileLocation().size() )&& (player2.getMissileHitCount() >= player2.getMissileLocation().size())) || isGameFinish));
	
	}
	
	private void throwMissile(Player source, Player dest) {
		String msg = "";
		if(source.getMissileHitCount()>= source.getMissileLocation().size() ) {
			msg = source.getPlayerName() + " has no more missiles left to launch";
			changeTurn();
		}else if(Util.isMissileHitShip(source.getMissileLocation().get(source.getMissileHitCount()), dest.getBattleArea().getBattleMap())){
			
			msg = source.getPlayerName() + " fires a missile with target " + source.getMissileLocation().get(source.getMissileHitCount()).toString() + "  which got hit";
			
		}else {
			msg = source.getPlayerName() + " " + " fires a missile with target " + source.getMissileLocation().get(source.getMissileHitCount()).toString()+ " which got miss";
			changeTurn();
		}
		
		source.setMissileHitCount(source.getMissileHitCount()+1);
		
		System.out.println(msg);
		
		if(Util.isWin(dest.getBattleArea().getBattleMap())) {
			System.out.println(source.getPlayerName() + " won the battle");
			isGameFinish = true;
		}
	}
	
	private void changeTurn() {
		switch(playerTurn){
			case FIRST_PLAYER:
				playerTurn = PlayerTurn.SECOND_PLAYER;
				break;
			case SECOND_PLAYER:
				playerTurn = PlayerTurn.FIRST_PLAYER;
				break;
			
		}
	}
	
	
}
