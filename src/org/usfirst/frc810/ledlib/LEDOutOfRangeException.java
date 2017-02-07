package org.usfirst.frc810.ledlib;

public class LEDOutOfRangeException extends RuntimeException {

	public LEDOutOfRangeException(int numLED, int maxLED){
		super("LED out of range, LED Called: "+ numLED+", Max LED: " + maxLED);
	}
	
}
