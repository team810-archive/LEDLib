package org.usfirst.frc810.ledlib.virtual;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class LEDVirtualizer extends JFrame {
	
	private LEDCanvas canvas;
	private List<VirtualLEDStrip> strips = new ArrayList<>();
	
	public LEDVirtualizer(){
		canvas = new LEDCanvas(this);
		setLayout(null);
		setBounds(0,0,800,400);
		setResizable(false);
		canvas.setBounds(0,0,getWidth(),getHeight());
		add(canvas);
		setTitle("LED Virtualizer - 0 LEDs");
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addKeyListener(canvas);
	}
	
	public List<VirtualLEDStrip> getLEDStrips(){
		updateTitle();
		return strips;
	}
	
	public void removeLEDStrip(VirtualLEDStrip strip){
		strips.remove(strip);
		updateTitle();
	}
	
	public void addLEDStrip(VirtualLEDStrip strip){
		strips.add(strip);
		updateTitle();
	}
	
	public void updateTitle(){
		setTitle("LED Virtualizer - " + strips.size() + " LEDs");
	}
	
	public LEDCanvas getCanvas() {
		return canvas;
	}
	public void selectStrip(int i){
		canvas.setSelectedStrip(i);
	}
}
