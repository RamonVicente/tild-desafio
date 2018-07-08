package com.tild.desafio.blog.data;

import com.tild.desafio.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
