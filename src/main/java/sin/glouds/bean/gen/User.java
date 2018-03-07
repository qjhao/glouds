package sin.glouds.bean.gen;

import java.util.List;

public class User {

	private List<Book> books;
	private String name;
	private Brother brother;
	private String isDel;
	private Integer age;
	private Boolean male;
	private Double sal;

	public List<Book> getBook() {
		return books;
	}
	public void setBook(List<Book>books) {
		this.books = books;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Brother getBrother() {
		return brother;
	}
	public void setBrother(Brother brother) {
		this.brother = brother;
	}
	public String getIsDel() {
		return isDel;
	}
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Boolean getMale() {
		return male;
	}
	public void setMale(Boolean male) {
		this.male = male;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
}