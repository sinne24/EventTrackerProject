package com.skilldistillery.fightsim.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.fightsim.entities.Fighter;
import com.skilldistillery.fightsim.entities.PowerBracket;
import com.skilldistillery.fightsim.entities.Universe;
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
	
	@GetMapping("fighters/{fighterId}")
	public Fighter findFighter(@PathVariable Integer fighterId) {	
		return fighterSvc.show(fighterId);
		
	}
	
	@PostMapping("fighters")
	public Fighter createFighter(@RequestBody Fighter fighter, HttpServletRequest request, HttpServletResponse response){
			fighter = fighterSvc.create(fighter);

		return fighter;
	}
	
	@PutMapping("fighters/{fighterId}")
	public Fighter updateFighter(@RequestBody Fighter fighter, @PathVariable Integer fighterId){
		return fighterSvc.update(fighterId, fighter);
	}
	
	@DeleteMapping("fighters/{fighterId}")
	public Boolean deleteFighter(@PathVariable Integer fighterId){
		return fighterSvc.delete(fighterId);
	}
	
	
}
