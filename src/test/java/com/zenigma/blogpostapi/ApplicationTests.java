package com.zenigma.blogpostapi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zenigma.blogpostapi.models.Author;
import com.zenigma.blogpostapi.models.Post;
import com.zenigma.blogpostapi.repository.AuthorRepository;
import com.zenigma.blogpostapi.repository.PostRepository;

@SpringBootTest
class ApplicationTests {

    @Autowired
    PostRepository postRepository;
    
    @Autowired
    AuthorRepository authorRepository;
    
    @Test
    public void testCreateAuthor() {
    	Author author = new Author.AuthorBuilder("Tuba", "Şahin", "tuba@gmail.com", "tubasahin").phoneNumber("5321234567").address("İzmir").build();
    	authorRepository.save(author);
    	assertNotNull(authorRepository.findById(author.getId()));
    }
    
    @Test
    public void testCreatePost() {
    	Author author = new Author.AuthorBuilder("Leyla", "Kara", "kubra@gmail.com", "kubrakara").phoneNumber("5321234567").address("Bursa").build();
    	authorRepository.save(author);
    	Post post = new Post();
    	post.setAuthorId(author);
    	post.setPostHeader("HeaderEx");
    	post.setPostBody("BodyEx");
    	postRepository.save(post);
    	assertNotNull(postRepository.findById(post.getId()));
    }
    
    @Test
    public void testGetAllPosts() {
    	List<Post> posts = postRepository.findAll();
    	assertThat(posts).size().isGreaterThan(0);
    }
    
    @Test
    public void testUpdatePost() {
    	Post post = postRepository.findById(1).get();
    	post.setPostHeader("Header Changed");
    	postRepository.save(post);
    	assertNotEquals("Header", postRepository.findById(1).get().getPostHeader());
    }
    
    @Test
    public void testDeletePost() {
    	postRepository.deleteById(1L);
    	assertThat(postRepository.existsById(1L)).isFalse();    	
    }
}
