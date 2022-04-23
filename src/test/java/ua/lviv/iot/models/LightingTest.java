package ua.lviv.iot.models;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

class LightingTest {
	Lighting lighting = new Lighting("Nanlite USA",
			true,20,50,4500, "Forza 60");

	@Test
	void testToString() {
		String expected = "Lighting       [Manufacturer: Nanlite USA, IsRented: true, priceInUAH = 20.0, " +
				"Model: 'Forza 60', Watts = 50, Kelvins = 4500]";
		Assertions.assertEquals(expected, lighting.toString());
	}
}