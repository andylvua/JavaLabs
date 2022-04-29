package ua.lviv.iot.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DecorationsTest {
	final Decorations decoration = new Decorations("China Decorations LTD.", true,
			45000, "Historical");

	@Test
	void getFilmGenre() {
		String expected = "historical";
		assertEquals(expected, decoration.getFilmGenre());
	}

	@Test
	void testToString() {
		String expected = "Decorations    [Manufacturer: China Decorations LTD., IsRented: true, " +
				"priceInUAH = 45000.0, filmGenre: historical]";
		assertEquals(expected, decoration.toString());
	}
}
