package by.tc.sax_parser.xmlstruct;

import java.util.ArrayList;


public class Servlet extends TagElement{
	private String servletName;
	private String servletClass;
	private ArrayList<InitParam> initParams;

	public Servlet(String servletName, String servletClass, ArrayList<InitParam> initParams) {
		super();
		this.servletName = servletName;
		this.servletClass = servletClass;
		this.initParams = initParams;
	}

	

	public Servlet(String servletName, String servletClass) {
		super();
		this.servletName = servletName;
		this.servletClass = servletClass;
		initParams = new ArrayList<InitParam>(0);
	}



	public Servlet() {
		initParams = new ArrayList<InitParam>(0);
	}
	
	


	public String getServletName() {
		return servletName;
	}



	public String getServletClass() {
		return servletClass;
	}



	public ArrayList<InitParam> getInitParams() {
		return initParams;
	}



	public void setInitParams(ArrayList<InitParam> initParams) {
		this.initParams = initParams;
	}



	public void setServletName(String servletName) {
		if(!servletName.isEmpty())
			this.servletName = servletName;
	}


	public void setServletClass(String servletClass) {
		if(!servletClass.isEmpty())
			this.servletClass = servletClass;
	}

	public void addInitParams(InitParam initParam) {
		this.initParams.add(initParam);
	}

	public InitParam getLast(){
		return initParams.get(initParams.size() - 1);
	}



	@Override
	public String toString() {
		return "Servlet [servletName=" + servletName + ", servletClass=" + servletClass + ", initParams=" + initParams + "]";
	}


	
}
