package com.welld.nicoli.pt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.welld.nicoli.pt.dao.SpaceDAO;
import com.welld.nicoli.pt.model.Punto;
import com.welld.nicoli.pt.utils.MathClass;

@RestController
public class PuntoController {

	@PostMapping("/point")
	@ResponseBody
	public Punto addPointInSpace(@RequestBody Punto punto) {
		List<Punto> listOfPuntiInSpace = SpaceDAO.getListOfPunti();
		//eseguo un controllo preliminare in caso il punto che si vuole inserire risulta essere già presente
		//se sì non esiste alcun bisogno di aggiornare lo spazio
		if (listOfPuntiInSpace.stream().filter(o -> o.getX().equals(punto.getX()) && o.getY().equals(punto.getY())).findFirst().isPresent())
			return null;
		SpaceDAO.addPunto(punto);
		updateLinesInSpace();
		return punto;
	}
	
	@GetMapping("/point/{n}")
	public Map<String, List<Punto>> getLines(@PathVariable int n) {
		return SpaceDAO.getLinesInSpace(n);
	}
	
	private void updateLinesInSpace() {
		List<Punto> listOfPunti = SpaceDAO.getListOfPunti();
		//calcolo le funzioni delle rette solo se nello spazio esistono almeno 2 punti
		if (listOfPunti.size() >= 2) {
			MathClass.IspezionaSpace(listOfPunti);
		}
	}
}
