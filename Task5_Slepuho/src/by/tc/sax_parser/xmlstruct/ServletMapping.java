package by.tc.sax_parser.xmlstruct;


public class ServletMapping extends TagElement{
	private String servletName;
	private String urlPattern;


	public ServletMapping(String servletName, String urlPattern) {
		super();
		this.servletName = servletName;
		this.urlPattern = urlPattern;
	}

	public ServletMapping() {

	}

	
	public String getServletName() {
		return servletName;
	}

	public String getUrlPattern() {
		return urlPattern;
	}

	public void setServletName(String servletName) {
		if(!servletName.isEmpty())
			this.servletName = servletName;
	}

	public void setUrlPattern(String urlPattern) {
		if(!urlPattern.isEmpty())
			this.urlPattern = urlPattern;
	}

	@Override
	public String toString() {
		return "ServletMapping [servletName=" + servletName + ", urlPattern=" + urlPattern + "]";
	}

	
	
}
