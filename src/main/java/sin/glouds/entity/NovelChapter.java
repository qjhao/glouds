package sin.glouds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "novel_chapter")
public class NovelChapter {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "id")
	private Integer id;
	@Column(name = "novel_id")
	private Integer novelId;
	@Column(name = "title")
	private String title;
	@Column(name = "content")
	private String content;
	@Column(name = "url")
	private String url;
	@Column(name = "chapter_index")
	private Integer chapterIndex;

	public NovelChapter () {
	
	}
	public Integer getId() {
		return this.id;
	}
	public NovelChapter setId(Integer id ) {
		this.id = id;
		return this;
	}
	public Integer getNovelId() {
		return this.novelId;
	}
	public NovelChapter setNovelId(Integer novelId ) {
		this.novelId = novelId;
		return this;
	}
	public String getTitle() {
		return this.title;
	}
	public NovelChapter setTitle(String title ) {
		this.title = title;
		return this;
	}
	public String getContent() {
		return this.content;
	}
	public NovelChapter setContent(String content ) {
		this.content = content;
		return this;
	}
	public String getUrl() {
		return this.url;
	}
	public NovelChapter setUrl(String url ) {
		this.url = url;
		return this;
	}
	public Integer getChapterIndex() {
		return this.chapterIndex;
	}
	public NovelChapter setChapterIndex(Integer chapterIndex ) {
		this.chapterIndex = chapterIndex;
		return this;
	}

}
