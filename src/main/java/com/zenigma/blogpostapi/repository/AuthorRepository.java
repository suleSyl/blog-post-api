package com.zenigma.blogpostapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zenigma.blogpostapi.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

}
