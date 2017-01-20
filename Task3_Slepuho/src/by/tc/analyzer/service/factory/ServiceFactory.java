package by.tc.analyzer.service.factory;

import by.tc.analyzer.service.AnalyzerService;
import by.tc.analyzer.service.impl.AnalyzerServiceImpl;

public class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();

	private ServiceFactory() {
	}
	
	private AnalyzerService analyzerService = new AnalyzerServiceImpl();
	

	public AnalyzerService getAnalyzerService() {
		return analyzerService;
	}

	public static ServiceFactory getInstance() {
		return instance;
	}
}
