package by.tc.stax_parser.xmlstruct;

import java.util.ArrayList;

import by.tc.stax_parser.StringFactory;

public class Servlet extends TagElement{
	private String servletName;
	private String servletClass;
	private ArrayList<InitParam> initParams;




	public Servlet() {
		initParams = new ArrayList<InitParam>(0);
	}


	public void setServletName(String servletName) {
		if(!servletName.isEmpty())
			this.servletName = servletName;
	}


	public void setServletClass(String servletClass) {
		if(!servletClass.isEmpty())
			this.servletClass = servletClass;
	}

	public InitParam addInitParams() {
		InitParam initParam = new InitParam();
		this.initParams.add(initParam);
		return initParam;
	}

	public InitParam getLast(){
		return initParams.get(initParams.size() - 1);
	}


	@Override
	public void print(int indent) {
		String indentTag = StringFactory.getString('-', indent * NUMBER_INDENTS, true);
		String indentNestingTag = StringFactory.getString('-', (indent * NUMBER_INDENTS) + NUMBER_INDENTS, true);
		String indentNestingData = StringFactory.getString('=', (indent * NUMBER_INDENTS) + NUMBER_INDENTS, true);
		System.out.println(indentTag + "servlet");
		System.out.println(indentNestingTag + "servlet-name");
		System.out.println(indentNestingData + servletName);
		System.out.println(indentNestingTag + "servlet-class");
		System.out.println(indentNestingData + servletClass);

		for (InitParam temp : initParams) {
			temp.print(indent + 1);
		}

	}

}
