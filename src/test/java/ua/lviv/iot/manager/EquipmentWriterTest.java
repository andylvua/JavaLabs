package ua.lviv.iot.manager;

import org.junit.jupiter.api.Test;
import ua.lviv.iot.models.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EquipmentWriterTest {
	@Test
	void WriteToCSVFileGeneralCase() throws IOException {
		FilmStudio studio = new FilmStudio();

		EquipmentBox equipmentBox = new EquipmentBox(new Camera("Sony Corporation Japan",
				false, 70499, "Alpha a7",
				24),1,14,"Cameras");
		EquipmentBox equipmentBox1 = new EquipmentBox(new Camera("Canon Inc. Japan",
				false, 200, "FZ-1000",
				28),1,8,"Cameras");
		EquipmentBox equipmentBox2 = new EquipmentBox(new Lighting("Nanlite USA",
				true,20,50,4500, "Forza 60"),
				3,30,"Lighting");
		EquipmentBox equipmentBox3 = new EquipmentBox(new Decorations("China Decorations LTD.",
				true, 45000, "Historical"),
				2,560,"Decorations");

		studio.addNewEquipment(equipmentBox, equipmentBox1, equipmentBox2, equipmentBox3);
		EquipmentWriter.writeToCSVFile(studio.equipmentList);

		File file = new File("src/test/resources/result.csv");
		Scanner scanner = new Scanner(file, StandardCharsets.UTF_8);
		StringBuilder result = new StringBuilder();
		while (scanner.hasNextLine()){
			result.append(scanner.nextLine());
		}

		String expected = "Type,Manufacturer,IsRented,PriceInUAH,Model,MegapixelsCamera,Sony Corporation Japan," +
				"false,70499.0,Alpha a7,24Camera,Canon Inc. Japan,false,200.0,FZ-1000,28Type,Manufacturer,IsRented," +
				"PriceInUAH,Watts,Kelvins,ModelLighting,Nanlite USA,true,20.0,50,4500,Forza 60Lighting,Nanlite USA," +
				"true,20.0,50,4500,Forza 60Lighting,Nanlite USA,true,20.0,50,4500,Forza 60Type,Manufacturer," +
				"IsRented,PriceInUAH,FilmGenreDecorations,China Decorations LTD.,true,45000.0,historicalDecorations," +
				"China Decorations LTD.,true,45000.0,historical";
		assertEquals(expected, result.toString());
	}

	@Test
	void testWriteToCSVFileOneClassCase() throws IOException {
		FilmStudio studio = new FilmStudio();

		EquipmentBox equipmentBox = new EquipmentBox(new Camera("Sony Corporation Japan",
				false, 70499, "Alpha a7",
				24),3,14,"Cameras");


		studio.addNewEquipment(equipmentBox);
		EquipmentWriter.writeToCSVFile(studio.equipmentList);

		File file = new File("src/test/resources/result.csv");
		Scanner scanner = new Scanner(file, StandardCharsets.UTF_8);
		StringBuilder result = new StringBuilder();
		while (scanner.hasNextLine()){
			result.append(scanner.nextLine());
		}

		String expected = "Type,Manufacturer,IsRented,PriceInUAH,Model,MegapixelsCamera,Sony Corporation Japan," +
				"false,70499.0,Alpha a7,24Camera,Sony Corporation Japan,false,70499.0,Alpha a7,24Camera," +
				"Sony Corporation Japan,false,70499.0,Alpha a7,24";
	    assertEquals(expected, result.toString());
	}

	@Test
	void testWriteToSCVFileEmptyCase() throws IOException {
		EquipmentWriter.writeToCSVFile(new ArrayList<>());
		File file = new File("src/test/resources/result.csv");
		Scanner scanner = new Scanner(file, StandardCharsets.UTF_8);
		StringBuilder result = new StringBuilder();
		while (scanner.hasNextLine()) {
			result.append(scanner.nextLine());
		}

		assertEquals("", result.toString());
	}

	@Test
	void testEquipmentWriterUtilityClass() throws NoSuchMethodException {
		Constructor<EquipmentWriter> constructor = EquipmentWriter.class.getDeclaredConstructor();

		assertTrue(Modifier.isPrivate(constructor.getModifiers()));
	}
}
