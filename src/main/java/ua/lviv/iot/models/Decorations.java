package ua.lviv.iot.models;

import java.util.Objects;

public class Decorations extends Equipment {
	private final String filmGenre;

	public Decorations(String manufacturer, boolean isRented, float priceInUAH, String filmGenre) {
		super(manufacturer, isRented, priceInUAH);
		this.filmGenre = filmGenre.toLowerCase();
	}

	public String getFilmGenre() {
		return filmGenre;
	}

	@Override
	public String toCSV() {
		return "Decorations" + "," + super.toCSV() + "," + filmGenre;
	}

	@Override
	public String getHeaders() {
		return "Type" + "," + super.getHeaders() + "," + "FilmGenre";
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		Decorations that = (Decorations) o;
		return Objects.equals(filmGenre, that.filmGenre);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), filmGenre);
	}
}
