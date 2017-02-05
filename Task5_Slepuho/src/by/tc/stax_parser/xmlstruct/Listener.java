package by.tc.stax_parser.xmlstruct;

import by.tc.stax_parser.StringFactory;

public class Listener extends TagElement{
	private String listenerClass;

	public void setListenerClass(String listenerClass) {
		if(!listenerClass.isEmpty())
			this.listenerClass = listenerClass;
	}

	@Override
	public void print(int indent) {
		String indentTag = StringFactory.getString('-', indent * NUMBER_INDENTS, true);
		String indentNestingTag = StringFactory.getString('-', (indent * NUMBER_INDENTS) + NUMBER_INDENTS, true);
		String indentNestingData = StringFactory.getString('=', (indent * NUMBER_INDENTS) + NUMBER_INDENTS, true);
		System.out.println(indentTag + "listener");
		System.out.println(indentNestingTag + "listener-class");
		System.out.println(indentNestingData + listenerClass);

	}

}
