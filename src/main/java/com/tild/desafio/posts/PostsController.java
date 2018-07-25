package com.tild.desafio.posts;

import com.tild.desafio.blog.data.PostRepository;
import com.tild.desafio.blog.data.TagRepository;
import com.tild.desafio.blog.data.UserRepository;
import com.tild.desafio.blog.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/posts")
public class PostsController {

    private PostRepository postRepository;
    private UserRepository userRepository;
    private TagRepository tagRepository; 

    @Autowired
    public PostsController(PostRepository postRepository, UserRepository userRepository, TagRepository tagRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.tagRepository = tagRepository;
    }

    @GetMapping("/new")
    public ModelAndView newPost(){
        ModelAndView mv = new ModelAndView("new");
        
        mv.addObject("tags", tagRepository.findAll());
        mv.addObject("users", userRepository.findAll());
        mv.addObject("newPost", new Post());

        return mv;
    }

    @PostMapping
    public ModelAndView createPost(Post post) {
        if(post.isValid())
            postRepository.save(post);

        return new ModelAndView("redirect:/");
    }
}
