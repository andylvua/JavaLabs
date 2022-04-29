package ua.lviv.iot.models;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EquipmentTest {
	final Equipment equipment = new Equipment("Sony", true, 15000);

	@Test
	void getManufacturer() {
		String expected = "Sony";
		assertEquals(expected, equipment.getManufacturer());
	}

	@Test
	void isRented() {
		boolean expected = true;
		assertEquals(expected, equipment.isRented());
	}

	@Test
	void getPriceInUAH() {
		float expected = 15000;
		assertEquals(expected, equipment.getPriceInUAH());
	}

	@Test
	void equalsContract() {
		EqualsVerifier.simple().forClass(Equipment.class)
				.verify();
	}
}
