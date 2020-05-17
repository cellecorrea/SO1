package view;

import java.util.concurrent.Semaphore;

import controller.ThreadFormula1;

public class Main {

public static void main(String[] args) {
	int permissoes = 5;
	int escuderia = 0;
	
		Semaphore semaforopista = new Semaphore(permissoes);
		Semaphore semaforoescuderia [] = new Semaphore [7];
		for(int i=0; i<7; i++) {
			semaforoescuderia[i] = new Semaphore(1);
		}
		
		for (int idCarro = 0; idCarro < 14 ; idCarro++) {
			if (escuderia<7) {
				Thread tFormula1 = new ThreadFormula1 (idCarro, escuderia, semaforopista, semaforoescuderia);
				escuderia++;
				tFormula1.start();
			}else {
			escuderia = 0;
			Thread tFormula1 = new ThreadFormula1 (idCarro, escuderia, semaforopista, semaforoescuderia);
			escuderia++;
			tFormula1.start();
			}
		}
	}

}
