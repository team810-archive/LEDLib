package org.usfirst.frc810.ledlib.virtual;

import java.awt.Color;

import org.usfirst.frc810.ledlib.LEDPoint;

public class VirtualLEDPoint extends LEDPoint {
	private Color c;
	public VirtualLEDPoint(){
		c = Color.RED;
	}
	public VirtualLEDPoint(Color c){
		this.c = c;
	}

	@Override
	protected void setLED(Color c) {
		// TODO Auto-generated method stub
		this.c = c;
	}
	public Color getColor(){
		return c;
	}
}
