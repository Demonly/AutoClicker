package me.Demonly.auto;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class clicker {
	public static boolean clicking = true;
	public static int amountclicked = 0;
	public static int rate = 0;
	public static int rate1 = 0;

	public static void main(String[] args) throws InterruptedException {
		
		while (rate1 == 0) {
			try {
				System.out.println("How many clicks are you wanting to do?:");
				BufferedReader xyz = new BufferedReader(new InputStreamReader(System.in));
				try {
					rate1 = Integer.parseInt(xyz.readLine());
					if (rate1 == 0) {
						rate1 = 0;
						System.out.println("Must be at least 1 click.");
					}
				} catch (NumberFormatException ex) {
					System.out.println("Error - please try again.");
				}
			} catch (IOException e) {
			}
		}
		
		while (rate == 0) {
			try {
				System.out.println("Max speed of the autoclicker?: (in miliseconds):");
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				try {
					rate = Integer.parseInt(in.readLine());
					if (rate < 500) {
						rate = 0;
						System.out.println("Must be at least 500 miliseconds.");
					}
				} catch (NumberFormatException ex) {
					System.out.println("Error - please try again.");
				}
			} catch (IOException e) {
			}
		}
		
		try {
			System.out.println("*!*!*!*! PLEASE MOVE YOUR MOUSE INTO POSITION! !*!*!*!*");
			System.out.println("*!*!*!*! MOVE MOUSE TO END AUTOCLICK! !*!*!*!*");
			System.out.println("*!*!*!*! Sleeping for 10 seconds !*!*!*!*");
			
			Thread.sleep(10000);
			
			Point p = MouseInfo.getPointerInfo().getLocation();
			System.out.println("Current Mouse Location: "+p);
			
			Robot robot = new Robot();
			while (clicking == true) {
				try {
					Point z = MouseInfo.getPointerInfo().getLocation();
					System.out.println("Current Mouse Location: "+z);
					
					int randomNum = ThreadLocalRandom.current().nextInt(15000, rate + 1);
					System.out.println("Current Rate: " + randomNum);
					Thread.sleep(randomNum);
					robot.mousePress(InputEvent.BUTTON1_MASK);
					robot.mouseRelease(InputEvent.BUTTON1_MASK);
					amountclicked++;
					System.out.println("Amount Clicked So Far: " + amountclicked);
					
					if (Math.round(z.getX()+z.getY()) != Math.round(p.getX()+p.getY())) {
						System.out.println("MOUSE MOVED!: "+z);
						clicking = false;
					}
					
					if (amountclicked == rate1) {
						clicking = false;
					}
				} catch (InterruptedException ex) {
				}
			}
		} catch (AWTException e) {
		}
		
	}

}
