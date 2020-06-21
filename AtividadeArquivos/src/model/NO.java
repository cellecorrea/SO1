package model;

import model.entity.Pessoa;

public class NO {
	private NO next;
	private Pessoa data;
	
	public NO(Pessoa data) {
		this.data = data;
		this.next = null;
	}

	public NO getNext() {
		return next;
	}

	public void setNext(NO next) {
		this.next = next;
	}

	public Pessoa getData() {
		return data;
	}

	public void setData(Pessoa data) {
		this.data = data;
	}
}
