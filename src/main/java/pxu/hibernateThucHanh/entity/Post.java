package pxu.hibernateThucHanh.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Post")
public class Post {
	@Id // khoá chính
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "content")
	private String content;

	@Column(name = "likes")
	private int likes;

	@Column(name = "published_on")
	private Date published_on;

	@Column(name = "title")
	private String title;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Category_id", referencedColumnName = "id")
	private Category category;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	// 1-n với comment
	@OneToMany(mappedBy = "post")
	List<Comment> comments = new ArrayList<Comment>();

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Author_id", referencedColumnName = "id")
	private Author author;

	// n-n với tag
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "post_tag", joinColumns = { @JoinColumn(name = "post_id") }, inverseJoinColumns = {
			@JoinColumn(name = "tag_id") })

	private Set<Tag> tag = new HashSet<>();

	public Set<Tag> getTag() {
		return tag;
	}

	public Post(int id, String content, int likes, Date published_on, String title, Category category, Author author,
			Set<Tag> tag) {
		super();
		this.id = id;
		this.content = content;
		this.likes = likes;
		this.published_on = published_on;
		this.title = title;
		this.category = category;
		this.author = author;
		this.tag = tag;
	}

	public Post() {
		super();
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Post(int id, String content, int likes, Date published_on, String title) {
		super();
		this.id = id;
		this.content = content;
		this.likes = likes;
		this.published_on = published_on;
		this.title = title;
	}

	public void setTag(Set<Tag> tag) {
		this.tag = tag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public Date getPublished_on() {
		return published_on;
	}

	public void setPublished_on(Date published_on) {
		this.published_on = published_on;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
