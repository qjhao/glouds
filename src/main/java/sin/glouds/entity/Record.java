package sin.glouds.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "record")
public class Record {

	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "create_date")
	private Date createDate;
	@Column(name = "content")
	private String content;
	@Column(name = "type")
	private String type;

	public Integer getId() {
		return this.id;
	}
	public Record setId(Integer id ) {
		this.id = id;
		return this;
	}
	public Integer getUserId() {
		return this.userId;
	}
	public Record setUserId(Integer userId ) {
		this.userId = userId;
		return this;
	}
	public String getUserName() {
		return this.userName;
	}
	public Record setUserName(String userName ) {
		this.userName = userName;
		return this;
	}
	public Date getCreateDate() {
		return this.createDate;
	}
	public Record setCreateDate(Date createDate ) {
		this.createDate = createDate;
		return this;
}
	public String getContent() {
		return this.content;
	}
	public Record setContent(String content ) {
		this.content = content;
		return this;
	}
	public String getType() {
		return this.type;
	}
	public Record setType(String type ) {
		this.type = type;
		return this;
	}

}
