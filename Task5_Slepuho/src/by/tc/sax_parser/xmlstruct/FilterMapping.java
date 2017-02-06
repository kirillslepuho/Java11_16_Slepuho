package by.tc.sax_parser.xmlstruct;


public class FilterMapping extends TagElement{
	private String filterName;
	private String urlPattern;
	private String dispatcher;



	public FilterMapping() {

	}



	public FilterMapping(String filterName, String urlPattern, String dispatcher) {
		this.filterName = filterName;
		this.urlPattern = urlPattern;
		this.dispatcher = dispatcher;
	}



	public String getFilterName() {
		return filterName;
	}



	public String getUrlPattern() {
		return urlPattern;
	}



	public String getDispatcher() {
		return dispatcher;
	}



	public void setFilterName(String filterName) {
		if(!filterName.isEmpty())
			this.filterName = filterName;
	}


	public void setUrlPattern(String urlPattern) {
		if(!urlPattern.isEmpty())
			this.urlPattern = urlPattern;
	}


	public void setDispatcher(String dispatcher) {
		if(!dispatcher.isEmpty())
			this.dispatcher = dispatcher;
	}



	@Override
	public String toString() {
		return "FilterMapping [filterName=" + filterName + ", urlPattern=" + urlPattern + ", dispatcher=" + dispatcher+ "]";
	}


	
}
