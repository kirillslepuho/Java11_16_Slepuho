package by.tc.stax_parser.xmlstruct;

import java.util.ArrayList;

import by.tc.stax_parser.StringFactory;

public class WebApp extends TagElement{
	private String id;
	private String version;

	private String displayName;
	private ArrayList<TagElement> webAppElements;

	public WebApp() {
		webAppElements = new ArrayList<TagElement>(0);
	}

	public void setId(String id) {
		if(!id.isEmpty()){
			this.id = id;
		}else{
			this.id = "";
		}
	}

	public void setVersion(String version) {
		if(!version.isEmpty()){
			this.version = version;
		}else{
			this.version = "";
		}
	}


	public void setDisplayName(String displayName) {
		if(!displayName.isEmpty())
			this.displayName = displayName;
	}

	public void addElement(TagElement element) {
		webAppElements.add(element);
	}

	public TagElement getLast() {
		return webAppElements.get(webAppElements.size() - 1);
	}

	public void print(int indent) {
		String indentTag = StringFactory.getString('-', indent * NUMBER_INDENTS, true);
		String indentNestingTag = StringFactory.getString('-', (indent * NUMBER_INDENTS) + NUMBER_INDENTS, true);
		String indentNestingData = StringFactory.getString('=', (indent * NUMBER_INDENTS) + NUMBER_INDENTS, true);
		System.out.println(indentTag + "WebApp id = " + id + " version = " + version);
		System.out.println(indentNestingTag + "display-name");
		System.out.println(indentNestingData + displayName);
		for (TagElement temp : webAppElements) {
			temp.print(indent + 1);
		}
	}


}
