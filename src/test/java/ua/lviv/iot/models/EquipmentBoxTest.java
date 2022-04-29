package ua.lviv.iot.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EquipmentBoxTest {
	final EquipmentBox equipmentBox = new EquipmentBox(new Camera("Sony Corporation Japan",
			false, 70499, "Alpha a7",
			24),10,14,"Cameras");

	@Test
	void testToString() {
		String expected = "Equipment      [Type of equipment = Cameras, Number of items: 10, Weight KG: 14]";
		assertEquals(expected, equipmentBox.toString());
	}
}
