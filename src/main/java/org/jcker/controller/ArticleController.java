package org.jcker.controller;

import org.apache.log4j.Logger;
import org.jcker.dao.ArticleDao;
import org.jcker.dao.FriendLinkDao;
import org.jcker.dao.MenuDao;
import org.jcker.domain.Article;
import org.jcker.domain.FriendLink;
import org.jcker.utils.JckerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
    @Autowired
    MenuDao menuDao;
    @Autowired
    FriendLinkDao friendLinkDao;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("menuList",menuDao.findAll());
        List<Article> articleList = articleDao.findRecentArticles();
        for (Article article : articleList) {
            article.setContent(JckerUtils.mdToHtml(article.getContent()));
        }
        model.addAttribute("articleList", articleList);
        model.addAttribute("friendLinkList", friendLinkDao.findAll());
        model.addAttribute("recent_articles", articleList);
        return "index";
    }

    @RequestMapping("/about")
    public String about(Model model) {
        model.addAttribute("menuList",menuDao.findAll());
/*        List<Article> articleList = articleDao.findRecentArticles();
        for (Article article : articleList) {
            article.setContent(JckerUtils.mdToHtml(article.getContent()));
        }
        model.addAttribute("articleList", articleList);*/
        model.addAttribute("friendLinkList", friendLinkDao.findAll());
        Article article = articleDao.getArticleByTitle("about");
        article.setContent(JckerUtils.mdToHtml(article.getContent()));
        model.addAttribute("about", article);
        return "about";
    }

    @RequestMapping("/admin/save_article")
    public String save(Article article, Model model) {

        System.out.println("article = " + article);
        //if (article.getId() <= 0) {
            article.setCommentNum(new Random(100).nextInt(100));
            article.setViewNum(new Random(1000).nextInt(10000));
            article.setCreateDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        //}
        articleDao.save(article);
        model.addAttribute("menuList",menuDao.findAll());
        model.addAttribute("articleList", articleDao.findAll());
        model.addAttribute("recent_articles", articleDao.findAll());
        return "index";
    }
    @RequestMapping("/admin/edit_article/{id}")
    public String edit(@PathVariable int id, Model model) {
        Article article = articleDao.findOne(id);
        System.out.println("article = " + article);
        model.addAttribute("article", article);
        return "article_editor";
    }

    @RequestMapping("/article/{id}")
    public String view (@PathVariable int id, Model model)  throws Exception {

        Article article = articleDao.findOne(id);
        System.out.println("article = " + article);
        article.setContent(JckerUtils.mdToHtml(article.getContent()));

        List<Article> articleList = articleDao.findRecentArticles();

        model.addAttribute("recent_articles", articleList);
        model.addAttribute("article", article);
        return "page";
    }

    @RequestMapping("/admin/create_article")
    public String create() {
        return "article_editor";

    }
}
