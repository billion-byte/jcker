package org.jcker.blog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.log4j.Logger;
import org.jcker.blog.domain.Blog;
import org.jcker.blog.domain.TreeNode;
import org.jcker.utils.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by <a href='http://jcker.org'>Alan Turing</a>
 * on 2017-09-26 at 7:01 PM
 *
 * @version 1.0
 */
@Controller
@RequestMapping("/blog")
public class BlogController {
    Logger log = Logger.getLogger(BlogController.class);
    private static final String PUBLISHED = "published";
    private static final String UNPUBLISHED = "unpublished";
    public static String MARKDOWN_PATH = "markdown";
    public static String HTML_PATH = "html";

    /*init by JckerController after login admin*/
    public static String BASE_PATH;


    @RequestMapping("/upload")
    public String handleFileUpload(MultipartFile file) throws IOException {
        FileUtils.store(file, BASE_PATH + File.separator + UNPUBLISHED);
        return "redirect:admin";
    }

    @ResponseBody
    @RequestMapping("/bloglist")
    public List<Blog> bloglist(HttpServletRequest request) throws JsonProcessingException {
        String path = request.getServletContext().getRealPath("/") + "blog";
        ArrayList<File> files = FileUtils.getListFiles(path, "html");
        List<Blog> blogList = new ArrayList<>();
        for (File file : files) {
            Blog blog = new Blog();
            blog.setDate(file.getName().substring(0, 10));
            blog.setName(file.getName().substring(11, file.getName().length() - 5));
            blog.setCategory(file.getName().substring(0, 7));
            blog.setValid("Y");
            blog.setPersonal("Y");
            blogList.add(blog);
        }
        return blogList;
    }

    @ResponseBody
    @RequestMapping("/getTrendingBlogList")
    public List<String> getTrendingBlogList(HttpServletRequest request) throws JsonProcessingException {
        String path = request.getServletContext().getRealPath("/") + PUBLISHED;
        ArrayList<File> files = FileUtils.getListFiles(path, "html");
        List<String> blogList = new ArrayList<>();
        for (File file : files) {
            String fileName = file.getName();
            String prefix = "";
            while (!file.getParent().equals(path)) {
                prefix = file.getParentFile().getName() + File.separator + prefix;
                file = file.getParentFile();
            }
            blogList.add(prefix + fileName);
        }
        return blogList;
    }

    @ResponseBody
    @RequestMapping("/getPublishedBlog/{open}/{isUrl}")
    public String getPublishedBlog(HttpServletRequest request, @PathVariable boolean open, @PathVariable boolean isUrl) throws JsonProcessingException {
        String path = request.getServletContext().getRealPath(File.separator + PUBLISHED);
        List<TreeNode> treeNodes = generateTree(path, PUBLISHED, open, isUrl, true);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        return objectMapper.writeValueAsString(treeNodes);
    }

    @ResponseBody
    @RequestMapping("/getUnpublishedBlog/{open}")
    public String getUnpublishedBlog(HttpServletRequest request, @PathVariable boolean open) throws JsonProcessingException {
        String path = request.getServletContext().getRealPath(File.separator + UNPUBLISHED);
        List<TreeNode> treeNodes = generateTree(path, UNPUBLISHED, open, true, false);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        return objectMapper.writeValueAsString(treeNodes);
    }

    @ResponseBody
    @RequestMapping("/changeBlogCategory")
    public boolean changeBlogCategory(HttpServletRequest request, String treeNode, String targetNode) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        TreeNode dragNode = objectMapper.readValue(treeNode, TreeNode.class);
        TreeNode dropNode = objectMapper.readValue(targetNode, TreeNode.class);
        System.out.println("dropNode = " + dropNode);

        //获取移动节点的文件信息
        String path = request.getServletContext().getRealPath("/");
        String dragPath = path + dragNode.getUrl();
        System.out.println("dragPath = " + dragPath);
        File dragFile = new File(path + dragNode.getUrl());
        //获取目标节点的文件信息
        List<TreeNode> childrenNode = dropNode.getChildren();
        if (CollectionUtils.isEmpty(childrenNode)) {
            String s = dropNode.getUrl() + File.separator + dropNode.getName() + File.separator + dragFile.getName();
            System.out.println("s = " + s);
            return dragFile.renameTo(new File(s));
        } else {
            TreeNode child = dropNode.getChildren().get(0);
            String targetPath = path + child.getUrl().substring(0, child.getUrl().lastIndexOf("/") + 1) + dragFile.getName();
            System.out.println("targetPath = " + targetPath);
            return dragFile.renameTo(new File(targetPath));
        }
    }

    @ResponseBody
    @RequestMapping("/deleteBlog")
    public boolean deleteBlog(String treeNode) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        TreeNode deleteNode = objectMapper.readValue(treeNode, TreeNode.class);
        //根据children判断是分类(目录)还是博客(文件)
        String path = "";
        if(deleteNode.getChildren() == null){
            path = BASE_PATH + deleteNode.getUrl();
        } else{
            path = deleteNode.getUrl() + File.separator + deleteNode.getName();
        }
        log.debug("deleting blog:" + path);
        File deleteFile = new File(path);
        return deleteFile.delete();
    }
    @ResponseBody
    @RequestMapping("/createCategory/{category}")
    public boolean createCategory(HttpServletRequest request, @PathVariable String category) {
        String path = request.getServletContext().getRealPath("/" + PUBLISHED);
        String fommartCategory = category.replaceAll("^\\s+$", "-");
        return new File(path + "/" + fommartCategory).mkdir();
    }

    @RequestMapping("/getBlogList")
    public String getBlogList(HttpServletRequest request, String tag, Model model) throws JsonProcessingException {

        model.addAttribute("tag", tag);
        String path = request.getServletContext().getRealPath("/") + "blog/" + tag;

        ArrayList<File> files = FileUtils.getListFiles(path, "html");
        List<String> blogList = new ArrayList<>();
        for (File file : files) {
            String fileName = file.getName();
            String prefix = "";
            while (!file.getParent().equals(path)) {
                prefix = file.getParentFile().getName() + "/" + prefix;
                file = file.getParentFile();
            }
            blogList.add(prefix + fileName);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String arrayToJson = objectMapper.writeValueAsString(blogList);
        System.out.println("arrayToJson = " + arrayToJson);
        model.addAttribute("category", arrayToJson);
        return "category";
    }

    public static void main(String[] args) throws IOException {

    }

    /**
     * generate zTree
     *
     * @param obj    full base path
     * @param prefix base path under web content.
     * @return TreeNode list
     */
    private static List<TreeNode> generateTree(Object obj, String prefix, boolean open, boolean isUrl, boolean isFomart) {
        File root = obj instanceof File ? (File) obj : new File(obj.toString());
        List<TreeNode> subNodes = new ArrayList<>();
        for (File file : FileUtils.getSubFile(root)) {
            if (isFomart) {
                subNodes.add(new TreeNode(file.getName().substring(0,file.getName().length()-5), root.getPath().substring(root.getPath().lastIndexOf(prefix)) + File.separator + file.getName()));
            } else {
                subNodes.add(new TreeNode(file.getName(), root.getPath().substring(root.getPath().lastIndexOf(prefix)) + File.separator + file.getName()));
            }
        }
        for (File file : FileUtils.getSubDir(root)) {
            if (isUrl) {
                subNodes.add(new TreeNode(file.getName(), root.getPath(), open, generateTree(file, prefix, open, isUrl, isFomart)));
            } else {
                subNodes.add(new TreeNode(file.getName(), null, open, generateTree(file, prefix, open, isUrl, isFomart)));
            }
        }
        return subNodes;
    }
}
