package org.jcker.dao;

import org.jcker.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by <a href='http://jcker.org'>Alan Turing</a>
 * on 2018-02-25 at 3:16 AM
 *
 * @version 1.0
 */
public interface ArticleDao extends JpaRepository<Article, Integer> {

    @Query(value = "select t.* from t_article t limit 6 ", nativeQuery = true)
    List<Article> findRecentArticles();

    Page<Article> findAll(Pageable pageable);

    Article getArticleByTitle(String title);

    List<Article> findAllByCategory(String name);
}
