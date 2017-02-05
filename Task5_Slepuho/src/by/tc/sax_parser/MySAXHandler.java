package by.tc.sax_parser;

import org.xml.sax.Attributes;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXException;

public class MySAXHandler extends DefaultHandler {

	private int currentNesting = 0;

	@Override
	public void startDocument() throws SAXException {

	}

	@Override
	public void startElement(String namespaceURI, String localName,
			String combinationName, Attributes attributes) throws SAXException {
		OutputHandler.printNode(combinationName, currentNesting);

		OutputHandler.printAttributes(attributes);
		currentNesting++;
	}

	@Override
	public void characters(char[] data, int start, int length) throws SAXException {
		currentNesting--;
		OutputHandler.printNodeValue(data, start, length, currentNesting);
		currentNesting++;
	}

	@Override
	public void endElement(String namespaceURI, String localName,
			String combinationName) throws SAXException {
		currentNesting--;
	}

	@Override
	public void endDocument() {

	}
}
