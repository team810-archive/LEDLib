package org.usfirst.frc810.ledlib.virtual;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

import org.usfirst.frc810.ledlib.HardwareLEDStrip;

public class VirtualLEDStrip extends HardwareLEDStrip {

	public VirtualLEDStrip(int size, int density) {
		super(size, density);
	}

	@Override
	protected void setLED(int i, Color c) {
		// TODO implement to dans liking
		
	}

	
	
	
	private class LEDComponent extends JComponent {
		
		private VirtualLEDStrip vLEDStrip = VirtualLEDStrip.this;
		
		public LEDComponent() {
		}


		@Override
		public void paint(Graphics g) {
			double width = getWidth(); // 200 is default size	
			int size = vLEDStrip.getNumLEDs();
			double ledSize = Math.min(width / size,getHeight());
			int x = 0;
			for(Color c : vLEDStrip){
				g.setColor(c);
				g.fillOval(x, 0, size, size);
				x+=size;
			}
		}
	}
}
