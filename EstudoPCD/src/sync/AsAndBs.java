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
				//Não é a minha vez, vou esperar.
				wait();
				//Acordaram-me, vou ver se ainda continuo dentro do ciclo ou sigo á frente.
				//Sigo em frente.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for (int i = 0; i < 3; i++) {
			System.out.print("B");
			try {
				//Apesar de eu dormir, os 3 Bs são impressos juntinhos.
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		BsTurn = false;
		AsTurn = true;
		//Acordo os Threads que estam em espera, só um entra entra no synchronized.
		notifyAll();
	
	}

	public static void main(String[] args) {
		//Lança um Thread para estar sempre a chamar print3As()
		AsAndBs ab = new AsAndBs();
		//O Thread main fica sempre a chamar o print3Bs()
		while (true) {
			ab.print3Bs();
		}
		//Os métodos synchronized fazem com que os threads que os tentam executar o façam de forma alternada
		//É dado tempo de processamento ao Thread main, entra no método synchronized e começa 
		//a fazer coisas, se entretanto o outro Thread tentar entrar tb não consegue, porque nesta classe
		//já existe um outro método synchronized que está a ser executado por outro thread, então bloqueia e espera.
		//Assim garantimos que os métodos não são executados ao mesmo tempo por 2 ou mais threads.
		//Assim consegues mecher em dados de forma segura, neste caso os boolean que dizem de quem é a vez =P
		//Se os boolean n existissem, era um bocado aleatório quem imprimia o quê... Ora vias o 3Bs 4 vezes seguidas, etc
		//Com os booleans controlas sempre de modo que o façam á vez. 
	}
}

