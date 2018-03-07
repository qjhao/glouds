package sin.glouds.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "movie")
public class Movie {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "url")
	private String url;
	@Column(name = "create_date")
	private Date createDate;
	@Column(name = "description")
	private String desc;
	@Column(name = "reschedule_date")
	private String rescheduleDate;
	@Column(name = "director")
	private String director;
	@Column(name = "title")
	private String title;
	@Column(name = "translation")
	private String translation;
	@Column(name = "language")
	private String language;
	@Column(name = "type")
	private String type;
	@Column(name = "subtitle")
	private String subtitle;
	@Column(name = "length")
	private String length;
	@Column(name = "score")
	private String score;
	@Column(name = "actors")
	private String actors;
	@Column(name = "country")
	private String country;

	public Movie() {
	}

	public Integer getId() {
		return this.id;
	}

	public Movie setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return this.name;
	}

	public Movie setName(String name) {
		this.name = name;
		return this;
	}

	public String getUrl() {
		return this.url;
	}

	public Movie setUrl(String url) {
		this.url = url;
		return this;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public Movie setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}

	public String getDesc() {
		return this.desc;
	}

	public Movie setDesc(String desc) {
		this.desc = desc;
		return this;
	}

	public String getRescheduleDate() {
		return this.rescheduleDate;
	}

	public Movie setRescheduleDate(String rescheduleDate) {
		this.rescheduleDate = rescheduleDate;
		return this;
	}

	public String getDirector() {
		return this.director;
	}

	public Movie setDirector(String director) {
		this.director = director;
		return this;
	}

	public String getTitle() {
		return this.title;
	}

	public Movie setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getTranslation() {
		return this.translation;
	}

	public Movie setTranslation(String translation) {
		this.translation = translation;
		return this;
	}

	public String getLanguage() {
		return this.language;
	}

	public Movie setLanguage(String language) {
		this.language = language;
		return this;
	}

	public String getType() {
		return this.type;
	}

	public Movie setType(String type) {
		this.type = type;
		return this;
	}

	public String getSubtitle() {
		return this.subtitle;
	}

	public Movie setSubtitle(String subtitle) {
		this.subtitle = subtitle;
		return this;
	}

	public String getLength() {
		return this.length;
	}

	public Movie setLength(String length) {
		this.length = length;
		return this;
	}

	public String getScore() {
		return this.score;
	}

	public Movie setScore(String score) {
		this.score = score;
		return this;
	}

	public String getActors() {
		return this.actors;
	}

	public Movie setActors(String actors) {
		this.actors = actors;
		return this;
	}

	public String getCountry() {
		return this.country;
	}

	public Movie setCountry(String country) {
		this.country = country;
		return this;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", url=" + url + ", createDate=" + createDate + ", desc=" + desc
				+ ", rescheduleDate=" + rescheduleDate + ", director=" + director + ", title=" + title
				+ ", translation=" + translation + ", language=" + language + ", type=" + type + ", subtitle="
				+ subtitle + ", length=" + length + ", score=" + score + ", actors=" + actors + ", country=" + country
				+ "]";
	}

}
