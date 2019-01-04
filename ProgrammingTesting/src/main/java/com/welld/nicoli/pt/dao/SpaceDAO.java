package com.welld.nicoli.pt.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.welld.nicoli.pt.model.Punto;

public class SpaceDAO {
	
	private static final List<Punto> listOfPunti = new ArrayList<>();
	private static final Map<String, List<Punto>> linesMap = new HashMap<String, List<Punto>>();
    
    public static List<Punto> getListOfPunti() {
        return listOfPunti;
    }
 
    public static void addPunto(Punto punto) {
    	listOfPunti.add(punto);
    }
 
    public static void addRetta(String retta, Punto puntoA, Punto puntoB) {
    	//se la retta non è già presente nella hashmap la aggiungo
    	if (!(linesMap.containsKey(retta)))
    		linesMap.putIfAbsent(retta, new ArrayList<>());
    	List<Punto> listOfPunti = linesMap.get(retta);
    	//per la retta aggiungo i punti
    	addPuntoInRetta(listOfPunti, puntoA);
    	addPuntoInRetta(listOfPunti, puntoB);
    }
 
    public static void addPuntoInRetta(List<Punto> listOfPunti, Punto punto) {
    	//se la lista dei punti è vuota aggiungo il punto
    	if (listOfPunti.isEmpty()) {
    		listOfPunti.add(punto);
    	} else if (!(listOfPunti.stream().filter(o -> o.getX().equals(punto.getX()) && o.getY().equals(punto.getY())).findFirst().isPresent())) {
        	//aggiungo il punto appartenente alla retta se e solo se non è già presente nella lista
    		listOfPunti.add(punto);
    	}
    }
 
    public static Map<String, List<Punto>> getLinesInSpace(int n) {
    	Map<String, List<Punto>> result = new HashMap<String, List<Punto>>();
    	//itero la hashmap delle rette
    	Iterator it = linesMap.entrySet().iterator();
    	while (it.hasNext()) {
    	    Map.Entry entry = (Map.Entry)it.next();
    	    String key = (String) entry.getKey();
    	    List<Punto> value = (List<Punto>) entry.getValue();
    	    //se il numero dei punti appartenenti alla retta è maggiore uguale a n, lo aggiungo a result
    	    if (value.size() >= n) {
    	    	result.put(key, value);
    	    }
    	}
        return result;
    }
 
    public static void deleteSpace() {
    	linesMap.clear();
    	listOfPunti.clear();
    }
 
}
