package in.xgen.web.profile.user.domain;

import java.util.Date;

import javax.persistence.Entity;

@Entity

public abstract class ContentVO {

	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	public Integer getContentSize() {
		return contentSize;
	}
	public void setContentSize(Integer contentSize) {
		this.contentSize = contentSize;
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	private String name;
	
	private Date uploadDate;
	private Integer contentSize;
	
	private String path;
	   
}
