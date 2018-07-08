package com.tild.desafio.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tild.desafio.blog.data.PostRepository;
import com.tild.desafio.blog.data.UserRepository;
import com.tild.desafio.blog.model.User;

@Controller
@RequestMapping("/users")
public class UsersController {
	
	private UserRepository userRepository;
	
	@Autowired
	public UsersController(PostRepository postRepository, UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@GetMapping("/newUser")
    public ModelAndView newUser(){
        ModelAndView modelView = new ModelAndView("newUser");
        modelView.addObject("newUser",new User());
        return modelView;
    }
	
	@GetMapping("/{id}")
    public ModelAndView userPosts(@PathVariable Long id){
        ModelAndView modelView = new ModelAndView("userPosts");
        User user = userRepository.findOne(id);
        modelView.addObject("userPosts",user.getPosts());
        return modelView;
    }
	
	@PostMapping
    public ModelAndView createUser(User user) {
		if(user.isValid()) {
         userRepository.save(user);
		}
        return new ModelAndView("redirect:/");
    }
	
}
