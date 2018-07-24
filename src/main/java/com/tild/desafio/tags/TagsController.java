package com.tild.desafio.tags;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tild.desafio.blog.data.TagRepository;
import com.tild.desafio.blog.model.Tag;

@Controller
@RequestMapping("/tags")
public class TagsController {
	
	private TagRepository tagRepository;
	
	@Autowired
	public TagsController(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}
	
	@GetMapping("/newTag")
    public ModelAndView newTag(){
        ModelAndView modelView = new ModelAndView("newTag");
        modelView.addObject("newTag",new Tag());
        return modelView;
    }
	
	
	@PostMapping
    public ModelAndView createTag(Tag tag) {
		if(tag.isValid()) {
			tagRepository.save(tag);
		}
        return new ModelAndView("redirect:/");
    }
	
}
