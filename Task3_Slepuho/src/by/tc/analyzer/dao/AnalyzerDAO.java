package by.tc.analyzer.dao;

import java.util.ArrayList;

import by.tc.analyzer.dao.exception.DAOException;

public interface AnalyzerDAO {
public ArrayList<String> getTokens(String fileName) throws DAOException;

}
