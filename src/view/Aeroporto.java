package view;

import java.util.concurrent.Semaphore;

import controller.ThreadPlanesControl;

public class Aeroporto {
	
	public static void main(String[] args) {
		
		Semaphore sema = new Semaphore(2);
		Semaphore semaPista = new Semaphore(1);
		
		for (int i = 1; i <= 12; i++) {
			
			Thread plane = new ThreadPlanesControl(i, sema, semaPista);
			plane.start();
 			
		}
		
	}

}
