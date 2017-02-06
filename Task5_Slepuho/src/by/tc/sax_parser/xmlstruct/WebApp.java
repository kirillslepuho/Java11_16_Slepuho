package by.tc.sax_parser.xmlstruct;

import java.util.ArrayList;


public class WebApp extends TagElement{
	private String id;
	private String version;

	private String displayName;
	private ArrayList<TagElement> webAppElements;

	public WebApp() {
		webAppElements = new ArrayList<TagElement>(0);
	}
	
	

	public WebApp(String id, String version, String displayName) {
		super();
		this.id = id;
		this.version = version;
		this.displayName = displayName;
		webAppElements = new ArrayList<TagElement>(0);
	}



	public WebApp(String id, String version, String displayName, ArrayList<TagElement> webAppElements) {
		super();
		this.id = id;
		this.version = version;
		this.displayName = displayName;
		this.webAppElements = webAppElements;
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

	public String getId() {
		return id;
	}

	public String getVersion() {
		return version;
	}

	public void setDisplayName(String displayName) {
		if(!displayName.isEmpty())
			this.displayName = displayName;
	}
	

	public String getDisplayName() {
		return displayName;
	}
	
	
	public ArrayList<TagElement> getWebAppElements() {
		return webAppElements;
	}

	public void setWebAppElements(ArrayList<TagElement> webAppElements) {
		this.webAppElements = webAppElements;
	}

	public void addElement(TagElement element) {
		webAppElements.add(element);
	}

	public TagElement getLast() {
		return webAppElements.get(webAppElements.size() - 1);
	}



	@Override
	public String toString() {
		StringBuilder text = new StringBuilder();
		for(int i = 0; i < webAppElements.size();i++){
			text.append(webAppElements.get(i).toString() + "\n");
		}
		
		return "WebApp(id=" + id + ", version=" + version + ")\n" + ", displayName=" + displayName + "\n,"+ webAppElements + "]";
	}


}
