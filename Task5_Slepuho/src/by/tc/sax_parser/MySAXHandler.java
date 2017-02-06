package by.tc.sax_parser;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import by.tc.sax_parser.xmlstruct.ErrorPage;
import by.tc.sax_parser.xmlstruct.Filter;
import by.tc.sax_parser.xmlstruct.FilterMapping;
import by.tc.sax_parser.xmlstruct.InitParam;
import by.tc.sax_parser.xmlstruct.Listener;
import by.tc.sax_parser.xmlstruct.Servlet;
import by.tc.sax_parser.xmlstruct.ServletMapping;
import by.tc.sax_parser.xmlstruct.WebApp;
import by.tc.sax_parser.xmlstruct.WelcomeFileList;

import org.xml.sax.SAXException;

public class MySAXHandler extends DefaultHandler {

	private WebApp webApp = new WebApp();
	private WelcomeFileList welcomeFileList;
	private Filter filter;
	private FilterMapping filterMapping;
	private Listener listener;
	private Servlet servlet;
	private ServletMapping servletMapping;
	private ErrorPage errorPage;
	private InitParam initParam;
	private String filterName;
	private String urlPattern;
	private String servletName;

	private int currentNesting = 0;
	private StringBuilder text;

	public WebApp getWebApp() {
		return webApp;
	}

	@Override
	public void startDocument() throws SAXException {

	}

	@Override
	public void startElement(String namespaceURI, String localName,
			String combinationName, Attributes attributes) throws SAXException {
		OutputHandler.printNode(combinationName, currentNesting);
		OutputHandler.printAttributes(attributes);
		currentNesting++;
		
		text = new StringBuilder();
		switch(combinationName){
		case "web-app":
			webApp.setId(attributes.getValue("id"));
			webApp.setVersion(attributes.getValue("version"));
			break;
		case "welcome-file-list":
			welcomeFileList = new WelcomeFileList();
			break;
		case "filter":
			filter = new Filter(); 
			break;
		case "filter-mapping":
			filterMapping = new FilterMapping();
			break;
		case "listener":
			listener = new Listener();
			break;
		case "servlet":
			servlet = new Servlet();
			break;
		case "servlet-mapping":
			servletMapping = new ServletMapping();
			break;
		case "error-page":
			errorPage = new ErrorPage();
			break;
		case "init-param":
			initParam = new InitParam();
			break;
		}

	}

	@Override
	public void characters(char[] data, int start, int length) throws SAXException {
		currentNesting--;
		OutputHandler.printNodeValue(data, start, length, currentNesting);
		currentNesting++;

		text.append(data,start,length);
	}

	@Override
	public void endElement(String namespaceURI, String localName,String combinationName) throws SAXException {
		currentNesting--;

		switch(combinationName){
		case "display-name":
			webApp.setDisplayName(text.toString());
			break;
		case "welcome-file":
			welcomeFileList.addWelcomeFile(text.toString());
			break;
		case "welcome-file-list":
			webApp.addElement(welcomeFileList);
			break;
		case "filter":
			filter.setFilterName(filterName);
			filter.addInitParams(initParam);
			webApp.addElement(filter);
			filterName = null;
			break;
		case "filter-name":
			filterName = new String(text.toString());
			break;
		case "filter-class":
			filter.setFilterClass(text.toString());
			break;
		case "param-name":
			initParam.setParamName(text.toString());
			break;
		case "param-value":
			initParam.setParamValue(text.toString());
			break;
		case "url-pattern":
			urlPattern = new String(text.toString());
			break;
		case "dispatcher":
			filterMapping.setDispatcher(text.toString());
			break;
		case "filter-mapping":
			filterMapping.setFilterName(filterName);
			filterMapping.setUrlPattern(urlPattern);
			webApp.addElement(filterMapping);
			filterName = null;
			urlPattern = null;
			break;
		case "listener-class":
			listener.setListenerClass(text.toString());
			break;	
		case "listener":
			webApp.addElement(listener);
			break;
		case "servlet-name":
			servletName = new String(text.toString());
			break;
		case "servlet-class":
			servlet.setServletClass(text.toString());
			break;
		case "servlet":
			servlet.setServletName(servletName);
			servlet.addInitParams(initParam);
			webApp.addElement(servlet);
			servletName = null;
			break;
		case "servlet-mapping":
			servletMapping.setServletName(servletName);
			servletMapping.setUrlPattern(urlPattern);
			webApp.addElement(servletMapping);
			servletName = null;
			urlPattern = null;
			break;
		case "exception-type":
			errorPage.setExceptionType(text.toString());
			break;
		case "error-code":
			errorPage.setErrorCode(text.toString());
			break;
		case "location":
			errorPage.setLocation(text.toString());
			break;
		case "error-page":
			webApp.addElement(errorPage);
			break;
		}
	}


	@Override
	public void endDocument() {

	}
}
