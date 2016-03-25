package org.easyjava.controller;

import org.easyjava.model.Topic;
import org.easyjava.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@Autowired
	private TopicRepository repository;
	
	@RequestMapping("/")
    public String home(Model model) {
		repository.save(new Topic("hashmap","HashMap is my favourite collection"));
		model.addAttribute("desc",repository.findByTitle("hashmp"));
      return "index";
    }
}
