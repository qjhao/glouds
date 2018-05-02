package sin.glouds.project.gen.table.bean;

public class Row {
	private String colName;
	private String propName;
	private String colType;
	private String propType;
	private Integer colLength;
	private Integer propLength;
	private boolean primaryKey;
	private String pkGenType;
	private boolean foreignKey;
	private String fkMapperType;
	private boolean encryption;
	private String encrypType;
	private String salt;
	public String getColName() {
		return colName;
	}
	public void setColName(String colName) {
		this.colName = colName;
	}
	public String getPropName() {
		return propName;
	}
	public void setPropName(String propName) {
		this.propName = propName;
	}
	public String getColType() {
		return colType;
	}
	public void setColType(String colType) {
		this.colType = colType;
	}
	public String getPropType() {
		return propType;
	}
	public void setPropType(String propType) {
		this.propType = propType;
	}
	public Integer getColLength() {
		return colLength;
	}
	public void setColLength(Integer colLength) {
		this.colLength = colLength;
	}
	public Integer getPropLength() {
		return propLength;
	}
	public void setPropLength(Integer propLength) {
		this.propLength = propLength;
	}
	public boolean isPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(boolean primaryKey) {
		this.primaryKey = primaryKey;
	}
	public String getPkGenType() {
		return pkGenType;
	}
	public void setPkGenType(String pkGenType) {
		this.pkGenType = pkGenType;
	}
	public boolean isForeignKey() {
		return foreignKey;
	}
	public void setForeignKey(boolean foreignKey) {
		this.foreignKey = foreignKey;
	}
	public String getFkMapperType() {
		return fkMapperType;
	}
	public void setFkMapperType(String fkMapperType) {
		this.fkMapperType = fkMapperType;
	}
	public boolean isEncryption() {
		return encryption;
	}
	public void setEncryption(boolean encryption) {
		this.encryption = encryption;
	}
	public String getEncrypType() {
		return encrypType;
	}
	public void setEncrypType(String encrypType) {
		this.encrypType = encrypType;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	@Override
	public String toString() {
		return "Row [colName=" + colName + ", propName=" + propName + ", colType=" + colType + ", propType=" + propType
				+ ", colLength=" + colLength + ", propLength=" + propLength + ", primaryKey=" + primaryKey
				+ ", pkGenType=" + pkGenType + ", foreignKey=" + foreignKey + ", fkMapperType=" + fkMapperType
				+ ", encryption=" + encryption + ", encrypType=" + encrypType + ", salt=" + salt + "]";
	}
	
	
}
