package com.tild.desafio.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.Preconditions;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Lob
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("posts")
    private User user;

    public Post() {
        super();
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", user=" + user +
                '}';
    }

    public boolean isValid() {
        boolean valid = false;

        try {
            Arrays.asList(this.getUser(), this.getText(), this.getTitle())
                    .forEach(Preconditions::checkNotNull);

            Arrays.asList(this.getText(), this.getTitle())
                    .forEach(txt -> {
                        Preconditions.checkArgument(!txt.isEmpty());
                    });

            valid = true;
        } catch (Exception e){
            valid = false;
        }

        return valid;
    }
}
