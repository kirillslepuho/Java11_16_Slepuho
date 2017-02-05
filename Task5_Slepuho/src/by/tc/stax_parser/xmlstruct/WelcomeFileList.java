package by.tc.stax_parser.xmlstruct;

import java.util.ArrayList;

import by.tc.stax_parser.StringFactory;

public class WelcomeFileList extends TagElement{
	private ArrayList<String> welcomeFiles;

	public WelcomeFileList(){
		welcomeFiles = new ArrayList<String>(0);
	}

	public void addWelcomeFile(String welcomeFile){
		welcomeFiles.add(welcomeFile);
	}

	public String getLast() {
		return welcomeFiles.get(welcomeFiles.size() - 1);
	}

	@Override
	public void print(int indent) {
		String indentTag = StringFactory.getString('-', indent * NUMBER_INDENTS, true);
		String indentNestingTag = StringFactory.getString('-', (indent * NUMBER_INDENTS) + NUMBER_INDENTS, true);
		String indentNestingData = StringFactory.getString('=', (indent * NUMBER_INDENTS) + NUMBER_INDENTS, true);
		System.out.println(indentTag + "welcome-file-list");
		for(String welcomeFile : welcomeFiles){
			System.out.println(indentNestingTag + "welcome-file");
			System.out.println(indentNestingData + welcomeFile);
		}

	}
}
