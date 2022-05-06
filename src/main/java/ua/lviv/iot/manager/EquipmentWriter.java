package ua.lviv.iot.manager;

import ua.lviv.iot.models.Equipment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public final class EquipmentWriter {
	private EquipmentWriter() {
		throw new UnsupportedOperationException("Utility class");
	}

	public static void writeToCSVFile(List<Equipment> equipmentBox) throws IOException {
		File file = new File("src/test/resources/result.csv");
		String separator = System.getProperty("line.separator");

		try (FileWriter fileWriter = new FileWriter(file, StandardCharsets.UTF_8)) {
			String previousClassName = "";
			boolean isFirstHeader = true;

			for (var equipment: equipmentBox) {
				if (!equipment.getClass().getSimpleName().equals(previousClassName)) {
					if (!isFirstHeader) {
						fileWriter.write(separator);
					}
					fileWriter.write(equipment.getHeaders());
					fileWriter.write(separator);
					previousClassName = equipment.getClass().getSimpleName();
					isFirstHeader = false;
				}
				fileWriter.write(equipment.toCSV());
				fileWriter.write(separator);
			}
		}
	}
}
