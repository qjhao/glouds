package sin.glouds.project.jdao.entity;

import java.util.Date;

import sin.glouds.project.jdao.annotation.Row;

public class Movie {

	@Row
	private String name;
	@Row
	private String url;
	@Row
	private Date createDate;
	@Row
	private String desc;
	@Row
	private String rescheduleDate;
	@Row
	private String director;
	@Row
	private String title;
	@Row
	private String translation;
	@Row
	private String language;
	@Row
	private String type;
	@Row
	private String subtitle;
	@Row
	private String length;
	@Row
	private String score;
	@Row
	private String actors;
	@Row
	private String country;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getRescheduleDate() {
		return rescheduleDate;
	}

	public void setRescheduleDate(String rescheduleDate) {
		this.rescheduleDate = rescheduleDate;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Movie [name=" + name + ", url=" + url + ", createDate=" + createDate + ", desc=" + desc
				+ ", rescheduleDate=" + rescheduleDate + ", director=" + director + ", title=" + title
				+ ", translation=" + translation + ", language=" + language + ", type=" + type + ", subtitle="
				+ subtitle + ", length=" + length + ", score=" + score + ", actors=" + actors + ", country=" + country
				+ "]";
	}

}
