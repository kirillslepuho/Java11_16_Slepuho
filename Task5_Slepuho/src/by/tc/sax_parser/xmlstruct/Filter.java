package by.tc.sax_parser.xmlstruct;

import java.util.ArrayList;


public class Filter extends TagElement{
	private String filterName;
	private String filterClass;
	private ArrayList<InitParam> initParams;

	public Filter(){
		initParams = new ArrayList<InitParam>(0);
	}
	
	

	public Filter(String filterName, String filterClass, ArrayList<InitParam> initParams) {
		super();
		this.filterName = filterName;
		this.filterClass = filterClass;
		this.initParams = initParams;
	}



	public String getFilterName() {
		return filterName;
	}



	public String getFilterClass() {
		return filterClass;
	}



	public ArrayList<InitParam> getInitParams() {
		return initParams;
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

	public void addInitParams(InitParam initParam) {
		this.initParams.add(initParam);
	}



	@Override
	public String toString() {
		return "Filter [filterName=" + filterName + ", filterClass=" + filterClass + ", initParams=" + initParams + "]";
	}



}
