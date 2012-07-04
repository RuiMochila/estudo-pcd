package threads;

public class PrimeiroThread2 implements Runnable{

	@Override
	public void run() {
		System.out.println("O meu primeiro Thread");
		
	}
	
	public static void main(String[] args) {
		System.out.println("Começa o Main");
		
//		PrimeiroThread2 pt = new PrimeiroThread2();
//		Thread t = new Thread(pt);
//		t.start();
		
		(new Thread(new PrimeiroThread2())).start();
		
	}

}
