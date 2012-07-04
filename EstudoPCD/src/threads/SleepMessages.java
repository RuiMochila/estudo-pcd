package threads;

import java.util.Random;

public class SleepMessages extends Thread {

	public void run() {
		String importantInfo[] = {
            	 "Mares eat oats",
            	 "Does eat oats",
            	 "Little lambs eat ivy",
            	 "A kid will eat ivy too"};

		for (int i = 0; i < importantInfo.length; i++) {
	         	   try {
            		//Pause for 4 seconds
	            	System.out.println(currentThread() + 
				": vai dormir durante 4000 milisegundos");
			sleep(4000);
            		//Print a message
            		System.out.println("\t" + importantInfo[i]);
           	   } catch (InterruptedException e) {
	          	System.out.println(currentThread() + 
					": Ops! I was interrupted!");
           	   }
        		}
	}

	public static void main(String args[]) throws InterruptedException {
		Thread t = new SleepMessages();
		t.start();
		int pausa = (new Random()).nextInt(16000);
		System.out.println(currentThread() + ": vai dormir durante " + pausa
				/ 100 + " segundos");
		sleep(pausa);
		t.interrupt();
	}
} // fim da classe SleepMessages
