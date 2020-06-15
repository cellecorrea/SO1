package view;

import java.io.File;
import java.io.IOException;

import controller.ArquivosController;
import controller.IArquivosController;

public class Principal {

	public static void main(String[] args) {
		String path = new File("").getAbsolutePath() + "\\Arquivo";
		String nome = "relatorio";
		IArquivosController arq = new ArquivosController();
		try {
			arq.converteArq(path, nome);
			arq.openFile(path, nome);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}