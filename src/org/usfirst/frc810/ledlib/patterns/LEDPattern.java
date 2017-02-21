package org.usfirst.frc810.ledlib.patterns;

import org.usfirst.frc810.ledlib.LEDStrip;

public interface LEDPattern {
	void initialize(LEDStrip ledStrip);
	void tick();
	boolean isDone();
}
