package org.usfirst.frc810.ledlib.virtual;

import java.awt.Color;
import java.io.File;

import org.usfirst.frc810.ledlib.LEDStrip;

public class LEDSerializer {
	public static File saveLEDStrip(VirtualLEDStrip strip){
		String serializedLED = "";
		for(int i = 0; i<strip.getNumLEDs(); i++){
			Color c = strip.getLEDColor(i);
			
		}
	}
	public static LEDStrip loadLEDStrip(File path){
		
	}
}
