package org.jcker.controller;

import org.apache.log4j.Logger;
import org.jcker.dao.ArticleDao;
import org.jcker.domain.Article;
import org.jcker.utils.JckerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by <a href='http://jcker.org'>Alan Turing</a>
 * on 2017-12-19 at 1:47 PM
 *
 * @version 1.0
 */
@Controller
public class ArticleController {
    Logger log = Logger.getLogger(ArticleController.class);

    @Autowired
    ArticleDao articleDao;

    @RequestMapping("/")
    public String index() {

        return "article_editor";
    }

    @RequestMapping("/admin/save_article")
    public String save(Article article) {

        System.out.println("article = " + article);

        articleDao.save(article);
        log.info("-------------");
        return "index";
    }

    @RequestMapping("/article/{id}")
    public String view (@PathVariable int id, Model model)  throws Exception {

        Article article = articleDao.findOne(id);
        System.out.println("article = " + article);
        article.setContent(JckerUtils.mdToHtml(article.getContent()));

        List<Article> articleList = articleDao.findAll();

        model.addAttribute("recent_articles", articleList);
        model.addAttribute("article", article);
        return "page";
    }
}
