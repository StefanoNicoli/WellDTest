package com.welld.nicoli.pt.utils;

import java.util.List;

import com.welld.nicoli.pt.dao.SpaceDAO;
import com.welld.nicoli.pt.model.Punto;

public class MathClass {
	
	public static void IspezionaSpace(List<Punto> listOfPunti) {
		// preso come esempio la lista dei punti A - B - C
		// il primo ciclo for parte da indice 0 fino ad arrivare a len-1 della lista ( la retta deve passare da almeno due punti )
		// il secondo ciclo for parte da indice 1 fino a len della lista di punti presenti
		// verifico le rette passanti da AB AC BC
		int n = listOfPunti.size();
		for (int i = 0; i < n - 1; i++) {
			Punto puntoA = listOfPunti.get(i);
			for (int j = i + 1; j < n; j++) {
				Punto puntoB = listOfPunti.get(j);
				//i punti devono essere diversi
				if (!puntoA.equals(puntoB)) {
					String retta = MathClass.TrovaRettaPassante(puntoA, puntoB);
					SpaceDAO.addRetta(retta, puntoA, puntoB);
				}
			}
		}
	}
	
	private static String TrovaRettaPassante(Punto a, Punto b) {
		double m, q, x;
		//se le coordinate x dei due punti sono uguali evito la divisione per 0 e ho una retta verticale
		if (a.getX().longValue() == b.getX().longValue()) { // Retta verticale
			m = 1;
			q = 0;
			x = a.getX();
		} else {
			m = (b.getY() - a.getY()) / (b.getX() - a.getX()); // Delta_y / Delta_x
			q = -m * a.getX() + a.getY(); // y = mx + q --> q = -mx + y
			x = 0;
		}
		//questa è la chiave nella hashmap che identifica la retta prendendo esempio dalla formula
		//y = mq + x
		return "m="+Double.toString(m)+"q="+Double.toString(q)+"x="+Double.toString(x);
	}
}
