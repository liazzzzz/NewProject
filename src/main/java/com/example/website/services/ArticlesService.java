package com.example.website.services;

import com.example.website.models.Article;

import java.util.List;
import java.util.Optional;

public interface ArticlesService {
    List<Article> findAll();
    Optional<Article> getById(Long id);
    Article save(Article post);
    Article edit(Article post);
    void deleteById(Long id);

    Article findLatestPost();

}
