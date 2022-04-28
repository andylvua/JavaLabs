package ua.lviv.iot.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CameraTest {
	final Camera camera = new Camera("Sony Corporation Japan", false,
			70499, "Alpha a7", 24);

	@Test
	void testToString() {
		String expected = "Camera         [Manufacturer: Sony Corporation Japan, IsRented: false, " +
				"priceInUAH = 70499.0, Model: 'Alpha a7', Megapixels = 24]";
		assertEquals(expected, camera.toString());
	}
}
