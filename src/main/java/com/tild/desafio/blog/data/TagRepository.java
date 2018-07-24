package com.tild.desafio.blog.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tild.desafio.blog.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
