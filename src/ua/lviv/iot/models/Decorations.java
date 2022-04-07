package ua.lviv.iot.models;

public class Decorations extends Equipment {
	String filmGenre;

	public Decorations(String manufacturer, boolean isRented, float priceInUAH, String filmGenre) {
		super(manufacturer, isRented, priceInUAH);
		this.filmGenre = filmGenre.toLowerCase();
	}

	public String getFilmGenre() {
		return filmGenre;
	}

	@Override
	public String toString() {
		return "Decorations    [" +
				"Manufacturer: " + manufacturer +
				", IsRented: " + isRented +
				", priceInUAH = " + priceInUAH +
				", filmGenre: " + filmGenre +
				']';
	}
}
