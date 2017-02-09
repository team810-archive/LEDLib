package org.usfirst.frc810.ledlib;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.usfirst.frc810.ledlib.virtual.VirtualLEDStrip;

public class StripTest {

	VirtualLEDStrip strip;
	
	@Before
	public void setUp() throws Exception {
		strip = new VirtualLEDStrip(10,1);
	}


	@Test
	public void testSetRetrieve() {
		strip.setLEDColor(0, Color.blue);
		assertEquals(strip.getColor(0), Color.blue);
	}
	
	

}
