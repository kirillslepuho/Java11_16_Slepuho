package by.tc.parser;

import java.io.File;
import java.io.FileNotFoundException;

public interface Parser {
	public void parse();
	public void setXMLFile(File xmlFile) throws FileNotFoundException;
	public void setXMLFile(String filepath) throws FileNotFoundException;
}
