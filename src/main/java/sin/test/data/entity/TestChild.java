package sin.test.data.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "test_child")
public class TestChild {

	@Id
	@GeneratedValue
	private Integer id;
	private String title;
	private boolean flag;
	private Date createDate;
	private Double someNumber;
	@OneToOne(mappedBy = "testChild")
	private TestParent testParent;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Double getSomeNumber() {
		return someNumber;
	}

	public void setSomeNumber(Double someNumber) {
		this.someNumber = someNumber;
	}

	public TestParent getTestParent() {
		return testParent;
	}

	public void setTestParent(TestParent testParent) {
		this.testParent = testParent;
	}

}
