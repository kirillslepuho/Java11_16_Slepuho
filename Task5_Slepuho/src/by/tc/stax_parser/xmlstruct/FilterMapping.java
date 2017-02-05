package by.tc.stax_parser.xmlstruct;

import by.tc.stax_parser.StringFactory;

public class FilterMapping extends TagElement{
	private String filterName;
	private String urlPattern;
	private String dispatcher;



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
	public void print(int indent) {
		String indentTag = StringFactory.getString('-', indent * NUMBER_INDENTS, true);
		String indentNestingTag = StringFactory.getString('-', (indent * NUMBER_INDENTS) + NUMBER_INDENTS, true);
		String indentNestingData = StringFactory.getString('=', (indent * NUMBER_INDENTS) + NUMBER_INDENTS, true);
		System.out.println(indentTag + "filter-mapping");
		System.out.println(indentNestingTag + "filter-name");
		System.out.println(indentNestingData + filterName);
		System.out.println(indentNestingTag + "url-pattern");
		System.out.println(indentNestingData + urlPattern);
		System.out.println(indentNestingTag + "dispatcher");
		System.out.println(indentNestingData + dispatcher);

	}

}
