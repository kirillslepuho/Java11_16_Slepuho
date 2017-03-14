package by.tc.analyzer.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



import by.tc.analyzer.bean.Analyzer;
import by.tc.analyzer.bean.entity.Attribute;
import by.tc.analyzer.bean.entity.NodeInfo;
import by.tc.analyzer.service.exception.ServiceException;

public class Main {

	public static void main(String[] args) {
	
		Analyzer a = new Analyzer();
		a.setFileName("res//breakfastMenu.xml");
		
		List<NodeInfo> nodes = null;
		try {
			nodes = a.getList();
		} catch (ServiceException e) {
            System.err.println(e.getMessage());
		}
		Iterator<NodeInfo> nodesIterator = nodes.iterator();
		while(nodesIterator.hasNext()){
			NodeInfo nodeInfo = nodesIterator.next();
			System.out.println(nodeInfo.getContent()+ " - " + nodeInfo.getType());
			
				ArrayList<Attribute> attributes = nodeInfo.getAttributes();
				Iterator<Attribute> attributesIterator = attributes.iterator();
				
				while(attributesIterator.hasNext()){
					Attribute attribute = attributesIterator.next();
					System.out.println("Attribute:" + attribute.getName() + " = " + attribute.getData());				
				}
				
		}

	}

}
