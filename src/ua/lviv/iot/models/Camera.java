package ua.lviv.iot.models;

public class Camera extends Equipment {
	String model;
	int megapixels;

	public Camera(String manufacturer, boolean isRented, float priceInUAH, String model, int megapixels) {
		super(manufacturer, isRented, priceInUAH);
		this.model = model;
		this.megapixels = megapixels;
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
}

