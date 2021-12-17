package com.example.website.controllers;

import com.example.website.models.Article;
import com.example.website.models.User;
import com.example.website.services.CommentsService;
import com.example.website.services.ArticlesService;


import com.example.website.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class ArticleController {

    @Autowired
    private ArticlesService articlesService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private CommentsService commentsService;

    @GetMapping("/articles")
    public String getAllrticles(Model model){
        List<Article> articles = articlesService.findAll();
        model.addAttribute("articles", articles);
        return "articles";
    }

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable("id") Long id, Model article_model, Model comment_model){
        Optional<Article> optionalArticle = articlesService.getById(id);
        if (optionalArticle.isPresent()) {
            Article article = optionalArticle.get();
            article_model.addAttribute("article", article);
            comment_model.addAttribute("comments", commentsService.findCommentByArticle(id));
            return "article";
        } else {
            return "error";
        }
    }

    @GetMapping("/newArticle")
    public String getNewArticlePage() {
        return "articleForm";
    }

    @PostMapping("/newArticle")
    public String createArticle(Article article){
        String auth = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> optionalUser = usersService.findUserByEmail(auth);
        if (optionalUser.isPresent()) {
            article.setUser(optionalUser.get());
            article.setCreatedAt(LocalDateTime.now());
            articlesService.save(article);
            return "redirect:/articles/" + article.getId();
        } else {
            return "error";
        }
    }

    @GetMapping("/editArticle/{id}")
    public String editArticle(@PathVariable Long id, Model model){
        String auth = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<Article> optionalArticle = articlesService.getById(id);
        if (optionalArticle.isPresent()) {
            Article article = optionalArticle.get();
            if (auth.equals(article.getUser().getEmail())) {
                model.addAttribute("article", article);
                return "editForm";
            } else {
                System.err.println("Current User has no permissions to edit article by id: " + id);
                return "error";
            }
        } else {
            System.err.println("Could not find a article #" + id);
            return "error";
        }
    }

    @PostMapping ("/editArticle/{id}")
    public String editArticle(@PathVariable Long id, Article article){
        Optional<Article> optionalArticle = articlesService.getById(id);
        if (optionalArticle.isPresent()) {
            Article editedArticle = optionalArticle.get();
            editedArticle.setTitle(article.getTitle());
            editedArticle.setText(article.getText());
            editedArticle.setCreatedAt(LocalDateTime.now());
            articlesService.save(editedArticle);
            return "redirect:/articles/" + editedArticle.getId();
        } else {
            return "error";
        }
    }

    @GetMapping("/deleteArticle/{id}")
    public String deleteArticle(@PathVariable Long id){
         String auth = SecurityContextHolder.getContext().getAuthentication().getName();
         Optional<Article> optionalArticle = articlesService.getById(id);
         if (optionalArticle.isPresent()){
             Article article = optionalArticle.get();
             if (article.getUser().getEmail().equals(auth)){
                 articlesService.deleteById(id);
                 return "redirect:/articles";
             } else {
                 return "error";
             }
         } else {
             return "error";
         }
    }

}
