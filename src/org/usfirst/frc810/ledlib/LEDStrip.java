package org.usfirst.frc810.ledlib;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.IntFunction;
import java.util.function.Supplier;

public abstract class LEDStrip {

	/**
	 * Set the color of an individual LED
	 * @param LEDNum The index of the LED, starting at 0
	 * @param c The color to set the LED to
	 */
	public final void setLEDColor(int LEDNum, Color c) {
		setLED(LEDNum, c);
	}
	

	protected abstract void setLED(int LEDNum, Color c);
	
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
			setLEDColor(i,c);
		}
	}
	
	/**
	 * Set the LEDs to a particular color 
	 * @param mapper A function to map a particular LED index to a color. Return an empty optional to leave the LED set as-is.
	 */
	public void setAllLEDs(IntFunction<Optional<Color>> mapper){
		
	}
	
	/**
	 * Returns a LEDPoint representing a specific LED on the strip
	 * @param index The LED's position on the LED strip
	 * @return A LEDPoint representing that specific LED
	 */
	public LEDPoint getPoint(int index){
		return new StripLEDPoint(index);
	}
	
	/**
	 * Returns a List of all the points on the LEDStrip
	 * @return All the points on the strip
	 */
	public List<LEDPoint> getAllPoints(){
		List<LEDPoint> points = new ArrayList<>(getNumLEDs());
		
		for(int i = 0; i<getNumLEDs(); i++){
			points.add(getPoint(i));
		}
		
		return points;
	}
	
	/**
	 * Sets the LED Color using a supplier. The supplier should return an empty optional to leave the LED color as-is
	 * @param index The index of the LED to set the color for, starting at 0
	 * @param colorSupplier A supplier for the LED Color
	 */
	public void setLEDColor(int index, Supplier<Optional<Color>> colorSupplier) {
		this.getPoint(index).setLEDColor(colorSupplier);
	}
	
	private class StripLEDPoint extends LEDPoint{
		private int index;

		StripLEDPoint(int index){
			this.index = index;
		}

		@Override
		public void setLED(Color c) {
			LEDStrip.this.setLEDColor(index, c);
		}
	}
}
