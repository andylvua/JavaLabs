package ua.lviv.iot.models;

import java.util.Objects;

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
	public String toCSV() {
		return "Lighting" + "," + super.toCSV() + "," + watts + "," + kelvins + "," + model;
	}

	@Override
	public String getHeaders() {
		return "Type" + "," + super.getHeaders() + "," + "Watts,Kelvins,Model";
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		Lighting lighting = (Lighting) o;
		return watts == lighting.watts && kelvins == lighting.kelvins && Objects.equals(model, lighting.model);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), watts, kelvins, model);
	}
}
