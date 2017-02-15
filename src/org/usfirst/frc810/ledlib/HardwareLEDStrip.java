package org.usfirst.frc810.ledlib;

import java.awt.Color;

public abstract class HardwareLEDStrip extends LEDStrip{
	private Color[] leds;
	private int density;
	
	protected HardwareLEDStrip(int size, int density){
		this.density = density;
		leds = new Color[size];
	}
	
	@Override
	public final Color getLEDColor(int i){
		return leds[i];
	}
	
	@Override
	public final void setLEDColor(int i, Color c){
		leds[i] = c;
	}
	
	@Override
	public int getNumLEDs(){
		return leds.length;
	}
	
	@Override
	public int getLEDDensity(){
		return  this.density;
	}
	
	protected abstract void setLED(int i, Color c);
}
