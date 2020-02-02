package com.umesh.input;

import com.umesh.exception.InvalidInputException;

public class ValidateInputImpl implements ValidateInput{

	public boolean validateBattleWidth(final int width) {
		if(!(width>=1 && width<=9)) throw new InvalidInputException("Battle area width must be between 1 to 9");
		return true;
	}

	public boolean validateBattleHieght(final char hieght) {
		if(!(hieght>=65 && hieght <= 90)) throw new InvalidInputException("Battle area height must be between A to Z");

		return true;
	}

	public boolean validateNumberOfBattleShip(final int count,final int width,final char height) {
		if(!(count >= 1 && count<= (width *(height-65+1)))) throw new InvalidInputException("Number of Battleship  must be between 1 to width*height");

		return true;
	}

	public boolean validateShipSize(final int shipWidth, final int shipHeight, final int battleFieldWidth, final char battleFieldHeight) {
		if(!(shipWidth >=1 && shipWidth <= battleFieldWidth) || !(shipHeight >= 1 && shipHeight<= (battleFieldHeight-65+1))) {
			throw new InvalidInputException("Ship size is invalid");
		}
		return true;
	}

	

}
