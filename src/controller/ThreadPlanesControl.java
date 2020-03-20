package controller;

import java.util.concurrent.Semaphore;

public class ThreadPlanesControl extends Thread{

	private int id;
	private static int count = 1;
	private Semaphore semaPista;
	private Semaphore sema;
	
	public ThreadPlanesControl(int id, Semaphore sema, Semaphore semaPista) {
		
		this.sema = sema;
		this.semaPista = semaPista;
		this.id = id;
	}
	
	
	@Override
	public void run() {
		
		try {
			sema.acquire();
		
			validarPista();
			
			
			manobrar();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sema.release();
		}
		
		
		super.run();
	}


	private void validarPista() {
		try {
			semaPista.acquire();
			if(count%2 == 0) {
				System.out.println("O avião " + id + " acaba de começar o processo de decolagem na pista Norte");
			}else {
				System.out.println("O avião " + id + " acaba de começar o processo de decolagem na pista Sul");
			}
			count++;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			semaPista.release();
		}
		
		
	}


	private void manobrar() {
		
		try {
			sleep((int)((Math.random()*5001)+3000));
			System.out.println("O avião de " + id + " acabou de manobrar");
			taxiar();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private void taxiar() {
		
		try {
			sleep((int)((Math.random()*5001)+5000));
			System.out.println("O avião de " + id + " acabou de taxiar");
			decolar();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}


	private void decolar() {
		
		try {
			sleep((int)((Math.random()*3001)+1000));
			System.out.println("O avião de " + id + " acabou de decolar");
			afastamento();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}


	private void afastamento() {
		
		try {
			sleep((int)((Math.random()*5001)+3000));
			System.out.println("O avião de " + id + " acabou de se afastar");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}


	
}
