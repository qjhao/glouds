package sin.glouds.gen.table.bean;

public class ForeignKey {
	private String pktableCat;
	private String pktableSchem;
	private String pktableName;
	private String pkcolumnName;
	private String fktableCat;
	private String fktableSchem;
	private String fktableName;
	private String fkcolumnName;
	private Short keySeq;
	private Short updateRule;
	private Short deleteRule;
	private String pkName;
	private String fkName;
	private Short deferrability;
	public String getPktableCat() {
		return pktableCat;
	}
	public void setPktableCat(String pktableCat) {
		this.pktableCat = pktableCat;
	}
	public String getPktableSchem() {
		return pktableSchem;
	}
	public void setPktableSchem(String pktableSchem) {
		this.pktableSchem = pktableSchem;
	}
	public String getPktableName() {
		return pktableName;
	}
	public void setPktableName(String pktableName) {
		this.pktableName = pktableName;
	}
	public String getPkcolumnName() {
		return pkcolumnName;
	}
	public void setPkcolumnName(String pkcolumnName) {
		this.pkcolumnName = pkcolumnName;
	}
	public String getFktableCat() {
		return fktableCat;
	}
	public void setFktableCat(String fktableCat) {
		this.fktableCat = fktableCat;
	}
	public String getFktableSchem() {
		return fktableSchem;
	}
	public void setFktableSchem(String fktableSchem) {
		this.fktableSchem = fktableSchem;
	}
	public String getFktableName() {
		return fktableName;
	}
	public void setFktableName(String fktableName) {
		this.fktableName = fktableName;
	}
	public String getFkcolumnName() {
		return fkcolumnName;
	}
	public void setFkcolumnName(String fkcolumnName) {
		this.fkcolumnName = fkcolumnName;
	}
	public Short getKeySeq() {
		return keySeq;
	}
	public void setKeySeq(Short keySeq) {
		this.keySeq = keySeq;
	}
	public Short getUpdateRule() {
		return updateRule;
	}
	public void setUpdateRule(Short updateRule) {
		this.updateRule = updateRule;
	}
	public Short getDeleteRule() {
		return deleteRule;
	}
	public void setDeleteRule(Short deleteRule) {
		this.deleteRule = deleteRule;
	}
	public String getPkName() {
		return pkName;
	}
	public void setPkName(String pkName) {
		this.pkName = pkName;
	}
	public String getFkName() {
		return fkName;
	}
	public void setFkName(String fkName) {
		this.fkName = fkName;
	}
	public Short getDeferrability() {
		return deferrability;
	}
	public void setDeferrability(Short deferrability) {
		this.deferrability = deferrability;
	}
	@Override
	public String toString() {
		return "ForeignKey [pktableCat=" + pktableCat + ", pktableSchem=" + pktableSchem + ", pktableName="
				+ pktableName + ", pkcolumnName=" + pkcolumnName + ", fktableCat=" + fktableCat + ", fktableSchem="
				+ fktableSchem + ", fktableName=" + fktableName + ", fkcolumnName=" + fkcolumnName + ", keySeq="
				+ keySeq + ", updateRule=" + updateRule + ", deleteRule=" + deleteRule + ", pkName=" + pkName
				+ ", fkName=" + fkName + ", deferrability=" + deferrability + "]";
	}
	
}
