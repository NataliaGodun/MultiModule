package by.htp.main.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="newstable")
public class News implements Serializable{

	private static final String ID="id";
	private static final String TITLE="title";
	private static final String DATE="date";
	private static final String BRIEF="brief";
	private static final String CONTENT="content";
	private static final String STATUS="status";
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name=ID)
	private int id;
	
	@Column(name=TITLE)
	private String newsTitle;
	
	@Column(name=DATE)
	private Date newsDate;
	
	@Column(name=BRIEF)
	private String brief;
	
	@Column(name=CONTENT)
	private String content;
	
	@Column(name=STATUS)
	private String status;
	
	public News() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public Date getNewsDate() {
		return newsDate;
	}

	public void setNewsDate(Date newsDate) {
		this.newsDate = newsDate;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brief == null) ? 0 : brief.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + id;
		result = prime * result + ((newsDate == null) ? 0 : newsDate.hashCode());
		result = prime * result + ((newsTitle == null) ? 0 : newsTitle.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		News other = (News) obj;
		if (brief == null) {
			if (other.brief != null)
				return false;
		} else if (!brief.equals(other.brief))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (id != other.id)
			return false;
		if (newsDate == null) {
			if (other.newsDate != null)
				return false;
		} else if (!newsDate.equals(other.newsDate))
			return false;
		if (newsTitle == null) {
			if (other.newsTitle != null)
				return false;
		} else if (!newsTitle.equals(other.newsTitle))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "News [id=" + id + ", newsTitle=" + newsTitle + ", newsDate=" + newsDate + ", brief=" + brief +", content=" + content+ "]";
	}
		
}





