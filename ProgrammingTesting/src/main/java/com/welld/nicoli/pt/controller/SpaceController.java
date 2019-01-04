package com.welld.nicoli.pt.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.welld.nicoli.pt.dao.SpaceDAO;
import com.welld.nicoli.pt.model.Punto;

@RestController
public class SpaceController {

	@GetMapping("/space")
	@ResponseBody
	public List<Punto> getPuntiInSpace() {
		return SpaceDAO.getListOfPunti();
	}
	
	@DeleteMapping("/space")
	public void deleteSpace() {
		SpaceDAO.deleteSpace();
	}
}
