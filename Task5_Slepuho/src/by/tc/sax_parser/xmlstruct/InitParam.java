package by.tc.sax_parser.xmlstruct;


public class InitParam extends TagElement{
	private String paramName;
	private String paramValue;



	public InitParam() {

	}

	

	public InitParam(String paramName, String paramValue) {
		this.paramName = paramName;
		this.paramValue = paramValue;
	}

	public String getParamName() {
		return paramName;
	}

	public String getParamValue() {
		return paramValue;
	}

	public void setParamName(String paramName) {
		if(!paramName.isEmpty())
			this.paramName = paramName;
	}

	public void setParamValue(String paramValue) {
		if(!paramValue.isEmpty())
			this.paramValue = paramValue;
	}



	@Override
	public String toString() {
		return "InitParam [paramName=" + paramName + ", paramValue=" + paramValue + "]";
	}

	
	
}
