package com.zenigma.blogpostapi.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "POST", schema = "BLOG")
public class Post {	
	
	@Id @GeneratedValue
	@Column(name="ID")
	private Long id;
	
	@JoinColumn(name = "AuthorId", referencedColumnName = "ID", nullable = false)
	@ManyToOne(optional = false)               
	@JsonIgnoreProperties({"postsAuthoredList"})
	private Author authorId = new Author();
	
	@Column(name="NumberOfReaders")
	private int numberOfReaders = 0;
	
	@Column(name="PostHeader")
	private String postHeader;
	
	@Column(name="PostBody")
	private String postBody;
	
	@Column(name="AdditionalInfo")
	private String additionalInfo;
	
	@Column(name="CreationDateTime")
	private LocalDateTime creationDateTime;
	
	@Column(name="ModificationDateTime")
	private LocalDateTime modificationDateTime;
	
	@Column(name="IsActive")
	private Boolean isActive;
	
	public Post(Author authorId, String postHeader, String postBody) {
		this.creationDateTime = LocalDateTime.now();
		this.authorId = authorId;
		this.postHeader = postHeader;
		this.postBody = postBody;
	}	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Author getAuthorId() {
		return authorId;
	}
	
	public void setAuthorId(Author authorId) {
		this.authorId = authorId;
	}
	
	public int getNumberOfReaders() {
		return numberOfReaders;
	}
	
	public void setNumberOfReaders(int numberOfReaders) {
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
