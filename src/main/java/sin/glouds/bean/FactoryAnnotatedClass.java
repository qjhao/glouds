package sin.glouds.bean;

import javax.lang.model.element.TypeElement;

public class FactoryAnnotatedClass {
	
	private TypeElement annotatedClassElement;
	private String qualifiedSuperClassName;
	private String simpleTypeName;
	private String id;
	public TypeElement getAnnotatedClassElement() {
		return annotatedClassElement;
	}
	public void setAnnotatedClassElement(TypeElement annotatedClassElement) {
		this.annotatedClassElement = annotatedClassElement;
	}
	public String getQualifiedSuperClassName() {
		return qualifiedSuperClassName;
	}
	public void setQualifiedSuperClassName(String qualifiedSuperClassName) {
		this.qualifiedSuperClassName = qualifiedSuperClassName;
	}
	public String getSimpleTypeName() {
		return simpleTypeName;
	}
	public void setSimpleTypeName(String simpleTypeName) {
		this.simpleTypeName = simpleTypeName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
