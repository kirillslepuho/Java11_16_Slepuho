package by.tc.analyzer.bean.enums;

public enum NodeType {
Open_Tag,Close_Tag,TagContent;

public String getStringType(){
	if(this.equals(Open_Tag)){
		return "����������� ���";
	}else if(this.equals(Close_Tag)){
		return "����������� ���";
	}else{
		return "����������";
	}
	
}
}
