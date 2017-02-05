package by.tc.main;

import java.io.FileNotFoundException;

import by.tc.parser.Parser;
import by.tc.parsers_factory.XMLParserFactory;

public class Main {

	public static void main(String[] args) {
		XMLParserFactory xmlParserFactory = XMLParserFactory.getInstance();

		Parser SAXParser = xmlParserFactory.getSAXParser();
		try {
			SAXParser.setXMLFile("res/web.xml");
			SAXParser.parse();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		Parser DOMParser = xmlParserFactory.getDOMParser();
		try {
			DOMParser.setXMLFile("res/web.xml");
			DOMParser.parse();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		Parser StAXParser = xmlParserFactory.getStAXParser();
		try {
			StAXParser.setXMLFile("res/web.xml");
			StAXParser.parse();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

}
