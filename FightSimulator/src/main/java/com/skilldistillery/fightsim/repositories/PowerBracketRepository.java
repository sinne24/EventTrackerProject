package com.skilldistillery.fightsim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.fightsim.entities.PowerBracket;
																	  //1.      2.         // 1.) Tested entity class 
public interface PowerBracketRepository extends JpaRepository<PowerBracket, Integer> {     // 2.) Datatype of its primary key

}
