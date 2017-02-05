package by.tc.dom_parser;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import by.tc.parser.Parser;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOMParser implements Parser{
	private static DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

	private DocumentBuilder documentBuilder;
	private File xmlFile = null;
	private Document document = null;

	public DOMParser() {
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		}
	}

	public DOMParser(String filePath) {
		this.xmlFile = new File(filePath);
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		}
	}

	public DOMParser(File xmlFile) {
		this.xmlFile = xmlFile;;
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		}
	}

	public void parse(){
		if (xmlFile != null) {
			try {
				document = documentBuilder.parse(xmlFile);
			} catch (SAXException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			OutputHandler.printInformation(document);
		}
	}

	public void setXMLFile(File file) {
		this.xmlFile = file;
	}

	public void setXMLFile(String filepath) {
		this.xmlFile = new File(filepath);
	}

	public Document getDocument() {
		return document;
	}
}
