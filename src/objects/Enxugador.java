package objects;

public class Enxugador implements Runnable{
	
	Escorredor escorredor = new Escorredor();
	private volatile boolean stop;
	
	public Enxugador(Escorredor escorredor) {
		super();
		this.escorredor = escorredor;
	}

	@Override
	public void run() {
		stop = false;
		while (!stop) {
			try {
				sync();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void sync() throws InterruptedException {
		escorredor.enxugarPratos();
	}
	
	public boolean verificarFila() {
		if (escorredor.getSize() == 0) {
			return true;
		}
		return false;
	}
	
	public void stop() {
	      stop = true;
	   }
	



}
