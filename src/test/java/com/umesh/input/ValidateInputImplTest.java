package com.umesh.input;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.umesh.exception.InvalidInputException;

@RunWith(MockitoJUnitRunner.class)
public class ValidateInputImplTest {
	
	@InjectMocks
	ValidateInputImpl validateInputImpl;

	@Test(expected = InvalidInputException.class)
	public void validateBattleWidthException() {
		validateInputImpl.validateBattleWidth(10);
	}
	
	@Test()
	public void validateBattleWidth() {
		assertTrue(validateInputImpl.validateBattleWidth(5));
		
	}
	
	@Test(expected = InvalidInputException.class)
	public void validateBattleHieghtException() {
		
		
		validateInputImpl.validateBattleHieght('9');
	}
	
	@Test()
	public void validateBattleHieght() {
		
		
		assertTrue(validateInputImpl.validateBattleHieght('E'));
	}
	
	@Test(expected = InvalidInputException.class)
	public void validateNumberOfBattleShipException() {
		validateInputImpl.validateNumberOfBattleShip(0,1,'A');
		
	}
	
	@Test()
	public void validateNumberOfBattleShip() {
		
		assertTrue(validateInputImpl.validateNumberOfBattleShip(1,1,'A'));
	}
	
	@Test(expected = InvalidInputException.class)
	public void validateShipSizeException() {
		validateInputImpl.validateShipSize(-1,0,1,'A');
	}
	
	@Test()
	public void validateShipSize() {
		
		assertTrue(validateInputImpl.validateShipSize(1,1,3,'B'));
	}
	
}
