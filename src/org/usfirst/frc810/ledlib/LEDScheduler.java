package org.usfirst.frc810.ledlib;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.usfirst.frc810.ledlib.patterns.LEDPattern;

public class LEDScheduler {
	
	private List<LEDPattern> scheduledTasks = new ArrayList<>();
	private static final int DELAY = 20; //time in millis
	private LEDStrip strip;
	
	LEDScheduler(LEDStrip strip){
		Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(()->tick(),0, DELAY, TimeUnit.MILLISECONDS);
		this.strip = strip;
	}
	
	public LEDStrip getStrip(){
		return this.strip;
	}
	
	
	public void schedule(LEDPattern sch){
		if(!scheduledTasks.contains(sch))
			scheduledTasks.add(sch);
	}
	public void unschedule(LEDPattern sch){
		if(scheduledTasks.contains(sch))
			scheduledTasks.remove(sch);
	}
	public void tick(){
		scheduledTasks.stream().filter(LEDPattern::isDone).forEach(this::unschedule);
		scheduledTasks.forEach(LEDPattern::tick);
		
	}
}
