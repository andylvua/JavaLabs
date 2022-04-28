package ua.lviv.iot.models;

import java.util.Objects;

public class Camera extends Equipment {
	private final String model;
	private final int megapixels;

	public Camera(String manufacturer, boolean isRented, float priceInUAH, String model, int megapixels) {
		super(manufacturer, isRented, priceInUAH);
		this.model = model;
		this.megapixels = megapixels;
	}

	@Override
	public String toCSV() {
		return "Camera" + "," + super.toCSV() + "," + model + "," + megapixels;
	}

	@Override
	public String getHeaders() {
		return "Type" + "," + super.getHeaders() + "," + "Model,Megapixels";
	}

	@Override
	public String toString() {
		return "Camera         [" +
				"Manufacturer: " + manufacturer +
				", IsRented: " + isRented +
				", priceInUAH = " + priceInUAH +
				", Model: '" + model + '\'' +
				", Megapixels = " + megapixels +
				']';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		Camera camera = (Camera) o;
		return megapixels == camera.megapixels && Objects.equals(model, camera.model);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), model, megapixels);
	}
}
