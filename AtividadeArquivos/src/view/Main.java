package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.ArquivoController;
import controller.Fila;
import interfaces.IArquivosController;

public class Main {

	public static void main(String[] args) {
		int opc = 0;
        Fila fila = new Fila();
        IArquivosController arq = new ArquivoController();
        while(opc!=9) {
            opc = Integer.parseInt(JOptionPane.showInputDialog("Menu:\n"
                    + "1-Cadastrar Pessoa\n"
                    + "2-Mostrar cadastros não salvos\n"
                    + "3-Salvar\n"
                    + "4-Mostrar cadastros\n"
                    + "9-Sair\n"
                    + "Digite sua opção:"));
            switch(opc) {
                case 1: fila = arq.cadastrar(fila);
                    break;
                case 2:    JOptionPane.showMessageDialog(null, fila.mostrar());
                    break;
                case 3:    try {
                    fila = arq.salvar(fila);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                    break;
                case 4: try {
                    arq.mostraCadastros();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                    break;
                case 9: System.out.println("Saindo...");
                    break;
                default: System.err.println("Opção inválida!");
            }
        }

	}

}
