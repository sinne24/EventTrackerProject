package com.skilldistillery.fightsim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.fightsim.entities.Fight;
														//1.      2.       // 1.) Tested entity class 
public interface FightRepository extends JpaRepository<Fight, Integer> { // 2.) Datatype of its primary key
	
}
