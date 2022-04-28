package ua.lviv.iot.models;

import java.util.Objects;

public class Equipment {
	protected final String manufacturer;
	protected final boolean isRented;
	protected final float priceInUAH;

	public String getManufacturer() {
		return manufacturer;
	}

	public boolean isRented() {
		return isRented;
	}

	public float getPriceInUAH() {
		return priceInUAH;
	}

	public Equipment(String manufacturer, boolean isRented, float priceInUAH) {
		this.manufacturer = manufacturer;
		this.isRented = isRented;
		this.priceInUAH = priceInUAH;
	}

	public String toCSV() {
		return manufacturer + "," + isRented + "," + priceInUAH;
	}

	public String getHeaders() {
		return "Manufacturer,IsRented,PriceInUAH";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Equipment equipment = (Equipment) o;
		return isRented == equipment.isRented && Float.compare(equipment.priceInUAH, priceInUAH) == 0 && Objects.equals(manufacturer, equipment.manufacturer);
	}

	@Override
	public int hashCode() {
		return Objects.hash(manufacturer, isRented, priceInUAH);
	}
}
