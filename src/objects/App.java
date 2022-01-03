package objects;

public class App {

	public static synchronized void work(Lavador lavador, Enxugador enxugador) throws InterruptedException {
		Thread t1 = new Thread(lavador);
		Thread t2 = new Thread(enxugador);	
		t1.start();
		t2.start();
	}
	
	public static synchronized void stop(Lavador lavador, Enxugador enxugador) throws InterruptedException {
		Thread.sleep(120000);
		lavador.stop();
		enxugador.stop();
	}
	
	
	
	public static void main(String[] args) throws InterruptedException {
		Escorredor escorredor = new Escorredor();
		Lavador lavador = new Lavador(escorredor);
		Enxugador enxugador = new Enxugador(escorredor);
		
		work(lavador, enxugador);
		stop(lavador, enxugador);
		
	}
	
}
