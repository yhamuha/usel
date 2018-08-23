package com.usel.app.repository;

import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.usel.app.model.Purchase;
import com.usel.app.repository.PurchaseRepository;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application.properties")
@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PurchaseRepositoryTest {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	PurchaseRepository purchaseRepository;

	@Test
	public void whenFindAllThenReturnNotEmptyList() {
		Purchase purchase = new Purchase();
		purchase.setFinalPoNumber("AP 2296 - 0450");

		entityManager.persist(purchase);

		assertFalse(purchaseRepository.findAll().isEmpty());
	}
}
