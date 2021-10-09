package com.skilldistillery.fightsim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.fightsim.entities.Fighter;
														//1.      2.         // 1.) Tested entity class 
public interface FighterRepository extends JpaRepository<Fighter, Integer> { // 2.) Datatype of its primary key
	
}
