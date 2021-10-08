package com.skilldistillery.fightsim.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.fightsim.entities.Fighter;
import com.skilldistillery.fightsim.repositories.FighterRepository;

@Service
public class FighterServiceImplementation implements FighterService {

	@Autowired
	private FighterRepository fighterRepo;
	
	@Override
	public List<Fighter> getAllFighters() {
		return fighterRepo.findAll();
		
	}

}
