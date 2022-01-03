package objects;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

import objects.Prato.sujeira;

public class Escorredor {

	private ConcurrentLinkedQueue<Prato> fila = new ConcurrentLinkedQueue<Prato>();
	
	

	private int MAX = 3;

	public synchronized void lavarPratos() throws InterruptedException {
		while (MaxCapacity()) {
			System.out.println("Fila cheia!");
			wait();
		}
		PratosSujosFactory psf = new PratosSujosFactory();
		Prato prato = psf.gerarPrato();
		if (prato.getSujeira() == sujeira.BAIXO) {
			Thread.sleep(3);
		} else if (prato.getSujeira() == sujeira.MEDIO) {
			Thread.sleep(5);
		} else if (prato.getSujeira() == sujeira.ENGORDURADO){
			Thread.sleep(10);
		}
		fila.add(prato);
		notifyAll();
		
	}
	
	public synchronized void enxugarPratos() throws InterruptedException {
		while (MinCapacity()) {
			System.out.println("Fila vazia!");
			wait();
		}
        int min = 3;
		int max = 10;
        Random r = new Random();
        long tempo = r.nextInt(max - min) + min;
		Thread.sleep(tempo);
		fila.poll();
		notifyAll();
	}

	public void addPrato(Prato prato) {
		fila.add(prato);
	}

	public int getSize() {
		return fila.size();
	}

	public boolean MaxCapacity() {
		return fila.size() == MAX;
	}

	public boolean MinCapacity() {
		return fila.size() == 0;
	}

	public int getMAX() {
		return MAX;
	}
	

	

}
