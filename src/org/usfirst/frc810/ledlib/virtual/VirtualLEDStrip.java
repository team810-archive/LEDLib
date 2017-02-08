package org.usfirst.frc810.ledlib.virtual;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.usfirst.frc810.ledlib.LEDStrip;

public class VirtualLEDStrip extends LEDStrip{
	private int density;
	private List<VirtualLEDPoint> leds = new ArrayList<VirtualLEDPoint>();
	public VirtualLEDStrip(){
		density = 1;
	}
	
	@Override
	protected void setLED(int LEDNum, Color c) {
		if(LEDNum >= 0 && leds.size() > LEDNum){
			leds.get(LEDNum).setLED(c);
		}
		else if(LEDNum >= 0){
			leds.add(new VirtualLEDPoint(c));
		}
	}
	

	public List<VirtualLEDPoint> getAllVirtualPoints(){
		return leds;
	}

	@Override
	public int getNumLEDs() {
		// TODO Auto-generated method stub
		return leds.size();
	}

	@Override
	public int getLEDDensity() {
		// TODO Auto-generated method stub
		return density;
	}
	
	
}
