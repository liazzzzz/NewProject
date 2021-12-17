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
    public String getAllPosts(Model model){
        List<Article> posts = articlesService.findAll();
        model.addAttribute("posts", posts);
        return "articles";
    }

    @GetMapping("/articles/{id}")
    public String getPost(@PathVariable("id") Long id, Model post_model, Model comment_model){
        Optional<Article> optionalPost = articlesService.getById(id);
        if (optionalPost.isPresent()) {
            Article post = optionalPost.get();
            post_model.addAttribute("post", post);
            comment_model.addAttribute("comments", commentsService.findCommentByPost(id));
            return "article";
        } else {
            return "error";
        }
    }

    @GetMapping("/newArticle")
    public String getNewPostPage() {
        return "articleForm";
    }

    @PostMapping("/newArticle")
    public String createPost(Article post){
        String auth = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> optionalUser = usersService.findUserByEmail(auth);
        if (optionalUser.isPresent()) {
            post.setUser(optionalUser.get());
            post.setCreatedAt(LocalDateTime.now());
            articlesService.save(post);
            return "redirect:/posts/" + post.getId();
        } else {
            return "error";
        }
    }

    @GetMapping("/editArticle/{id}")
    public String editPost(@PathVariable Long id, Model model){
        String auth = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<Article> optionalPost = articlesService.getById(id);
        if (optionalPost.isPresent()) {
            Article post = optionalPost.get();
            if (auth.equals(post.getUser().getEmail())) {
                model.addAttribute("post", post);
                return "editForm";
            } else {
                System.err.println("Current User has no permissions to edit post by id: " + id);
                return "error";
            }
        } else {
            System.err.println("Could not find a post #" + id);
            return "error";
        }
    }

    @PostMapping ("/editArticle/{id}")
    public String editPost(@PathVariable Long id, Article post){
        Optional<Article> optionalPost = articlesService.getById(id);
        if (optionalPost.isPresent()) {
            Article editedPost = optionalPost.get();
            editedPost.setTitle(post.getTitle());
            editedPost.setText(post.getText());
            editedPost.setCreatedAt(LocalDateTime.now());
            articlesService.save(editedPost);
            return "redirect:/posts/" + editedPost.getId();
        } else {
            return "error";
        }
    }

    @GetMapping("/deleteArticle/{id}")
    public String deletePost(@PathVariable Long id){
         String auth = SecurityContextHolder.getContext().getAuthentication().getName();
         Optional<Article> optionalPost = articlesService.getById(id);
         if (optionalPost.isPresent()){
             Article post = optionalPost.get();
             if (post.getUser().getEmail().equals(auth)){
                 articlesService.deleteById(id);
                 return "redirect:/posts";
             } else {
                 return "error";
             }
         } else {
             return "error";
         }
    }

}
