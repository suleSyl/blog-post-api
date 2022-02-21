package com.zenigma.blogpostapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zenigma.blogpostapi.models.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
