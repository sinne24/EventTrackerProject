package com.skilldistillery.fightsim.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FightTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Fight fight;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPAFightSim");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		fight = em.find(Fight.class, 1);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		fight = null;
	}

	@Test
	void test() {
		assertNotNull(fight);
		assertEquals("Goku vs Silver Surfer", fight.getWhoVsWho());
	}
	
	@Test
	void test_fight_ManyToOne_fighterOne() {
		assertNotNull(fight);
		assertEquals("Goku", fight.getFighterOne().getName());
	}
	
	@Test
	void test_fight_ManyToOne_fighterTwo() {
		assertNotNull(fight);
		assertEquals("Silver Surfer", fight.getFighterTwo().getName());
	}
	
	@Test
	void test_fight_ManyToOne_winner() {
		assertNotNull(fight);
		assertEquals("Goku", fight.getWinner().getName());
	}

}
