package by.tc.stax_parser.xmlstruct;

import java.util.ArrayList;

import by.tc.stax_parser.StringFactory;

public class Filter extends TagElement{
	private String filterName;
	private String filterClass;
	private ArrayList<InitParam> initParams;

	public Filter(){
		initParams = new ArrayList<InitParam>(0);
	}

	public void setFilterName(String filterName) {
		if(!filterName.isEmpty()){
			this.filterName = filterName;
		} else{
			this.filterName = "";
		}
	}

	public void setFilterClass(String filterClass) {
		if(!filterClass.isEmpty()){
			this.filterClass = filterClass;
		}else{
			this.filterClass = "";
		}
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
		System.out.println(indentTag + "filter");
		System.out.println(indentNestingTag + "filter-name");
		System.out.println(indentNestingData + filterName);
		System.out.println(indentNestingTag + "filter-class");
		System.out.println(indentNestingData + filterClass);

		for (InitParam temp : initParams) {
			temp.print(indent + 1);
		}

	}


}
