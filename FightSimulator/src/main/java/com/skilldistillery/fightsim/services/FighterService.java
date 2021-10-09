package com.skilldistillery.fightsim.services;

import java.util.List;

import com.skilldistillery.fightsim.entities.Fighter;
import com.skilldistillery.fightsim.entities.PowerBracket;
import com.skilldistillery.fightsim.entities.Universe;

public interface FighterService {
	
	List<Fighter> getAllFighters();
	Fighter show(int fighterId);
	Fighter update(int fighterId, Fighter fighter);
	boolean delete(int fighterId);
	Fighter create(Fighter fighter);
}

