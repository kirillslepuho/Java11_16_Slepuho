package by.tc.stax_parser.xmlstruct;

import by.tc.stax_parser.StringFactory;

public class ServletMapping extends TagElement{
	private String servletName;
	private String urlPattern;



	public ServletMapping() {

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
	public void print(int indent) {
		String indentTag = StringFactory.getString('-', indent * NUMBER_INDENTS, true);
		String indentNestingTag = StringFactory.getString('-', (indent * NUMBER_INDENTS) + NUMBER_INDENTS, true);
		String indentNestingData = StringFactory.getString('=', (indent * NUMBER_INDENTS) + NUMBER_INDENTS, true);
		System.out.println(indentTag + "servlet-mapping");
		System.out.println(indentNestingTag + "servlet-name");
		System.out.println(indentNestingData + servletName);
		System.out.println(indentNestingTag + "url-pattern");
		System.out.println(indentNestingData + urlPattern);

	}

}
