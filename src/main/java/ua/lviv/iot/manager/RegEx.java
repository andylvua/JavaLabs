package ua.lviv.iot.manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record RegEx(String filePath) {
	private String getTextFromFile() {
		File file = new File(filePath);
		String text = null;

		try (Scanner scanner = new Scanner(file)) {
			StringBuilder result = new StringBuilder();
			while (scanner.hasNextLine()) {
				result.append(scanner.nextLine()).append("\n");
			}

			text = result.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return text;
	}

	public List<String> getFirstSentenceUniqueWords(boolean sort) {
		String text = getTextFromFile();
		assert text != null;

		String sentencesRegEx = "(?!\\d+\\.)\\.\\h(?!\\d+)";
		String[] sentences = text.split(sentencesRegEx);

		Set<String> firstSentenceWordsSet = new HashSet<>();

		String wordsRegEx = "(\\d+\\.\\d+)|\\w+\\b";
		Pattern wordsPattern = Pattern.compile(wordsRegEx);
		Matcher firstSentenceWordsMatcher = wordsPattern.matcher(sentences[0]);

		while (firstSentenceWordsMatcher.find()) {
			firstSentenceWordsSet.add(firstSentenceWordsMatcher.group());
		}

		for (String sentence : sentences) {
			if (Objects.equals(sentence, sentences[0])) continue;

			Matcher sentenceWordsMatcher = wordsPattern.matcher(sentence);

			while (sentenceWordsMatcher.find()) {
				String temporaryWord = sentenceWordsMatcher.group();
				firstSentenceWordsSet.removeIf(word -> word.equalsIgnoreCase(temporaryWord));
			}
		}

		List<String> uniqueWords = new ArrayList<>(firstSentenceWordsSet);

		if (sort) {
			Collections.sort(uniqueWords);
		}
		return uniqueWords;
	}
}
