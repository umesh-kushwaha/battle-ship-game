package com.umesh.input;

public interface ValidateInput {
	
	boolean validateBattleWidth(int width);
	boolean validateBattleHieght(final char hieght);
	boolean validateNumberOfBattleShip(final int count,final int width,final char height);
	boolean validateShipSize(final int shipWidth, final int shipHeight, final int battleFieldWidth, final char battleFieldHeight);
	

}
