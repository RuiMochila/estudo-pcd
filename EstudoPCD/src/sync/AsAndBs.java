package sync;

public class AsAndBs {	
	boolean AsTurn = true;
	boolean BsTurn = false;
	
	public AsAndBs() {
		(new PrinterAThread()).start();
	}
	
	class PrinterAThread extends Thread {
		
		public void run() {
			while (true) {
				print3As();
			}
		}
	}
	
	public synchronized void print3As() {		
		while (!AsTurn) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for (int i = 0; i < 3; i++)
		{
			System.out.print("A");
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			
		System.out.println();
		
		AsTurn = false;
		BsTurn = true;
		notifyAll();
	}
	
	public synchronized void print3Bs() {		
		while (!BsTurn) {
			try {
				//N�o � a minha vez, vou esperar.
				wait();
				//Acordaram-me, vou ver se ainda continuo dentro do ciclo ou sigo � frente.
				//Sigo em frente.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for (int i = 0; i < 3; i++) {
			System.out.print("B");
			try {
				//Apesar de eu dormir, os 3 Bs s�o impressos juntinhos.
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		BsTurn = false;
		AsTurn = true;
		//Acordo os Threads que estam em espera, s� um entra entra no synchronized.
		notifyAll();
	
	}

	public static void main(String[] args) {
		//Lan�a um Thread para estar sempre a chamar print3As()
		AsAndBs ab = new AsAndBs();
		//O Thread main fica sempre a chamar o print3Bs()
		while (true) {
			ab.print3Bs();
		}
		//Os m�todos synchronized fazem com que os threads que os tentam executar o fa�am de forma alternada
		//� dado tempo de processamento ao Thread main, entra no m�todo synchronized e come�a 
		//a fazer coisas, se entretanto o outro Thread tentar entrar tb n�o consegue, porque nesta classe
		//j� existe um outro m�todo synchronized que est� a ser executado por outro thread, ent�o bloqueia e espera.
		//Assim garantimos que os m�todos n�o s�o executados ao mesmo tempo por 2 ou mais threads.
		//Assim consegues mecher em dados de forma segura, neste caso os boolean que dizem de quem � a vez =P
		//Se os boolean n existissem, era um bocado aleat�rio quem imprimia o qu�... Ora vias o 3Bs 4 vezes seguidas, etc
		//Com os booleans controlas sempre de modo que o fa�am � vez. 
	}
}

