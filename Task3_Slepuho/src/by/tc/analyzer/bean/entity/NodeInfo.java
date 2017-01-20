package by.tc.analyzer.bean.entity;

import by.tc.analyzer.bean.enums.NodeType;

public class NodeInfo {
private String content;
private NodeType type;

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



}
