package ua.lviv.iot.models;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

class EquipmentTest {
	Equipment equipment = new Equipment("Sony", true, 15000);

	@Test
	void getManufacturer() {
		String expected = "Sony";
		Assertions.assertEquals(expected, equipment.getManufacturer());
	}

	@Test
	void isRented() {
		boolean expected = true;
		Assertions.assertEquals(expected, equipment.isRented());
	}

	@Test
	void getPriceInUAH() {
		float expected = 15000;
		Assertions.assertEquals(expected, equipment.getPriceInUAH());
	}

	@Test
	void equalsContract() {
		EqualsVerifier.simple().forClass(Equipment.class)
				.verify();
	}
}