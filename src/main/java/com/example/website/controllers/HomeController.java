package com.example.website.controllers;

import com.example.website.models.Article;
import com.example.website.services.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private ArticlesService articlesService;

    @GetMapping("/")
    public String index(Model model){
        Article post = articlesService.findLatestArticle();
        model.addAttribute("post", post);
        return "index";
    }

}
