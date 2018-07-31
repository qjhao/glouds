//package sin.glouds.entity.test;
//
//import java.util.Date;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "test_parent")
//public class TestParent {
//
//	@Id
//	@GeneratedValue
//	private Integer id;
//	private String title;
//	private boolean flag;
//	private Date createDate;
//	private Double someNumber;
//	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
//	@JoinColumn(name="testChild")
//	private TestChild testChild;
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public boolean isFlag() {
//		return flag;
//	}
//
//	public void setFlag(boolean flag) {
//		this.flag = flag;
//	}
//
//	public Date getCreateDate() {
//		return createDate;
//	}
//
//	public void setCreateDate(Date createDate) {
//		this.createDate = createDate;
//	}
//
//	public Double getSomeNumber() {
//		return someNumber;
//	}
//
//	public void setSomeNumber(Double someNumber) {
//		this.someNumber = someNumber;
//	}
//
//	public TestChild getTestChild() {
//		return testChild;
//	}
//
//	public void setTestChild(TestChild testChild) {
//		this.testChild = testChild;
//	}
//
//}
