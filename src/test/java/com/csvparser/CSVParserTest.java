package com.csvparser;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

/**
 * @author Sergey Popov
 *
 */
public class CSVParserTest extends TestCase {

	/**
	 * @param name
	 */
	public CSVParserTest(String name) {
		super(name);
	}

	/**
	 * Test method for {@link com.csvparser.CSV#parse(java.lang.String)}.
	 */
	public final void testParse() {
		char delimiter = ',';
		StringBuilder sb = new StringBuilder();
		sb.append("\"ddd ddd ddd \",abc,123,E3,\"ac, abs, as\",1000.00\n");
		sb.append("1,2,3,\"f \",\"kt\"");

		CSV csv = new CSV(delimiter);
		List<ArrayList<String>> result = csv.parse(sb.toString());
		assertNotNull(result);
		assertEquals(result.size(), 2);
		assertNotNull(result.get(0));
		assertEquals(result.get(0).size(), 6);
		assertEquals(result.get(0).get(0), "ddd ddd ddd ");
		assertEquals(result.get(0).get(1), "abc");
		assertEquals(result.get(0).get(2), "123");
		assertEquals(result.get(0).get(3), "E3");
		assertEquals(result.get(0).get(4), "ac, abs, as");
		assertEquals(result.get(0).get(5), "1000.00");

		assertNotNull(result.get(1));
		assertEquals(result.get(1).size(), 5);
		assertEquals(result.get(1).get(0), "1");
		assertEquals(result.get(1).get(1), "2");
		assertEquals(result.get(1).get(2), "3");
		assertEquals(result.get(1).get(3), "f ");
		assertEquals(result.get(1).get(4), "kt");
	}

}
