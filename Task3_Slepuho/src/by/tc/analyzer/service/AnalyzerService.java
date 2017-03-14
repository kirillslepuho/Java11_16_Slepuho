package by.tc.analyzer.service;

import java.util.ArrayList;

import by.tc.analyzer.bean.entity.NodeInfo;
import by.tc.analyzer.service.exception.ServiceException;

public interface AnalyzerService {
	public ArrayList<NodeInfo> getNodes(String fileName) throws ServiceException;
}
