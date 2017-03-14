package by.tc.analyzer.service.impl;


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.tc.analyzer.bean.entity.Attribute;
import by.tc.analyzer.bean.entity.NodeInfo;
import by.tc.analyzer.bean.enums.NodeType;
import by.tc.analyzer.dao.AnalyzerDAO;
import by.tc.analyzer.dao.exception.DAOException;
import by.tc.analyzer.dao.factory.DAOFactory;
import by.tc.analyzer.service.AnalyzerService;
import by.tc.analyzer.service.exception.ServiceException;


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
		Matcher nameTag = getMatcher("<(([^>?=])*)( |>)",token);
		
		if(isTag(token)){
			if(openTag.find() && nameTag.find()){
				
				nodeInfo.setContent(nameTag.group(1));
				nodeInfo.setType(NodeType.Open_Tag);
				nodeInfo.setAttributes(getAttributes(openTag.group(1)));
				
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

	public ArrayList<NodeInfo> getNodes(String fileName) throws ServiceException{
          ArrayList<NodeInfo> nodes = new ArrayList<NodeInfo>();
          
          ArrayList<String> tokens;
		try {
			tokens = analyzerDAO.getTokens(fileName);
		} catch (DAOException e) {
            throw new ServiceException(e);
		}
          
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
	
	private static ArrayList<Attribute> getAttributes(String token){
		Matcher attributeMatcher = getMatcher("[ ](.*?)=(['\"])(.*?)\\2",token);
		ArrayList<Attribute> attributes = new ArrayList<Attribute>();

		while(attributeMatcher.find()){
			Attribute attribute = new Attribute();
            attribute.setName(attributeMatcher.group(1));
            attribute.setData(attributeMatcher.group(3));
            attributes.add(attribute);
		}
		
		return attributes;
		
	}

}
