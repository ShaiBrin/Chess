package model;

public class Processor {

	public Processor() {};
	public void player1Move() throws InterruptedException{
		synchronized (this) {
			//1. Make a move.
			
			//2. Wait for the opponent to move.
			wait();
		}
	}
	
	public void player2Move() throws InterruptedException{
		synchronized(this) {
			//1. Make a move.
			//2. Notify
			notify();
		}
	}
	
	
}
