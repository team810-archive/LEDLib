package org.usfirst.frc810.ledlib.virtual;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.usfirst.frc810.ledlib.LEDStrip;

public class VirtualLEDStrip extends LEDStrip{
	private int density;
	private int size;
	private Color[] leds;
	public VirtualLEDStrip(int size, int density){
		leds = new Color[size];
		this.size = size;
		density = density;
	}
	
	@Override
	protected void setLED(int LEDNum, Color c) {
		
		leds[LEDNum]=c;
	
	}
	
	public Color getColor(int i){
		return leds[i];
	}

	@Override
	public int getNumLEDs() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public int getLEDDensity() {
		// TODO Auto-generated method stub
		return density;
	}
	
	
}
