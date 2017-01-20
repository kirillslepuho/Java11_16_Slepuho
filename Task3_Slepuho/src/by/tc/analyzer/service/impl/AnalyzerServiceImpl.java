package by.tc.analyzer.service.impl;


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.tc.analyzer.bean.entity.NodeInfo;
import by.tc.analyzer.bean.enums.NodeType;
import by.tc.analyzer.dao.AnalyzerDAO;
import by.tc.analyzer.dao.factory.DAOFactory;
import by.tc.analyzer.service.AnalyzerService;


public class AnalyzerServiceImpl implements AnalyzerService {
	
	DAOFactory daoFactory = DAOFactory.getInstance();
    AnalyzerDAO analyzerDAO = daoFactory.getAnalyzerDAO();
	

	private static boolean isTag(String token) {
		Matcher tag = getMatcher("<(([^>]|\n)*)>", token);
		if (tag.find()) {
			return true;
		} else {
			return false;
		}
	}
	
	public NodeInfo getNode(String token){
		NodeInfo nodeInfo = new NodeInfo();
		
		Matcher openTag = getMatcher("<(([^>/]|\n)*)>", token);
		Matcher closeTag = getMatcher("<(/(([^>]|\n)*))>", token);
		
		if(isTag(token)){
			if(openTag.find()){
				nodeInfo.setContent(openTag.group(1));
				nodeInfo.setType(NodeType.Open_Tag);
			}else if(closeTag.find()){
				nodeInfo.setContent(closeTag.group(2));
				nodeInfo.setType(NodeType.Close_Tag);
			}
			
			
		}else{
			nodeInfo.setContent(token);
			nodeInfo.setType(NodeType.TagContent);
		}
		
		
		return nodeInfo;
	}

	public ArrayList<NodeInfo> getNodes(String fileName){
          ArrayList<NodeInfo> nodes = new ArrayList<NodeInfo>();
          ArrayList<String> tokens = analyzerDAO.getTokens(fileName);
          
          for (int i = 0; i < tokens.size(); i++) {
     		NodeInfo nodeInfo = getNode(tokens.get(i));
     		nodes.add(nodeInfo);
     	  }
          
          return nodes;
	}

	private static Matcher getMatcher(String regexp, String path) {
		Pattern regexpn = Pattern.compile(regexp);
		Matcher m = regexpn.matcher(path);
		return m;

	}

}
