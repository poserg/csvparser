package com.csvparser;

import groovy.util.GroovyTestCase

/**
 * @author Sergey Popov
 *
 */
class CSVParserTest extends GroovyTestCase {

	/**
	 * Test method for {@link com.csvparser.CSV#parse(java.lang.String)}.
	 */
	void testParse() {
		def sb = "\"ddd ddd ddd \",abc,123,E3,\"ac, abs, as\",1000.00\n1,2,3,\"f \",\"kt\""

		def csv = new CSV(",")
		def result = csv.parse(sb)
		assert result != null
		assert result.size() == 2
		assert result[0] != null
		assert result[0].size() == 6
		assert result[0][0] == "ddd ddd ddd "
		assert result[0][1] == "abc"
		assert result[0][2] == "123"
		assert result[0][3] == "E3"
		assert result[0][4] == "ac, abs, as"
		assert result[0][5] == "1000.00"

		assert result[1] != null
		assert result[1].size() == 5
		assert result[1][0] == "1"
		assert result[1][1] == "2"
		assert result[1][2] == "3"
		assert result[1][3] == "f "
		assert result[1][4] == "kt"
	}

}
