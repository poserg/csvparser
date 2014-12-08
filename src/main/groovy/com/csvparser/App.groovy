package com.csvparser;

class App
{
	public static void main( String[] args )
	{
		def csvString = "\"ddd ddd ddd \",22,3,a3,\"ac, abs, as\",1000.00\n"
		def csv = new CSV(",")
		csv.parse(csvString)
	}
}
