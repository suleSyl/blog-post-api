package com.zenigma.blogpostapi.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "POST", schema = "BLOG")
public class Post {	
	
	@Id @GeneratedValue
	@Column(name="id")
	private int id;
	
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "AuthorId", referencedColumnName = "id", nullable = true)
	@ManyToOne(optional = false)               
	@JsonIgnoreProperties({"postsAuthoredList"})
	private Author authorId = new Author();
	
	@Column(name="NumberOfReaders")
	private Integer numberOfReaders = null;
	
	@Column(name="PostHeader")
	private String postHeader = null;
	
	@Column(name="PostBody")
	private String postBody = null;
	
	@Column(name="AdditionalInfo")
	private String additionalInfo = null;
	
	@Column(name="CreationDateTime")
	private LocalDateTime creationDateTime = null;
	
	@Column(name="ModificationDateTime")
	private LocalDateTime modificationDateTime = null;
	
	@Column(name="IsActive")
	private Boolean isActive = null;
	
	public Post() {		
	}
	
	public Post(Author authorId, String postHeader, String postBody) {
		this.creationDateTime = LocalDateTime.now();
		this.authorId = authorId;
		this.postHeader = postHeader;
		this.postBody = postBody;
	}	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Author getAuthorId() {
		return authorId;
	}
	
	public void setAuthorId(Author authorId) {
		this.authorId = authorId;
	}
	
	public Integer getNumberOfReaders() {
		return numberOfReaders;
	}
	
	public void setNumberOfReaders(Integer numberOfReaders) {
		this.numberOfReaders = numberOfReaders;
	}
	
	public String getPostHeader() {
		return postHeader;
	}
	
	public void setPostHeader(String postHeader) {
		this.postHeader = postHeader;
	}
	
	public String getPostBody() {
		return postBody;
	}
	
	public void setPostBody(String postBody) {
		this.postBody = postBody;
	}
	
	public String getAdditionalInfo() {
		return additionalInfo;
	}
	
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	
	public LocalDateTime getCreationDateTime() {
		return creationDateTime;
	}
	
	public void setCreationDateTime(LocalDateTime creationDateTime) {
		this.creationDateTime = creationDateTime;
	}
	
	public LocalDateTime getModificationDateTime() {
		return modificationDateTime;
	}
	
	public void setModificationDateTime(LocalDateTime modificationDateTime) {
		this.modificationDateTime = modificationDateTime;
	}
	
	public Boolean getIsActive() {
		return isActive;
	}
	
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
}
