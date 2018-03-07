package sin.glouds.util.oom;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) throws Exception {
		Person person = new Person();
		person.setName("glouds");
		person.setAge("25");
		IdCard idCard = new IdCard();
		idCard.setIdNo("12234");
		idCard.setSex("male");
		person.setIdCard(idCard);
		List<IdCard> idCards = new ArrayList<>();
		idCards.add(new IdCard("chenyb","female"));
		idCards.add(new IdCard("zhujm","female"));
		person.setIdCards(idCards);
		person.setiCards(idCards);
		System.out.println(person.toString());
		for(IdCard idCard2 : person.getIdCards()) {
			System.out.println(idCard2.toString());
		}
		Student student = O2OMapperUtil.mapper(person, Student.class);
		System.out.println(student.toString());
		for(IdCard idCard2 : student.getIdCards()) {
			System.out.println(idCard2.toString());
		}
	}
}

class Person {
	@MapperElement(name = "name")
	private String name;
	@MapperElement(name = "age")
	private String age;
	@MapperElement(name = "idCard",type = MapperElement.TYPE_O2O)
	private IdCard idCard;
	@MapperElement(name = "idCards",type = MapperElement.TYPE_L2L)
	private List<IdCard> idCards;
	@MapperElement(name = "iCard",type = MapperElement.TYPE_FOOL)
	private List<IdCard> iCards;
	
	public String toString() {
		return "person:" + iCards + " " + idCards + " " + this.name + " " + this.age + " " + this.idCard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public IdCard getIdCard() {
		return idCard;
	}

	public void setIdCard(IdCard idCard) {
		this.idCard = idCard;
	}

	public List<IdCard> getIdCards() {
		return idCards;
	}

	public void setIdCards(List<IdCard> idCards) {
		this.idCards = idCards;
	}

	public List<IdCard> getiCards() {
		return iCards;
	}

	public void setiCards(List<IdCard> iCards) {
		this.iCards = iCards;
	}
	
	
}

class Student {
	private String name;
	private String age;
	private IdCard idCard;
	private List<IdCard> idCards;
	private IdCard iCard;
	
	public String toString() {
		return "student:" + idCard + " " + idCards + " " + this.name + " " + this.age + " " + this.idCard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public IdCard getIdCard() {
		return idCard;
	}

	public void setIdCard(IdCard idCard) {
		this.idCard = idCard;
	}

	public List<IdCard> getIdCards() {
		return idCards;
	}

	public void setIdCards(List<IdCard> idCards) {
		this.idCards = idCards;
	}

	public IdCard getiCard() {
		return iCard;
	}

	public void setiCard(IdCard iCard) {
		this.iCard = iCard;
	}
	
	
}

class IdCard {
	@MapperElement(name = "idNo")
	private String idNo;
	@MapperElement(name = "sex")
	private String sex;
	
	public IdCard(String idNo, String sex) {
		this.idNo = idNo;
		this.sex = sex;
	}
	
	public IdCard() {
		
	}
	
	public String toString() {
		return "idcard:" + this.idNo + " " + this.sex + " " + this.hashCode();
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
}
