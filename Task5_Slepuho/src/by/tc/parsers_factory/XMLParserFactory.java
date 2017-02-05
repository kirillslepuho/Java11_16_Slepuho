package by.tc.parsers_factory;



import by.tc.dom_parser.DOMParser;
import by.tc.sax_parser.ParserSAX;
import by.tc.stax_parser.StAXParser;

public class XMLParserFactory {
	private static final XMLParserFactory xmlParserFactory = new XMLParserFactory();

	public XMLParserFactory() {

	}

	public static XMLParserFactory getInstance() {
		return xmlParserFactory;
	}

	public ParserSAX getSAXParser(){
		return new ParserSAX();
	}

	public DOMParser getDOMParser(){
		return new DOMParser();
	}

	public StAXParser getStAXParser(){
		return new StAXParser();
	}

}
