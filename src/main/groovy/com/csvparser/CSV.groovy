package com.csvparser;

/**
 * @author Sergey Popov
 *
 */
class CSV {

	def private static final String LINE_DELIMITER = '[\r?\n|\r]+'
	def private pattern

	CSV(String delimiter) {
		pattern = /(?<=(\"|^\"))([^\"]*)(?=\"$delimiter|\"$)|(?<=$delimiter|^)([^$delimiter\"]*)(?=$delimiter|$)/
	}

	def parse(String csv) {
		def lines = csv.split(LINE_DELIMITER)
		def result = []
		for (String i : lines) {
			def matcher = i =~ pattern
			def l = []
			if (matcher.find()) {
				for (int k = 0; k < matcher.getCount(); k++)
					l << matcher[k][0]
			}
			result << l
		}
		return result	
	}

	def match(line) {
		def matcher = line =~ pattern
		if (matcher.find()) {
			return matcher.each({it[0]})
		} else {
			return null;
		}
	}
}
