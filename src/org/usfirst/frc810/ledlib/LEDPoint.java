package org.usfirst.frc810.ledlib;

import java.awt.Color;
import java.util.Optional;
import java.util.function.Supplier;

public abstract class LEDPoint {
	
	protected abstract void setLED(Color c);
	
	/**
	 * Set the color of the LED
	 * @param c The color to set the LED to
	 */
	public final void setLEDColor(Color c) {
		setLED(c);
	};
	
	/**
	 * Sets the LED Color using a supplier. The supplier should return an empty optional to leave the LED color as-is
	 * @param colorSupplier A supplier for the LED Color
	 */
	public final void setLEDColor(Supplier<Optional<Color>> colorSupplier) {
		colorSupplier.get().ifPresent(this::setLEDColor);
	}
	
}
