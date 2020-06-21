package interfaces;

import java.io.IOException;

import controller.Fila;

public interface IArquivosController {
	public void verifDir() throws IOException;
	public boolean verifRegistro() throws IOException;
	public void mostraCadastros() throws IOException;
	public Fila cadastrar(Fila fila);
	public Fila salvar(Fila fila) throws IOException;
}
