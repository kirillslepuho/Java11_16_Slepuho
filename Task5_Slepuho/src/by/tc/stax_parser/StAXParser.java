package by.tc.stax_parser;

import javax.xml.stream.XMLInputFactory;

import javax.xml.stream.XMLStreamReader;

import by.tc.parser.Parser;
import by.tc.stax_parser.xmlstruct.ErrorPage;
import by.tc.stax_parser.xmlstruct.Filter;
import by.tc.stax_parser.xmlstruct.FilterMapping;
import by.tc.stax_parser.xmlstruct.InitParam;
import by.tc.stax_parser.xmlstruct.Listener;
import by.tc.stax_parser.xmlstruct.Servlet;
import by.tc.stax_parser.xmlstruct.ServletMapping;
import by.tc.stax_parser.xmlstruct.TagElement;
import by.tc.stax_parser.xmlstruct.WebApp;
import by.tc.stax_parser.xmlstruct.WelcomeFileList;

import javax.xml.stream.XMLStreamException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class StAXParser implements Parser{
	private XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
	private XMLStreamReader xmlStreamReader = null;
	private InputStream inputStream = null;
	private File xmlFile = null;


	public StAXParser() {

	}

	public StAXParser(File xmlFile) {
		this.xmlFile = xmlFile;
	}

	public StAXParser(String filepath) {
		xmlFile = new File(filepath);
	}

	public void setXMLFile(File xmlFile) {
		this.xmlFile = xmlFile;
	}

	public void setXMLFile(String filepath) {
		xmlFile = new File(filepath);
	}


	public void parse(){
		try {

			inputStream = new FileInputStream(xmlFile);
			xmlStreamReader = xmlInputFactory.createXMLStreamReader(inputStream);
			parseWebApp().print(0);

		} catch (XMLStreamException e) {
			System.out.println(e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			if (xmlStreamReader != null)
				try {
					xmlStreamReader.close();
				} catch (XMLStreamException e) {
					System.out.println(e.getMessage());
				}
		}
	}

	public WebApp parseWebApp() throws XMLStreamException {

		WebApp root = new WebApp();

		while (xmlStreamReader.hasNext()) {
			int eventType = xmlStreamReader.next();
			switch(eventType) {
			case XMLStreamReader.START_ELEMENT:
				String localName = xmlStreamReader.getLocalName();
				if (localName.equals("web-app")) {
					parseWebApp(root);
				}
				break;
			case XMLStreamReader.END_DOCUMENT:
				break;
			}
		}
		return root;
	}


	private void parseWebApp(WebApp webApp) throws XMLStreamException {
		webApp.setId(xmlStreamReader.getAttributeValue(0));
		webApp.setVersion(xmlStreamReader.getAttributeValue(1));
		while (xmlStreamReader.hasNext()) {
			int eventType = xmlStreamReader.next();
			switch (eventType) {
			case XMLStreamReader.START_ELEMENT:
				String localName = xmlStreamReader.getLocalName();
				switch (localName) {
				case "display-name":
					webApp.setDisplayName(getElementData());
					break;
				case "welcome-file-list":
					TagElement welcomeFileList = new WelcomeFileList();
					webApp.addElement(welcomeFileList);
					parseWelcomeFileList((WelcomeFileList)welcomeFileList);
					break;
				case "filter":
					TagElement filter = new Filter();
					webApp.addElement(filter);
					parseFilter((Filter)filter);
					break;
				case "filter-mapping":
					TagElement filterMapping = new FilterMapping();
					webApp.addElement(filterMapping);
					parseFilterMapping((FilterMapping)filterMapping);
					break;
				case "listener":
					TagElement listener = new Listener();
					webApp.addElement(listener);
					parseListener((Listener)listener);
					break;
				case "servlet":
					TagElement servlet = new Servlet();
					webApp.addElement(servlet);
					parseServlet((Servlet)servlet);
					break;
				case "servlet-mapping":
					TagElement servletMapping = new ServletMapping();
					webApp.addElement(servletMapping);
					parseServletMapping((ServletMapping)servletMapping);
					break;
				case "error-page":
					TagElement errorPage = new ErrorPage();
					webApp.addElement(errorPage);
					parseErrorPage((ErrorPage)errorPage);
					break;
				}
				break;
			case XMLStreamReader.END_ELEMENT:
				if (xmlStreamReader.getLocalName().equals("web-app")) {
					return;
				}
				break;
			}
		}
	}

	private void parseWelcomeFileList(WelcomeFileList welcomeFileList) throws XMLStreamException {
		while (xmlStreamReader.hasNext()) {
			int eventType = xmlStreamReader.next();
			switch (eventType) {
			case XMLStreamReader.START_ELEMENT:
				String localName = xmlStreamReader.getLocalName();
				if (localName.equals("welcome-file")) {
					String welcomeFile = getElementData();
					welcomeFileList.addWelcomeFile(welcomeFile);
				}
				break;
			case XMLStreamReader.END_ELEMENT:
				if (xmlStreamReader.getLocalName().equals("welcome-file-list")) {
					return;
				}
				break;
			}
		}
	}

	private void parseFilter(Filter filter) throws XMLStreamException {
		while (xmlStreamReader.hasNext()) {
			int eventType = xmlStreamReader.next();
			switch (eventType) {
			case XMLStreamReader.START_ELEMENT:
				String localName = xmlStreamReader.getLocalName();
				switch(localName) {
				case "filter-name":
					filter.setFilterName(getElementData());
					break;
				case "filter-class":
					filter.setFilterClass(getElementData());
					break;
				case "init-param":
					InitParam initParam = filter.addInitParams();
					parseInitParam(initParam);    
				}
				break;
			case XMLStreamReader.END_ELEMENT:
				if (xmlStreamReader.getLocalName().equals("filter")) {
					return;
				}
				break;
			}
		}
	}

	private void parseListener(Listener listener) throws XMLStreamException {
		while (xmlStreamReader.hasNext()) {
			int eventType = xmlStreamReader.next();
			switch (eventType) {
			case XMLStreamReader.START_ELEMENT:
				String localName = xmlStreamReader.getLocalName();
				switch(localName) {
				case "listener-class":
					listener.setListenerClass(getElementData());
					break;
				}
				break;
			case XMLStreamReader.END_ELEMENT:
				if (xmlStreamReader.getLocalName().equals("listener")) {
					return;
				}
				break;
			}
		}
	}

	private void parseFilterMapping(FilterMapping filterMapping) throws XMLStreamException {
		while (xmlStreamReader.hasNext()) {
			int eventType = xmlStreamReader.next();
			switch (eventType) {
			case XMLStreamReader.START_ELEMENT:
				String localName = xmlStreamReader.getLocalName();
				switch(localName) {
				case "filter-name":
					filterMapping.setFilterName(getElementData());
					break;
				case "url-pattern":
					filterMapping.setUrlPattern(getElementData());
					break;
				case "dispatcher":
					filterMapping.setDispatcher(getElementData());
					break;
				}
				break;
			case XMLStreamReader.END_ELEMENT:
				if (xmlStreamReader.getLocalName().equals("filter-mapping")) {
					return;
				}
				break;
			}
		}
	}

	private void parseServlet(Servlet servlet) throws XMLStreamException {
		while (xmlStreamReader.hasNext()) {
			int eventType = xmlStreamReader.next();
			switch (eventType) {
			case XMLStreamReader.START_ELEMENT:
				String localName = xmlStreamReader.getLocalName();
				switch(localName) {
				case "servlet-name":
					servlet.setServletName(getElementData());
					break;
				case "servlet-class":
					servlet.setServletClass(getElementData());
					break;
				case "init-param":
					InitParam initParam = servlet.addInitParams();
					parseInitParam(initParam);
					break;	
				}
				break;
			case XMLStreamReader.END_ELEMENT:
				if (xmlStreamReader.getLocalName().equals("servlet")) {
					return;
				}
				break;
			}
		}
	}

	private void parseServletMapping(ServletMapping servletMapping) throws XMLStreamException {
		while (xmlStreamReader.hasNext()) {
			int eventType = xmlStreamReader.next();
			switch (eventType) {
			case XMLStreamReader.START_ELEMENT:
				String localName = xmlStreamReader.getLocalName();
				switch(localName) {
				case "servlet-name":
					servletMapping.setServletName(getElementData());
					break;
				case "url-pattern":
					servletMapping.setUrlPattern(getElementData());
					break;
				}
				break;
			case XMLStreamReader.END_ELEMENT:
				if (xmlStreamReader.getLocalName().equals("servlet-mapping")) {
					return;
				}
				break;
			}
		}
	}

	private void parseErrorPage(ErrorPage errorPage) throws XMLStreamException {
		while (xmlStreamReader.hasNext()) {
			int eventType = xmlStreamReader.next();
			switch (eventType) {
			case XMLStreamReader.START_ELEMENT:
				String localName = xmlStreamReader.getLocalName();
				switch(localName) {
				case "exception-type":
					errorPage.setExceptionType(getElementData());
					break;
				case "error-code":
					errorPage.setErrorCode(getElementData());
					break;
				case "location":
					errorPage.setLocation(getElementData());
					break;
				}
				break;
			case XMLStreamReader.END_ELEMENT:
				if (xmlStreamReader.getLocalName().equals("error-page")) {
					return;
				}
				break;
			}
		}
	}

	private void parseInitParam(InitParam initParam) throws XMLStreamException {
		while (xmlStreamReader.hasNext()) {
			int eventType = xmlStreamReader.next();
			switch (eventType) {
			case XMLStreamReader.START_ELEMENT:
				String localName = xmlStreamReader.getLocalName();
				switch(localName) {
				case "param-name":
					initParam.setParamName(getElementData());
					break;
				case "param-value":
					initParam.setParamValue(getElementData());
					break;
				}
				break;
			case XMLStreamReader.END_ELEMENT:
				if (xmlStreamReader.getLocalName().equals("init-param")) {
					return;
				}
				break;
			}
		}
	}

	private String getElementData() throws XMLStreamException {
		StringBuilder stringBuilder = new StringBuilder();
		while (xmlStreamReader.hasNext()) {
			int eventType = xmlStreamReader.next();
			switch (eventType) {
			case XMLStreamReader.CHARACTERS:
				stringBuilder.append(xmlStreamReader.getText());
				break;
			case XMLStreamReader.CDATA:
				stringBuilder.append(xmlStreamReader.getText());
				break;
			case XMLStreamReader.END_ELEMENT:
				return stringBuilder.toString().trim();
			}
		}
		return stringBuilder.toString().trim();
	}
}
