package objects;

import java.util.Random;

public class Prato {
	
	private static int serial = 0;
	private sujeira sujo;
	
	
	
	public Prato() {
		super();
		serial++;
		sujo = setSujeira();
	}

	public enum sujeira {
		BAIXO(30), MEDIO(60), ENGORDURADO(10);
		private int nivelSujeira;
		sujeira(int i) {
			this.nivelSujeira = i;
		}

	}
	
	
	
	public sujeira setSujeira() {
		Random r = new Random();
	    int rand = r.nextInt(100);
	    
	    if (rand < 60) {
	    	return Prato.sujeira.MEDIO;
	    } else if (rand < 90 || rand > 60) {
	    	return Prato.sujeira.BAIXO;
	    } else {
	    	return Prato.sujeira.ENGORDURADO;
	    }
	}
	
	
	public sujeira getSujeira () {
		return sujo;
	}
	
	public int getSerial() {
		return serial;
	}

	
}
