package ua.lviv.iot.manager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.models.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FilmStudioTest {
	static final FilmStudio STUDIO = new FilmStudio();

	@BeforeAll
	static void addEquipment() {
		EquipmentBox equipmentBox = new EquipmentBox(new Camera("Sony Corporation Japan",
				false, 70499, "Alpha a7",
				24),1,14,"Cameras");
		EquipmentBox equipmentBox1 = new EquipmentBox(new Camera("Canon Inc. Japan",
				false, 200, "FZ-1000",
				28),1,8,"Cameras");
		EquipmentBox equipmentBox2 = new EquipmentBox(new Lighting("Nanlite USA",
				true,20,50,4500, "Forza 60"),
				1,30,"Lighting");
		EquipmentBox equipmentBox3 = new EquipmentBox(new Decorations("China Decorations LTD.",
				true, 45000, "Historical"),
				1,560,"Decorations");

		STUDIO.addNewEquipment(equipmentBox, equipmentBox1, equipmentBox2, equipmentBox3);
	}

	@Test
	void addNewEquipment() {
		List<Equipment> expected = new ArrayList<>(Arrays.asList(
				new Camera("Sony Corporation Japan",
						false, 70499, "Alpha a7", 24),
				new Camera("Canon Inc. Japan",
						false, 200, "FZ-1000", 28),
				new Lighting("Nanlite USA",
						true,20,50,4500, "Forza 60"),
				new Decorations("China Decorations LTD.",
						true, 45000, "Historical")
		));
		List<Equipment> actual = STUDIO.equipmentList;

		assertArrayEquals(expected.toArray(), actual.toArray());
	}

	@Test
	void printEquipment() {
		String expected = """
				Camera         [Manufacturer: Sony Corporation Japan, IsRented: false, priceInUAH = 70499.0, Model: 'Alpha a7', Megapixels = 24]
				Camera         [Manufacturer: Canon Inc. Japan, IsRented: false, priceInUAH = 200.0, Model: 'FZ-1000', Megapixels = 28]
				Lighting       [Manufacturer: Nanlite USA, IsRented: true, priceInUAH = 20.0, Model: 'Forza 60', Watts = 50, Kelvins = 4500]
				Decorations    [Manufacturer: China Decorations LTD., IsRented: true, priceInUAH = 45000.0, filmGenre: historical]
				""";

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent, true, StandardCharsets.UTF_8));
		STUDIO.printEquipment();

		assertEquals(expected, outContent.toString(StandardCharsets.UTF_8));
	}

	@Test
	void getEquipmentSortedByPriceDecreasingOrder() {
		Set<Equipment> expected = new LinkedHashSet<>(Arrays.asList(
				new Camera("Sony Corporation Japan",
						false, 70499, "Alpha a7", 24),
				new Decorations("China Decorations LTD.",
						true, 45000, "Historical"),
				new Camera("Canon Inc. Japan",
						false, 200, "FZ-1000", 28),
				new Lighting("Nanlite USA",
						true,20,50,4500, "Forza 60")
		));
		Set<Equipment> actual = STUDIO.getEquipmentSortedByPrice(true);

		assertArrayEquals(expected.toArray(), actual.toArray());
	}

	@Test
	void getEquipmentSortedByPriceIncreasingOrder() {
		Set<Equipment> expected = new LinkedHashSet<>(Arrays.asList(
				new Lighting("Nanlite USA",
						true,20,50,4500, "Forza 60"),
				new Camera("Canon Inc. Japan",
						false, 200, "FZ-1000", 28),
				new Decorations("China Decorations LTD.",
						true, 45000, "Historical"),
				new Camera("Sony Corporation Japan",
						false, 70499, "Alpha a7", 24)
		));
		Set<Equipment> actual = STUDIO.getEquipmentSortedByPrice(false);

		assertArrayEquals(expected.toArray(), actual.toArray());
	}

	@Test
	void getRentedEquipment() {
		Set<Equipment> expected = new LinkedHashSet<>(Arrays.asList(
				new Lighting("Nanlite USA",
						true,20,50,4500, "Forza 60"),
				new Decorations("China Decorations LTD.",
						true, 45000, "Historical")
		));
		Set<Equipment> actual = STUDIO.getRentedEquipment();

		assertArrayEquals(expected.toArray(), actual.toArray());
	}

	@Test
	void getDecorationsByGenre() {
		Set<Decorations> expected = new LinkedHashSet<>(List.of(
				new Decorations("China Decorations LTD.",
						true, 45000, "Historical")
		));
		Set<Decorations> actual = STUDIO.getDecorationsByGenre("historical");

		assertArrayEquals(expected.toArray(), actual.toArray());
	}

	@Test
	void getEquipmentSortedByManufacturerDecreasingOrder() {
		Set<Equipment> expected = new LinkedHashSet<>(Arrays.asList(
				new Camera("Sony Corporation Japan",
						false, 70499, "Alpha a7", 24),
				new Lighting("Nanlite USA",
						true,20,50,4500, "Forza 60"),
				new Decorations("China Decorations LTD.",
						true, 45000, "Historical"),
				new Camera("Canon Inc. Japan",
						false, 200, "FZ-1000", 28)
		));
		Set<Equipment> actual = STUDIO.getEquipmentSortedByManufacturer(true);

		assertArrayEquals(expected.toArray(), actual.toArray());
	}

	@Test
	void getEquipmentSortedByManufacturerIncreasingOrder() {
		Set<Equipment> expected = new LinkedHashSet<>(Arrays.asList(
				new Camera("Canon Inc. Japan",
						false, 200, "FZ-1000", 28),
				new Decorations("China Decorations LTD.",
						true, 45000, "Historical"),
				new Lighting("Nanlite USA",
						true,20,50,4500, "Forza 60"),
				new Camera("Sony Corporation Japan",
						false, 70499, "Alpha a7", 24)
		));
		Set<Equipment> actual = STUDIO.getEquipmentSortedByManufacturer(false);

		assertArrayEquals(expected.toArray(), actual.toArray());
	}
}
