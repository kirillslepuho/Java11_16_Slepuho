package by.tc.stax_parser;

public class StringFactory {
	private static final char startSymbol = '|';

	public StringFactory() {
	}

	public static String getString(char symbol, int symbolCount, boolean isAppendStartSymbol) {
		StringBuilder stringBuilder = new StringBuilder();
		if(isAppendStartSymbol) {
			stringBuilder.append(startSymbol);
		}

		for(int i = 0; i < symbolCount; ++i) {
			stringBuilder.append(symbol);
		}

		return stringBuilder.toString();
	}
}
