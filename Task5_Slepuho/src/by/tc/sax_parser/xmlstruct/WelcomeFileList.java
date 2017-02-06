package by.tc.sax_parser.xmlstruct;

import java.util.ArrayList;



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

	public ArrayList<String> getWelcomeFiles() {
		return welcomeFiles;
	}

	@Override
	public String toString() {
		StringBuilder text = new StringBuilder();
		for(int i = 0; i<welcomeFiles.size();i++){
			text.append("welcome-file = " + welcomeFiles.get(i) + " ");
		}
		
		
		return "WelcomeFileList:[" + text.toString() + "]";
	}

	

}
