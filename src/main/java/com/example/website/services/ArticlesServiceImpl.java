package com.example.website.services;

import com.example.website.models.Article;
import com.example.website.repositories.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticlesServiceImpl implements ArticlesService {

    @Autowired
    private ArticlesRepository articlesRepository;

    @Override
    public List<Article> findAll() {
        return articlesRepository.findAll();
    }

    @Override
    public Optional<Article> getById(Long id) { return articlesRepository.findById(id); }

    @Override
    public Article save(Article post) {
        return articlesRepository.save(post);
    }

    @Override
    public Article edit(Article post) {
        return articlesRepository.save(post);
    }

    @Override
    public void deleteById(Long id) { articlesRepository.deleteById(id); }

    @Override
    public Article findLatestPost() {
        return articlesRepository.findTopByOrderByCreatedAtDesc();
    }
}
