package controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ArquivosController implements IArquivosController {

	public ArquivosController() {
		super();
	}

	@Override
	public void converteArq(String path, String nome) throws IOException {
		File arq = new File(path, nome + ".txt");
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			String saida = linha + "\n";
			while (linha != null) {
				linha = buffer.readLine();
				if (linha != null) {
					String[] entradas = linha.split(" ");
					for (String entrada : entradas) {
						saida += entrada + ";";
					}
					saida += " ";
					saida += "\n";
				}
			}
			create(saida, path, nome);
			buffer.close();
			leitor.close();
			fluxo.close();

		} else {
			throw new IOException("Arquivo inválido");
		}

	}

	private void create(String saida, String path, String n) throws IOException {
		String nome = n + ".csv";
		File dir = new File(path);
		File arq = new File(path, nome);
		if (dir.exists() && dir.isDirectory()) {
			FileWriter fileWriter = new FileWriter(arq);
			PrintWriter print = new PrintWriter(fileWriter);
			print.write(saida);
			print.flush();
			print.close();
			fileWriter.close();
		} else {
			throw new IOException("Diretório Inválido");
		}
	}

	@Override
	public void openFile(String path, String nome) throws IOException {
		File arq = new File(path, nome + ".csv");
		if (arq.exists() && arq.isFile()) {
			Desktop desktop = Desktop.getDesktop();
			desktop.open(arq);
		} else {
			throw new IOException("Arquivo Inválido");
		}

	}

}
