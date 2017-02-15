package org.usfirst.frc810.ledlib;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.IntFunction;
import java.util.function.Supplier;

public abstract class LEDStrip implements Iterable<Color> {

	/**
	 * Set the color of an individual LED
	 * @param LEDNum The index of the LED, starting at 0
	 * @param c The color to set the LED to
	 */
	public abstract void setLEDColor(int LEDNum, Color c);
	public abstract Color getLEDColor(int LEDNUM);
	
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
	
	@Override
	public Iterator<Color> iterator(){
		return new LEDIterator();
		
	}
	
	/**
	 * Set a range of LEDs to the same color
	 * @param LEDStart The LED to start on, inclusive
	 * @param LEDEnd The last LED to set, exclusive
	 * @param c The color to set the LEDs to
	 */
	public final void setLEDRange(int LEDStart, int LEDEnd, Color c){
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
	public final void setAllLEDs(IntFunction<Optional<Color>> mapper){
		for(int i = 0; i<getNumLEDs(); i++){
			final int index = i;
			mapper.apply(i).ifPresent(c->this.setLEDColor(index, c));
		}
	}
	

	
	/**
	 * Sets the LED Color using a supplier. The supplier should return an empty optional to leave the LED color as-is
	 * @param index The index of the LED to set the color for, starting at 0
	 * @param colorSupplier A supplier for the LED Color
	 */
	public final void setLEDColor(int index, Supplier<Optional<Color>> colorSupplier) {
		colorSupplier.get().ifPresent(c->this.setLEDColor(index,c));
	}
	
	private class LEDIterator implements Iterator<Color>{

		int curPos = 0;
		
		@Override
		public boolean hasNext() {
			return curPos < LEDStrip.this.getNumLEDs();
		}

		@Override
		public Color next() throws NoSuchElementException {
			if(!hasNext()) throw new NoSuchElementException();
			Color c = LEDStrip.this.getLEDColor(curPos);
			curPos++;
			return c;
		}
		
	}
}
