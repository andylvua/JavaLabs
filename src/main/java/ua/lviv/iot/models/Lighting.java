package ua.lviv.iot.models;

public class Lighting extends Equipment {
	private final int watts;
	private final int kelvins;
	private final String model;

	public Lighting(String manufacturer, boolean isRented, float priceInUAH, int watts, int kelvins, String model) {
		super(manufacturer, isRented, priceInUAH);
		this.watts = watts;
		this.kelvins = kelvins;
		this.model = model;
	}

	@Override
	public String toString() {
		return "Lighting       [" +
				"Manufacturer: " + manufacturer +
				", IsRented: " + isRented +
				", priceInUAH = " + priceInUAH +
				", Model: '" + model + '\'' +
				", Watts = " + watts +
				", Kelvins = " + kelvins +
				']';
	}
}
