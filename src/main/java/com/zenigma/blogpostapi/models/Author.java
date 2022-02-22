package com.zenigma.blogpostapi.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AUTHOR", schema = "BLOG")
public class Author {
	
	@Id @GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="Name")
	private String name = null;
	
	@Column(name="Surname")
	private String surname = null;
	
	@Column(name="Email")
	private String email = null;
	
	@Column(name="Username")
	private String username = null;
	
	@Column(name="PhoneNumber")
	private String phoneNumber = null;
	
	@Column(name="Address")
	private String address = null;
	
	@Column(name="Birthday")
	private LocalDateTime birthday = null;
	
	@Column(name="MemberSince")
	private LocalDateTime memberSince = null; 
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "authorId")      
	private List<Post> postsAuthoredList = null;
	
	public Author() {		
	}

	public Author(AuthorBuilder builder) {
		this.name = builder.name;
		this.surname = builder.surname;
		this.email = builder.email;
		this.username = builder.username;
		this.phoneNumber = builder.phoneNumber;
		this.address = builder.address;
		this.birthday = builder.birthday;
		this.memberSince = builder.memberSince;
		this.postsAuthoredList = builder.postsAuthoredList;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public LocalDateTime getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDateTime birthday) {
		this.birthday = birthday;
	}

	public LocalDateTime getMemberSince() {
		return memberSince;
	}

	public void setMemberSince(LocalDateTime memberSince) {
		this.memberSince = memberSince;
	}
	
	public List<Post> getPostsAuthoredList() {
		return this.postsAuthoredList;
	}
	
	public void setPostsAuthoredList(List<Post> postsAuthoredList) {
		this.postsAuthoredList = postsAuthoredList;
	}

	@Override
	public String toString() {
		return "Name: " + this.getName() + "\n" + "Surname: " + this.getSurname() + "\n" + "Email: "
				+ this.getEmail() + "\n" + "Username: " + this.getUsername() + "\n" + "Phone Number: "
				+ this.getPhoneNumber() + "\n" + "Address: " + this.getAddress() + "\n" + "Birthday: "
				+ this.getBirthday() + "\n" + "Member Since: " + this.getMemberSince();
	}

	public static class AuthorBuilder {
		private String name;
		private String surname;
		private String email;
		private String username;
		private String phoneNumber;
		private String address;
		private LocalDateTime birthday;
		private LocalDateTime memberSince;
		private List<Post> postsAuthoredList;

		public AuthorBuilder(String name, String surname, String email, String username) {
			this.name = name;
			this.surname = surname;
			this.email = email;
			this.username = username;
			this.memberSince = LocalDateTime.now();
		}

		public AuthorBuilder phoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}

		public AuthorBuilder address(String address) {
			this.address = address;
			return this;
		}

		public AuthorBuilder birthday(LocalDateTime birthday) {
			this.birthday = birthday;
			return this;
		}
		
		public AuthorBuilder postsAuthoredList(List<Post> postsAuthoredList) {
			this.postsAuthoredList = postsAuthoredList;
			return this;
		}

		public Author build() {
			return new Author(this);
		}
	}
}
