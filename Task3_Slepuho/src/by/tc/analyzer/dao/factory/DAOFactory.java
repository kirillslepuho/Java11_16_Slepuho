package by.tc.analyzer.dao.factory;

import by.tc.analyzer.dao.AnalyzerDAO;

import by.tc.analyzer.dao.impl.AnalyzerDAOImpl;

public class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();

	private DAOFactory() {
	}
	
	private AnalyzerDAO analyzerDAO = new AnalyzerDAOImpl();
	

	public AnalyzerDAO getAnalyzerDAO() {
		return analyzerDAO;
	}

	public static DAOFactory getInstance() {
		return instance;
	}
}
