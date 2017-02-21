package org.usfirst.frc810.ledlib.patterns;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Sequence {
	private List<ColorSequence> frames = new ArrayList<>();
	private int currentFrame = 0;
	public Sequence(List<ColorSequence> frames){
		this.frames = frames;
	}
	public void nextFrame(){
		currentFrame++;
	}
}
class ColorSequence{
	private int size;
	private Color[] colors;
	public ColorSequence(int size){
		this.size = size;
		colors = new Color[size];
	}
	public void setColor(int n, Color c){
		colors[n] = c;
	}
	public void setColors(Color[] colors){
		this.colors = colors;
	}
}