package sin.glouds.entity.sins;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "novel")
public class Novel {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "id")
	private Integer id;
	@Column(name = "title")
	private String title;
	@Column(name = "url")
	private String url;
	@Column(name = "author")
	private String author;
	@Column(name = "length")
	private String length;
	@Column(name = "date")
	private String date;
	@Column(name = "status")
	private String status;
	@Column(name = "path")
	private String path;
	@Column(name = "description")
	private String description;
	@Column(name = "desc_url")
	private String descUrl;
	@Column(name = "type")
	private String type;
	@Column(name = "site")
	private String site;

	public Novel () {
	
	}
	public Integer getId() {
		return this.id;
	}
	public Novel setId(Integer id ) {
		this.id = id;
		return this;
	}
	public String getTitle() {
		return this.title;
	}
	public Novel setTitle(String title ) {
		this.title = title;
		return this;
	}
	public String getUrl() {
		return this.url;
	}
	public Novel setUrl(String url ) {
		this.url = url;
		return this;
	}
	public String getAuthor() {
		return this.author;
	}
	public Novel setAuthor(String author ) {
		this.author = author;
		return this;
	}
	public String getLength() {
		return this.length;
	}
	public Novel setLength(String length ) {
		this.length = length;
		return this;
	}
	public String getDate() {
		return this.date;
	}
	public Novel setDate(String date ) {
		this.date = date;
		return this;
	}
	public String getStatus() {
		return this.status;
	}
	public Novel setStatus(String status ) {
		this.status = status;
		return this;
	}
	public String getPath() {
		return this.path;
	}
	public Novel setPath(String path ) {
		this.path = path;
		return this;
	}
	public String getDescription() {
		return this.description;
	}
	public Novel setDescription(String description ) {
		this.description = description;
		return this;
	}
	public String getDescUrl() {
		return this.descUrl;
	}
	public Novel setDescUrl(String descUrl ) {
		this.descUrl = descUrl;
		return this;
	}
	public String getType() {
		return this.type;
	}
	public Novel setType(String type ) {
		this.type = type;
		return this;
	}
	public String getSite() {
		return this.site;
	}
	public Novel setSite(String site ) {
		this.site = site;
		return this;
	}

}
