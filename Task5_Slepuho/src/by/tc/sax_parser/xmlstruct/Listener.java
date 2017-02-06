package by.tc.sax_parser.xmlstruct;


public class Listener extends TagElement{
	private String listenerClass;
	
	

	public Listener() {

	}



	public Listener(String listenerClass) {
		super();
		this.listenerClass = listenerClass;
	}



	public String getListenerClass() {
		return listenerClass;
	}



	public void setListenerClass(String listenerClass) {
		if(!listenerClass.isEmpty())
			this.listenerClass = listenerClass;
	}



	@Override
	public String toString() {
		return "Listener [listenerClass=" + listenerClass + "]";
	}

	
}
