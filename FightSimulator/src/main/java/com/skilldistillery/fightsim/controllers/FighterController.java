package com.skilldistillery.fightsim.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.fightsim.entities.Fighter;
import com.skilldistillery.fightsim.services.FighterService;

@RestController
@RequestMapping("api")
public class FighterController {
	
	@Autowired
	private FighterService fighterSvc;
	
	@GetMapping("fighters")
	public List<Fighter> fighterIndex(){
		return fighterSvc.getAllFighters();
	}
}
