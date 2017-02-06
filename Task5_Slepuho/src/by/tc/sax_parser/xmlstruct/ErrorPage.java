package by.tc.sax_parser.xmlstruct;

public class ErrorPage extends TagElement {
	private String exceptionType;
	private String errorCode;
	private String location;

	public ErrorPage() {
		super();
	}

	public ErrorPage(String exceptionType, String errorCode, String location) {
		super();
		this.exceptionType = exceptionType;
		this.errorCode = errorCode;
		this.location = location;
	}



	public String getExceptionType() {
		return exceptionType;
	}



	public String getErrorCode() {
		return errorCode;
	}



	public String getLocation() {
		return location;
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
	public String toString() {
		return "ErrorPage [exceptionType=" + exceptionType + ", errorCode=" + errorCode + ", location=" + location+ "]";
	}

	


}
