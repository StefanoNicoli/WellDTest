package com.welld.nicoli.pt.model;

public class Punto {
	private Long x;
	private Long y;
	
	public Punto(Long x, Long y) {
		super();
		this.x = new Long(x);
		this.y = new Long(y);
	}

	public Long getX() {
		return x;
	}

	public void setX(Long x) {
		this.x = x;
	}

	public Long getY() {
		return y;
	}

	public void setY(Long y) {
		this.y = y;
	}
}
