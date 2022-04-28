package ua.lviv.iot.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LightingTest {
	final Lighting lighting = new Lighting("Nanlite USA",
			true,20,50,4500, "Forza 60");

	@Test
	void testToString() {
		String expected = "Lighting       [Manufacturer: Nanlite USA, IsRented: true, priceInUAH = 20.0, " +
				"Model: 'Forza 60', Watts = 50, Kelvins = 4500]";
		assertEquals(expected, lighting.toString());
	}
}
