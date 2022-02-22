package com.zenigma.blogpostapi.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.zenigma.blogpostapi.models.Post;
import com.zenigma.blogpostapi.repository.PostRepository;

@RestController
public class BlogPostController {
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/posts")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public List<Post> getAllPosts() {
		return postRepository.findAll();
	}
	
	@PostMapping("/posts")
    @ResponseStatus(HttpStatus.ACCEPTED)
	public Post createPost(@RequestBody Post newPost) {
		return postRepository.save(newPost);
	}
	
	@PutMapping("/posts/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseEntity<Post> updatePost(@PathVariable int postId, @Validated @RequestBody Post postDetails) {
		return postRepository.findById(postId).map(post -> {
			post.setPostHeader(postDetails.getPostHeader());
			post.setPostBody(postDetails.getPostBody());
			post.setAdditionalInfo(postDetails.getAdditionalInfo());
			post.setIsActive(postDetails.getIsActive());
			post.setModificationDateTime(LocalDateTime.now());
			return ResponseEntity.ok(postRepository.save(post));
		}).orElseGet(() -> {
			postDetails.setId(postId);
			return ResponseEntity.ok(postRepository.save(postDetails));
		});		
	}
	
	@DeleteMapping("/posts/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
	public void deletePost(@PathVariable Long id) {
		postRepository.deleteById(id);
	}
}
