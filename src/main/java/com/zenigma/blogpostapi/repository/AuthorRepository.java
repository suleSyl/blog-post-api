package com.zenigma.blogpostapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zenigma.blogpostapi.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{	
	Optional<Author> findById(int id);
	Optional<Author> findByName(String name);
}
