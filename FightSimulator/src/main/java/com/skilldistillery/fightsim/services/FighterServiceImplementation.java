package com.skilldistillery.fightsim.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.fightsim.entities.Fighter;
import com.skilldistillery.fightsim.entities.PowerBracket;
import com.skilldistillery.fightsim.entities.Universe;
import com.skilldistillery.fightsim.repositories.FighterRepository;

@Service
public class FighterServiceImplementation implements FighterService {

	@Autowired
	private FighterRepository fighterRepo;
	
	@Override
	public List<Fighter> getAllFighters() {
		return fighterRepo.findAll();
		
	}

	@Override
	public Fighter show(int fighterId) {
		Optional<Fighter> fighterOp = fighterRepo.findById(fighterId);
		if(fighterOp.isPresent()) {
			return fighterOp.get();
		}
		else {
			return null;			
		}
	}

	@Override
	public Fighter update(int fighterId, Fighter fighter) {
		fighter.setId(fighterId);		
		fighterRepo.save(fighter);
		return fighter;
	}

	@Override
	public boolean delete(int fighterId) {
		fighterRepo.deleteById(fighterId);
		return !fighterRepo.existsById(fighterId);
	}

	@Override
	public Fighter create(Fighter fighter) {
		fighterRepo.saveAndFlush(fighter);
		return fighter;
	}



}
