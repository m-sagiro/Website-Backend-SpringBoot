package com.msagiroglu.backendspringboot.resource;

import com.msagiroglu.backendspringboot.model.Blog;
import com.msagiroglu.backendspringboot.model.User;
import com.msagiroglu.backendspringboot.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BlogResource {
    private final BlogService blogService;

    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> getBlogs() {
        return ResponseEntity.ok().body(blogService.getAllBlogs());
    }

    @GetMapping("/blog/get/{id}")
    public ResponseEntity<Blog> getBlog(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(blogService.findBlogById(id));
    }

    @PostMapping("/blog/save")
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/blog/save").toUriString());
        return ResponseEntity.created(uri).body(blogService.saveBlog(blog));
    }

    @DeleteMapping("/blog/delete/{id}")
    public ResponseEntity<?> deleteBlog(@PathVariable("id") Long id) {
        blogService.deleteBlog(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/blog/update/{id}")
    public ResponseEntity<Blog> updateBlog(@RequestBody Blog blog) {
        return ResponseEntity.ok().body(blogService.updateBlog(blog));
    }

}
