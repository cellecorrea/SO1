package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadCruzamento extends Thread {
	private int idCarro;
	private Semaphore semaforo;
	private static int ordemSaida;

	public ThreadCruzamento(int idCarro, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
	}
	public void run() {
		Ordem();
		try {
			semaforo.acquire();
			Saindo();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			Saida();
			semaforo.release();
		}
	}
	private void Ordem() {
		Random random = new Random();
		int aleatorio = random.nextInt(100);
		try {
			sleep(aleatorio);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	private void Saindo() {
		Random random = new Random();
		int vm = random.nextInt(100);
		try {
			sleep(vm);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private void Saida() {
		ordemSaida++;
		System.out.println("O carro " +this.idCarro+ " foi o "+ordemSaida+ "o. a sair do cruzamento.");
	}
}

