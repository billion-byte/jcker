package org.jcker.dao;

import org.jcker.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment, Integer> {

    List<Comment> findAllByArticleId(int articleId);
}
