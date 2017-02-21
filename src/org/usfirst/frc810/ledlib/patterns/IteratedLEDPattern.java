package org.usfirst.frc810.ledlib.patterns;

public abstract class IteratedLEDPattern implements LEDPattern {
	private int maxCycles;
	private int currentCycle;
	
	protected abstract void nextFrame();
	
	public IteratedLEDPattern(int cycles) {
		this.maxCycles = cycles;
		currentCycle = 0;
	}
	public final void tick(){
		nextFrame();
	}
	//default
	public boolean isDone()
	{
		return currentCycle >= maxCycles;
	}
	
	public final double getPercentage(){
		return (double) getCurrentCycle() / (double) getMaxCycles();
	}
	
	public int getCurrentCycle(){
		return this.currentCycle;
	}
	
	public int getMaxCycles(){
		return this.maxCycles;
	}
	
	public void setCurrentCycle(int currentCycle){
		this.currentCycle = currentCycle;
	}

}
