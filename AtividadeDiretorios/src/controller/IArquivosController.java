package controller;

import java.io.IOException;

public interface IArquivosController {
	
		public void converteArq (String path, String nome) throws IOException; 
		public void openFile (String path, String nome) throws IOException;
	}

