package by.tc.analyzer.service;

import java.util.ArrayList;

import by.tc.analyzer.bean.entity.NodeInfo;

public interface AnalyzerService {
	public ArrayList<NodeInfo> getNodes(String fileName);
}
