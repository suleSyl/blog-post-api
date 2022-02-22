package com.zenigma.blogpostapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zenigma.blogpostapi.models.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
	Optional<Post> findById(int id);
}
