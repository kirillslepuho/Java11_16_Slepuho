package by.tc.sax_parser;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import by.tc.parser.Parser;

public class ParserSAX implements Parser{
	private static SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
	private SAXParser saxParser = null;
	private FileReader xmlFileReader = null;
	private File xmlFile = null;
	private MySAXHandler mySAXHandler = new MySAXHandler();



	public ParserSAX(){
		try {
			saxParser = saxParserFactory.newSAXParser();
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		} catch (SAXException e) {
			System.out.println(e.getMessage());
		}
	}

	public ParserSAX(String filePath){
		try {
			xmlFileReader = new FileReader(filePath);
			saxParser = saxParserFactory.newSAXParser();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		} catch (SAXException e) {
			System.out.println(e.getMessage());
		}

	}

	public ParserSAX(File xmlFile) {
		try {
			xmlFileReader = new FileReader(xmlFile);
			saxParser = saxParserFactory.newSAXParser();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		} catch (SAXException e) {
			System.out.println(e.getMessage());	
		}

	}


	public void setXMLFile(File xmlFile) throws FileNotFoundException {
		this.xmlFile = xmlFile;
		xmlFileReader = new FileReader(xmlFile);
	}

	public void setXMLFile(String filePath) throws FileNotFoundException {
		this.xmlFile = new File(filePath);
		xmlFileReader = new FileReader(xmlFile);
	}

	public void parse(){
		try {
			saxParser.parse(new InputSource(xmlFileReader), mySAXHandler);
		} catch (SAXException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}




}
