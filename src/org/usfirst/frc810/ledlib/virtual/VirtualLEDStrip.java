package org.usfirst.frc810.ledlib.virtual;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

import org.usfirst.frc810.ledlib.HardwareLEDStrip;

public class VirtualLEDStrip extends HardwareLEDStrip {

	private LEDComponent ledComponent= null;
	public VirtualLEDStrip(int size, int density) {
		super(size, density);
	}

	@Override
	protected void setLED(int i, Color c) {
		getComponent().repaint();
	}
	
	public LEDComponent getComponent(){
		return (ledComponent == null) ? ledComponent = new LEDComponent() : ledComponent; // if the ledComponent isn't initialized, set it to a new instantiated ledComponenet and return it, if it is already created return the instantiated.
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
