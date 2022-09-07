package com.msagiroglu.backendspringboot.repo;

import com.msagiroglu.backendspringboot.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlogRepo extends JpaRepository<Blog, Long> {
    Optional<Blog> findUserById(Long id);
    void deleteBlogById(Long id);
}
