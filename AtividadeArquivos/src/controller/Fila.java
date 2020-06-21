package controller;

import model.NO;
import model.entity.Pessoa;

public class Fila {
	private NO start;

	public Fila() {
		this.start = null;
	}

	public void adicionar(Pessoa data) {
		NO n = new NO(data);
		if (this.start == null) {
			this.start = n;
		} else {
			NO aux = this.start;
			while (aux.getNext() != null) {
				aux = aux.getNext();
			}
			aux.setNext(n);
		}
	}

	public Pessoa remover() {
		if (this.start == null) {
			return null;
		} else {
			Pessoa data = this.start.getData();
			this.start = this.start.getNext();
			return data;
		}
	}

	public String mostrar() {
		if (this.start == null) {
			return null;
		}else {
			String data;
			StringBuffer buffer = new StringBuffer();
			NO aux = this.start;
			while (aux!=null) {
				buffer.append("Código: " + aux.getData().getCod() + "Nome:" + aux.getData().getNome()
						+ aux.getData().getEmail() + "\n");
				aux = aux.getNext();
			}
			data = buffer.toString();
			return data;
		}
	}
}