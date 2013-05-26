package com.csvparser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Sergey Popov
 *
 */
public class CSV {

	private static final String LINE_DELIMITER = "[\r?\n|\r]+";
	private final char delimiter;
	private final Pattern pattern;

	public CSV(char delimiter) {
		this.delimiter = delimiter;

		pattern = getPattern(delimiter);
	}

	/**
	 * @param delimiter
	 * @return
	 */
	private Pattern getPattern(char delimiter) {
		// "(?<=(\"|^\"))([^\"]*)(?=\",|\"$)|(?<=,|^)([^,\"]*)(?=,|$)"
		return Pattern.compile(String.format("(?<=(\"|^\"))([^\"]*)(?=\"%s|\"$)|(?<=%s|^)([^%s\"]*)(?=%s|$)", delimiter, delimiter, delimiter, delimiter));
	}

	public List<ArrayList<String>> parse(String csv) {
		String[] lines = csv.split(LINE_DELIMITER);
		List<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

		for (String line : lines) {
			ArrayList<String> l = new ArrayList<String>();
			Matcher matcher = pattern.matcher(line);
			while (matcher.find()) {
				String match = matcher.group(0);
				if (match != null) {
					l.add(match);
				}
			}
			result.add(l);
		}
		return result;
	}
}
