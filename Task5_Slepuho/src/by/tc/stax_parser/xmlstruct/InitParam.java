package by.tc.stax_parser.xmlstruct;

import by.tc.stax_parser.StringFactory;

public class InitParam extends TagElement{
	private String paramName;
	private String paramValue;



	public InitParam() {

	}


	@Override
	public void print(int indent) {
		String indentTag = StringFactory.getString('-', indent * NUMBER_INDENTS, true);
		String indentNestingTag = StringFactory.getString('-', (indent * NUMBER_INDENTS) + NUMBER_INDENTS, true);
		String indentNestingData = StringFactory.getString('=', (indent * NUMBER_INDENTS) + NUMBER_INDENTS, true);
		System.out.println(indentTag + "init-param");
		System.out.println(indentNestingTag + "param-name");
		System.out.println(indentNestingData + paramName);
		System.out.println(indentNestingTag + "param-value");
		System.out.println(indentNestingData + paramValue);

	}


	public void setParamName(String paramName) {
		if(!paramName.isEmpty())
			this.paramName = paramName;
	}

	public void setParamValue(String paramValue) {
		if(!paramValue.isEmpty())
			this.paramValue = paramValue;
	}

}
