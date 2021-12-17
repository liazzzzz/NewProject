package com.example.website.repositories;

import com.example.website.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticlesRepository extends JpaRepository<Article, Long> {
      List<Article> findAll();
      Optional<Article> findById(Long id);

//      @Query("select p from Post p left join fetch p.user order by p.createdAt desc")
//      Post findLatestPosts(Pageable pageable);

        Article findTopByOrderByCreatedAtDesc();
}
