package by.tc.analyzer.bean.entity;

import java.util.ArrayList;

import by.tc.analyzer.bean.enums.NodeType;

public class NodeInfo {
	private String content;
	private NodeType type;
	private ArrayList<Attribute> attributes;


	public NodeInfo() {
		attributes = new ArrayList<Attribute>(0);
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type.getStringType();
	}
	public void setType(NodeType type) {
		this.type = type;
	}

	public void addAttribute(Attribute attribute) {
		attributes.add(attribute);
	}
	
	public void setAttributes(ArrayList<Attribute> attributes) {
		this.attributes = attributes;
	}
	
	public ArrayList<Attribute> getAttributes() {
		return attributes;
	}

    

}
