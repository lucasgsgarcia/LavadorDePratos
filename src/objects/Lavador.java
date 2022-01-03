package objects;

import objects.Prato.sujeira;

public class Lavador implements Runnable {

	Escorredor escorredor = new Escorredor();
	
	private volatile boolean stop;

	public Lavador(Escorredor escorredor) {
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

		escorredor.lavarPratos();

	}
	
	public void stop() {
	      stop = true;
	   }


}


