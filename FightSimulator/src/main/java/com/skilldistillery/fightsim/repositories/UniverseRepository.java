package com.skilldistillery.fightsim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.fightsim.entities.Universe;
															  //1.      2.         // 1.) Tested entity class 
public interface UniverseRepository extends JpaRepository<Universe, Integer> {     // 2.) Datatype of its primary key

}
