package ua.lviv.iot;

import ua.lviv.iot.manager.*;
import ua.lviv.iot.models.*;

public class Main {
	public static void main(String[] args) {
		final String splitter = "----------------------------------------------------------";
		final String tab = "\t\t\t\t\t\u00A0\u00A0";

		EquipmentBox equipmentBox = new EquipmentBox(new Camera("Sony Corporation Japan",
				false, 70499, "Alpha a7",
				24),10,14,"Cameras");
		EquipmentBox equipmentBox1 = new EquipmentBox(new Camera("Canon Inc. Japan",
				false, 200, "FZ-1000",
				28),5,8,"Cameras");
		EquipmentBox equipmentBox2 = new EquipmentBox(new Lighting("Nanlite USA",
				true,20,50,4500, "Forza 60"),
				50,30,"Lighting");
		EquipmentBox equipmentBox3 = new EquipmentBox(new Decorations("China Decorations LTD.",
				true, 45000, "Historical"),
				2,560,"Decorations");

		FilmStudio marvelStudios = new FilmStudio();

		marvelStudios.addNewEquipment(equipmentBox, equipmentBox1, equipmentBox2, equipmentBox3);
		System.out.println(tab + "--------------");
		System.out.println("\033[0;1m" + tab + "Marvel Studios" + "\033[0;0m");
		System.out.println(tab + "--------------");
		System.out.println();
		System.out.println("-------------------- List of equipment -------------------");
		marvelStudios.printEquipment();
		System.out.println(splitter);
		System.out.println();
		System.out.println();
		System.out.println("-------------------- Rented equipment --------------------");
		marvelStudios.getRentedEquipment().forEach(System.out::println);
		System.out.println(splitter);
		System.out.println();
		System.out.println();
		System.out.println("---------------- Equipment sorted by price ---------------");
		marvelStudios.getEquipmentSortedByPrice(false).forEach(System.out::println);
		System.out.println(splitter);
		System.out.println();
		System.out.println();
		System.out.println("------------ Equipment sorted by manufacturer ------------");
		marvelStudios.getEquipmentSortedByManufacturer(false).forEach(System.out::println);
		System.out.println(splitter);
		System.out.println();
		System.out.println();
		System.out.println("------------- Decorations for historical film ------------");
		marvelStudios.getDecorationsByGenre("historical").forEach(System.out::println);
		System.out.println(splitter);
	}
}
