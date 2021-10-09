package com.skilldistillery.fightsim.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UniverseTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Universe universe;
	
	
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
		universe = em.find(Universe.class, 1);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		universe = null;
	}

	@Test
	void test() {
		assertNotNull(universe);
		assertEquals("Marvel", universe.getName());
	}

}
