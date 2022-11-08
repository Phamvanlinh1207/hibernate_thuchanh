package pxu.hibernateThucHanh.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Comment")
public class Comment {

	@Id //khoá chính
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="id")
	private int id;
	
	@Column(name="commented_on")
	private Date commented_on;
	
	@Column(name="content")
	private String content;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Post_id", referencedColumnName = "id")
	private Post post;
	

	public Comment() {
		super();
	}

	public Comment(int id, Date commented_on, String content) {
		super();
		this.id = id;
		this.commented_on = commented_on;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCommented_on() {
		return commented_on;
	}

	public void setCommented_on(Date commented_on) {
		this.commented_on = commented_on;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	

}
