package org.jcker.controller;

import org.apache.log4j.Logger;
import org.jcker.dao.ArticleDao;
import org.jcker.dao.CommentDao;
import org.jcker.dao.FriendLinkDao;
import org.jcker.dao.MenuDao;
import org.jcker.domain.Article;
import org.jcker.domain.Comment;
import org.jcker.utils.JckerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @Autowired
    CommentDao commentDao;

    @RequestMapping("/")
    public String index(Model model) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(0,10, sort);
        model.addAttribute("menuList",menuDao.findAll());
        model.addAttribute("friendLinkList", friendLinkDao.findAll());
        Page<Article> articlePage = articleDao.findAll(pageable);
        for (Article article :
                articlePage.getContent()) {
            article.setPreview(intro(article.getContent(),100));
        }
        model.addAttribute("pageObject", articlePage);
        return "index";
    }
    @RequestMapping("/page/{page}")
    public String page(Model model, @PathVariable int page) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page-1,10, sort);
        model.addAttribute("menuList",menuDao.findAll());
        model.addAttribute("friendLinkList", friendLinkDao.findAll());
        Page<Article> articlePage = articleDao.findAll(pageable);
        for (Article article :
                articlePage.getContent()) {
            article.setPreview(intro(article.getContent(),100));
        }
        model.addAttribute("pageObject", articlePage);
        return "index";
    }

    @RequestMapping("/about")
    public String about(Model model) {
        model.addAttribute("menuList",menuDao.findAll());
        model.addAttribute("friendLinkList", friendLinkDao.findAll());
        Article article = articleDao.getArticleByTitle("about");
        article.setContent(JckerUtils.mdToHtml(article.getContent()));
        model.addAttribute("about", article);
        return "about";
    }

    @RequestMapping("/admin/save_article")
    public String save(Article article, Model model) {

        System.out.println("article = " + article);
        if (article.getId() <= 0) {
            article.setCommentNum(new Random(100).nextInt(100));
            article.setViewNum(new Random(1000).nextInt(10000));
            article.setCreateDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        }
        articleDao.save(article);
        model.addAttribute("menuList",menuDao.findAll());
        model.addAttribute("articleList", articleDao.findAll());
        model.addAttribute("recent_articles", articleDao.findAll());
        return "dashboard";
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

        List<Comment> commentList = commentDao.findAllByArticleId(id);

        model.addAttribute("recent_articles", articleList);
        model.addAttribute("article", article);
        model.addAttribute("commentList", commentList);
        return "page";
    }

    @RequestMapping("/admin/create_article")
    public String create() {
        return "article_editor";

    }

    @RequestMapping("/add_comment")
    @ResponseBody
    public boolean addComment(Comment comment) {
        System.out.println("comment = " + comment);
        comment.setContent("<pre>" + comment.getContent() + "</pre>");
        comment.setCreateDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        commentDao.save(comment);
        return true;
    }

    /**
     * 查询分类下的文章
     * @param name 分类名称
     * @return
     */
    @RequestMapping("/category/{name}")
    public String category(@PathVariable String name, Model model) {
        model.addAttribute("archive", articleDao.findAllByCategory(name));
        return "archive";
    }

    /**
     * 截取文章摘要
     *
     * @param value 文章内容
     * @param len   要截取文字的个数
     * @return
     */
    public static String intro(String value, int len) {
        int pos = value.indexOf("<!--more-->");
        if (pos != -1) {
            String html = value.substring(0, pos);
            return JckerUtils.mdToText(html);
        } else {
            String text = JckerUtils.mdToText(value);
            if (text.length() > len) {
                return text.substring(0, len);
            }
            return text;
        }
    }
}
