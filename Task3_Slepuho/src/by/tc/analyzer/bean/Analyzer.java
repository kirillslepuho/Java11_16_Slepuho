package by.tc.analyzer.bean;


import java.util.ArrayList;
import java.util.List;



import by.tc.analyzer.bean.entity.NodeInfo;
import by.tc.analyzer.service.AnalyzerService;
import by.tc.analyzer.service.factory.ServiceFactory;

public class Analyzer {
	
ServiceFactory serviceFactory = ServiceFactory.getInstance();
AnalyzerService analyzerService = serviceFactory.getAnalyzerService();
	
private String fileName;


public Analyzer(String fileName) {
	this.fileName = fileName;
}

public Analyzer(){
	
}

public String getFileName() {
	return fileName;
}


public void setFileName(String fileName) {
	this.fileName = fileName;
}

public List<NodeInfo> getList() {
	ArrayList<NodeInfo> nodes = analyzerService.getNodes(fileName);
	return nodes;
}







}
