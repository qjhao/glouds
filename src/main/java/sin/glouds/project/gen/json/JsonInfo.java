package sin.glouds.project.gen.json;

import java.util.List;

public class JsonInfo {

	private boolean root;
	private String name;
	private String value;
	private Type type;
	private ValueType valueType;
	private List<JsonInfo> infos;
	public boolean isRoot() {
		return root;
	}
	public void setRoot(boolean root) {
		this.root = root;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public ValueType getValueType() {
		return valueType;
	}
	public void setValueType(ValueType valueType) {
		this.valueType = valueType;
	}
	public List<JsonInfo> getInfos() {
		return infos;
	}
	public void setInfos(List<JsonInfo> infos) {
		this.infos = infos;
	}
	@Override
	public String toString() {
		return "JsonInfo [root=" + root + ", name=" + name + ", value=" + value + ", type=" + type + ", valueType="
				+ valueType + ", infos=" + infos + "]";
	}
	
}
