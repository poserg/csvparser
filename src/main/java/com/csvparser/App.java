package com.csvparser;

/**
 * Hello world!
 *
 */
public class App
{
	public static void main( String[] args )
	{
		String csvString = "\"ddd ddd ddd \",22,3,a3,\"ac, abs, as\",1000.00\n";
		CSV csv = new CSV(',');
		csv.parse(csvString);
	}
}
