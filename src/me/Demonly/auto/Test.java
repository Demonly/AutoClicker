package me.Demonly.auto;

import java.awt.MouseInfo;
import java.awt.Point;

public class Test {
	
	private static boolean clicking;
	
	public static void main(String[] args) throws InterruptedException {
		
		Point p = MouseInfo.getPointerInfo().getLocation();
		
		while (clicking = true) {
			System.out.println("LOCATION: " + p.getLocation());
			Point x = MouseInfo.getPointerInfo().getLocation();
			Thread.sleep(500);
			
			if (Math.round(x.getX()) != Math.round(p.getX())) {
				System.out.println("MOUSE MOVED!: " + x.getLocation());
			}
		}
		
	}

}
