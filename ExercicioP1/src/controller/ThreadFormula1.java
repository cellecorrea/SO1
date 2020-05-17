package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadFormula1 extends Thread {
	private int idCarro;
	private int escuderia;
	private int tempomaximo;
	private Semaphore semaforopista;
	private Semaphore[] semaforoescuderia;
	private static int[] colocacao = new int[14];
	private static int terminados;

	public ThreadFormula1(int idCarro, int escuderia, Semaphore semaforopista, Semaphore semaforoescuderia[]) {
		this.idCarro = idCarro;
		this.escuderia = escuderia;
		this.tempomaximo = 0;
		this.semaforopista = semaforopista;
		this.semaforoescuderia = semaforoescuderia;

	}

	@Override
	public void run() {
		try {
			this.semaforoescuderia[this.escuderia].acquire();
			Largada();
			this.semaforopista.acquire();
			Corrida();
			Chegada();
			VerificaCampeao();
		} catch (InterruptedException e) {

			e.printStackTrace();
		} finally {
			this.semaforopista.release();
			this.semaforoescuderia[this.escuderia].release();
		}
	}

	private void Largada() {
		System.out.print("O carro " + idCarro + " pertence a escuderia " + this.escuderia+ ".\n");
	}

	private void Corrida() {
		int volta;
		System.out.print("O carro " + idCarro + " já pode largar.\n");
		int tempo = 0;
		Random random = new Random();
		volta = random.nextInt(1000);
		tempo += volta;
		volta = random.nextInt(1000);
		tempo += volta;
		volta = random.nextInt(1000);
		tempo += volta;
		try {
			sleep(tempo);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		this.tempomaximo = tempo;
	}

	private void Chegada() {
		System.out.println("O carro " + idCarro + " concluiu a corrida.\n");
		colocacao[this.idCarro] = this.tempomaximo;
		terminados++;
	}

	private void VerificaCampeao() {
		String mostra = "";
		int aux1;
		int aux2;
		int podio[] = new int[14];
		if (terminados == 14) {
			for (int i = 0; i < 14; i++) {
				podio[i] = i;
			}
			for (int i = 0; i < 14; i++) {
				for (int j = i + 1; j < 14; j++) {
					if (colocacao[i] > colocacao[j]) {
						aux1 = colocacao[i];
						colocacao[i] = colocacao[j];
						colocacao[j] = aux1;
						aux2 = podio[i];
						podio[i] = podio[j];
						podio[j] = aux2;
					}
				}
			}
			for (int i = 0; i < 14; i++) {

				mostra += (i + 1) + " Lugar " + podio[i] + " com o tempo de " + colocacao[i]+ " ms. \n";
			}
			System.out.println(mostra);
		}
	}
}
