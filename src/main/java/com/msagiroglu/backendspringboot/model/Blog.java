package com.msagiroglu.backendspringboot.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "blogs")
public class Blog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    @NotBlank
    @Size(max = 50)
    private String title;
    @NotBlank
    @Size(max = 50)
    private String subTitle;
    @NotBlank
    @Size(max = 3000)
    private String text;
    @NotBlank
    private Date postDate;

    public Blog() {

    }

    public Blog(Long id, String title, String subTitle, String text, Date postDate) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.text = text;
        this.postDate = postDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }
}
