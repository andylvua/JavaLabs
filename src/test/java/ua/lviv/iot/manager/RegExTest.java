package ua.lviv.iot.manager;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RegExTest {
	@Test
	void getFirstSentenceUniqueWords() {
		RegEx regex = new RegEx("src/test/resources/text.txt");

		List<String> expected = Arrays.asList("2.5", "John", "Las", "Vegas", "a", "and", "dining", "downtown",
				"entertainment", "experiences", "fine", "hotels", "lot", "luxury", "mile", "of", "on", "shopping",
				"spent", "stretch", "time", "venues", "which");
		List<String> actual = regex.getFirstSentenceUniqueWords(true);
		assertEquals(expected, actual);
	}
}
