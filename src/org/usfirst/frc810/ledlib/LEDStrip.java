package org.usfirst.frc810.ledlib;

import java.awt.Color;
import java.util.function.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class LEDStrip {

	/**
	 * Set the color of an individual LED
	 * @param LEDNum The index of the LED, starting at 0
	 * @param c The color to set the LED to
	 */
	public abstract void setLED(int LEDNum, Color c);
	
	/**
	 * Get the total number of LEDs on the LED strip
	 * @return The total number of LEDs
	 */
	public abstract int getNumLEDs();
	
	/**
	 * Get the density of LEDs on the strip (per meter)
	 * @return The number of LEDs per meter
	 */
	public abstract int getLEDDensity();
	
	/**
	 * Set a range of LEDs to the same color
	 * @param LEDStart The LED to start on, inclusive
	 * @param LEDEnd The last LED to set, exclusive
	 * @param c The color to set the LEDs to
	 */
	public void setLEDRange(int LEDStart, int LEDEnd, Color c){
		if(LEDStart <= LEDEnd) throw new IllegalArgumentException("LEDEnd must be greater than LEDStart");
		if(LEDStart < 0) throw new LEDOutOfRangeException(LEDStart, getNumLEDs());
		if(LEDEnd>=getNumLEDs()) throw new LEDOutOfRangeException(LEDEnd, getNumLEDs());
		
		for(int i = LEDStart; i<LEDEnd; i++){
			setLED(i,c);
		}
	}
	
	/**
	 * Set the LEDs to a particular color 
	 * @param function A function to map a particular LED index to a color. Return an empty optional to leave the LED set as-is.
	 */
	public void setAllLEDs(IntFunction<Optional<Color>> mapper){
		
	}
	
	public LEDPoint getPoint(int index){
		return new StripLEDPoint(index);
	}
	
	public List<LEDPoint> getAllPoints(){
		List<LEDPoint> points = new ArrayList<>(getNumLEDs());
		
		for(int i = 0; i<getNumLEDs(); i++){
			points.add(getPoint(i));
		}
		
		return points;
	}
	
	private class StripLEDPoint implements LEDPoint{
		private int index;

		StripLEDPoint(int index){
			this.index = index;
		}

		@Override
		public void setColor(Color c) {
			LEDStrip.this.setLED(index, c);
		}
	}
}
