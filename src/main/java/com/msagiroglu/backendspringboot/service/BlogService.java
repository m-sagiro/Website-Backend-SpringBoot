package com.msagiroglu.backendspringboot.service;

import com.msagiroglu.backendspringboot.exception.BlogNotFoundException;
import com.msagiroglu.backendspringboot.model.Blog;
import com.msagiroglu.backendspringboot.model.User;
import com.msagiroglu.backendspringboot.repo.BlogRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    private final BlogRepo blogRepo;

    public BlogService(BlogRepo blogRepo) {
        this.blogRepo = blogRepo;
    }

    public Blog addBlog(Blog blog) {
        return blogRepo.save(blog);
    }

    public List<Blog> getAllBlogs() { return blogRepo.findAll(); }

    public Blog updateBlog(Blog blog) { return blogRepo.save(blog); }

    public Blog findBlogById(Long id) {
        return blogRepo.findUserById(id).orElseThrow(() -> new BlogNotFoundException("Blog with id " + id + " not found!"));
    }

    public void deleteBlog(Long id) {
        blogRepo.deleteBlogById(id);
    }

}
