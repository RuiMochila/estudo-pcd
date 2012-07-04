package threads;

public class PrimeiroThread extends Thread{

	public void run(){
		System.out.println("O meu primeiro Thread");
	}
	
	public static void main(String[] args) {
		System.out.println("Começa o Main");
		PrimeiroThread t = new PrimeiroThread();
		t.start();
		System.out.println("Termina");
	}

}
