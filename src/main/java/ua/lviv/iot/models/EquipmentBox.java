package ua.lviv.iot.models;

public record EquipmentBox(Equipment equipment, int numberOfItems, int weightInKg, String typeOfEquipment){
	@Override
	public String toString() {
		return "Equipment      [" +
				"Type of equipment = " + typeOfEquipment +
				", Number of items: " + numberOfItems +
				", Weight KG: " + weightInKg +
				']';
	}
}