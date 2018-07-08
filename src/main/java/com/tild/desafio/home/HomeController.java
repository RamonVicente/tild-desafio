package com.tild.desafio.home;

import com.tild.desafio.blog.data.PostRepository;
import com.tild.desafio.blog.data.UserRepository;
import com.tild.desafio.blog.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private PostRepository postRepository;

    @Autowired
    public HomeController(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("posts", postRepository.findAll());

        return mv;
    }
}
