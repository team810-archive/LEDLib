package org.usfirst.frc810.ledlib.virtual;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;

public class LEDCanvas extends JComponent implements KeyListener{
	private LEDVirtualizer virtualizer; 
	private int selectedStrip = 0;
	
	public LEDCanvas(LEDVirtualizer virtualizer){
		this.virtualizer = virtualizer;
	}
	
	@Override
	public void paint(Graphics g){
		g.drawString("Current Selected LED Strip: " + selectedStrip, 10, 10);
		VirtualLEDStrip strip = virtualizer.getLEDStrips().get(selectedStrip);
		int radius = 50;
		int x = radius * 2;
		for(VirtualLEDPoint point : strip.getAllVirtualPoints()){
			System.out.println(strip.getNumLEDs());
			g.setColor(point.getColor());
			g.fillOval(x, getHeight()  / 2, radius, radius);
			x+=radius;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
			selectedStrip++;
		else if(e.getKeyCode()==KeyEvent.VK_LEFT)
			selectedStrip--;
		
		if(selectedStrip >= virtualizer.getLEDStrips().size())
			selectedStrip = 0;
		else if(selectedStrip < 0)
			selectedStrip = virtualizer.getLEDStrips().size() - 1;
		
		
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public int getSelectedStrip() {
		return selectedStrip;
	}

}
