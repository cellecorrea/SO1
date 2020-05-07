package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCruzamento;

public class Principal {

	public static void main(String[] args) {
		int permission = 1;
		Semaphore semaforo = new Semaphore(permission);
		for (int idCarro = 1; idCarro <= 4; idCarro++) {
			Thread carros = new ThreadCruzamento(idCarro, semaforo);
			carros.start();
		}
	}

}
