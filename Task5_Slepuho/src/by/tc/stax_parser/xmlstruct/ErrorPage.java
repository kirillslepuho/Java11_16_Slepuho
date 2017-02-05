package by.tc.stax_parser.xmlstruct;

import by.tc.stax_parser.StringFactory;

public class ErrorPage extends TagElement {
	private String exceptionType;
	private String errorCode;
	private String location;

	public ErrorPage() {
		super();
	}

	public void setExceptionType(String exceptionType) {
		if(!exceptionType.isEmpty()){
			this.exceptionType = exceptionType;
		}
	}

	public void setErrorCode(String errorCode) {
		if (!errorCode.isEmpty()) {
			this.errorCode = errorCode;
		} 
	}

	public void setLocation(String location) {
		if (!location.isEmpty()) {
			this.location = location;
		} else {
			this.location = "";
		}
	}

	@Override
	public void print(int indent) {
		String indentTag = StringFactory.getString('-', indent * NUMBER_INDENTS, true);
		String indentNestingTag = StringFactory.getString('-', (indent * NUMBER_INDENTS) + NUMBER_INDENTS, true);
		String indentNestingData = StringFactory.getString('=', (indent * NUMBER_INDENTS) + NUMBER_INDENTS, true);
		System.out.println(indentTag + "error-page");

		if(!(exceptionType == null)){
			System.out.println(indentNestingTag + "exception-type");
			System.out.println(indentNestingData + exceptionType);
		}
		if(!(errorCode == null)){
			System.out.println(indentNestingTag + "error-code");
			System.out.println(indentNestingData + errorCode);
		}

		System.out.println(indentNestingTag + "location");
		System.out.println(indentNestingData + location);

	}

}
