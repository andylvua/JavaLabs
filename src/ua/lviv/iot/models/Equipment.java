package ua.lviv.iot.models;

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
}
