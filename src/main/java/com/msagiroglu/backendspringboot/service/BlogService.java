package com.msagiroglu.backendspringboot.service;

import com.msagiroglu.backendspringboot.exception.BlogNotFoundException;
import com.msagiroglu.backendspringboot.model.Blog;
import com.msagiroglu.backendspringboot.repo.BlogRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepo blogRepo;

    public Blog saveBlog(Blog blog) { return blogRepo.save(blog); }

    public List<Blog> getAllBlogs() { return blogRepo.findAll(); }

    public Blog updateBlog(Blog blog) { return blogRepo.save(blog); }

    public Blog findBlogById(Long id) {
        return blogRepo.findBlogById(id).orElseThrow(() -> new BlogNotFoundException("Blog with id " + id + " not found!"));
    }

    public void deleteBlog(Long id) {
        blogRepo.deleteBlogById(id);
    }

}
