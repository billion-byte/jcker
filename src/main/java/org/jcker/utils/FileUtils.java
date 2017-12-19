package org.jcker.utils;

import org.jcker.blog.controller.BlogController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by <a href='http://jcker.org'>Alan Turing</a>
 * on 2017-10-09 at 6:49 AM
 *
 * @version 1.0
 */
public class FileUtils {
    /***
     * 获取指定目录下的所有的文件（不包括文件夹），采用了递归
     *
     * @param obj 23
     * @return 12
     */
    public static ArrayList<File> getListFiles(Object obj, String suffix) {
        File directory = obj instanceof File ? (File) obj : new File(obj.toString());

        ArrayList<File> files = new ArrayList<>();
        if (directory.isFile() && directory.getName().endsWith(suffix)) {
            files.add(directory);
            return files;
        } else if (directory.isDirectory()) {
            File[] fileArr = directory.listFiles();
            for (File fileOne : fileArr) {
                files.addAll(getListFiles(fileOne, suffix));
            }
        }
        return files;
    }

    /**
     * get sub dir
     *
     * @param obj parent dir or dir's path.
     * @return sub dirs
     */
    public static List<File> getSubDir(Object obj) {
        File directory = obj instanceof File ? (File) obj : new File(obj.toString());
        List<File> files = new ArrayList<>();
        File[] fileArray = directory.listFiles();
        if (fileArray != null) {
            for (File file : fileArray) {
                if (file.isDirectory()) {
                    files.add(file);
                }
            }
        }
        return files;
    }

    /**
     * get sub files
     *
     * @param obj parent dir or dir's path
     * @return sub files
     */
    public static List<File> getSubFile(Object obj) {
        File directory = obj instanceof File ? (File) obj : new File(obj.toString());
        List<File> files = new ArrayList<>();
        File[] fileArray = directory.listFiles();
        if (fileArray != null) {
            for (File file : fileArray) {
                if (file.isFile()) {
                    files.add(file);
                }
            }
        }
        return files;
    }

    public static ArrayList<File> getSubDirWithRoot(Object obj) {
        File directory = obj instanceof File ? (File) obj : new File(obj.toString());
        ArrayList<File> files = new ArrayList<>();
        if (directory.isDirectory()) {
            files.add(directory);

            File[] fileArr = directory.listFiles();
            for (File file : fileArr) {
                files.addAll(getSubDir(file));
            }
        }
        return files;
    }

    public static List<File> getSubFileAndDir(Object obj) {
        File directory = obj instanceof File ? (File) obj : new File(obj.toString());
        File[] fileArr = directory.listFiles();
        return Arrays.asList(fileArr == null ? new File[]{} : fileArr);
    }


    public static void main(String[] args) throws IOException {

    }


    /**
     * store uploaded file under blog directory,
     *
     * @param file              uploaded file should be either HTML or markdown
     * @param blogRootDirectory blog root directory
     * @throws IOException ex
     */
    public static void store(MultipartFile file, String blogRootDirectory) throws IOException {

/*        if (file.getOriginalFilename().endsWith(".md")) {
            File temp;
            //store uploaded markdown file in system's path
            String markdownFilePath = BlogController.BASE_PATH + File.separator + BlogController.MARKDOWN_PATH;
            file.transferTo(temp = new File(markdownFilePath + File.separator + file.getOriginalFilename()));

            //parse to html String
            String md = MarkDownParser.readFile(temp.getAbsolutePath());
            Parser parser = Parser.builder().build();
            Node document = parser.parse(md);
            HtmlRenderer renderer = HtmlRenderer.builder().build();
            String html = renderer.render(document);

            //create html page by using html String.
            File htmlFile = new File(blogRootDirectory + File.separator + file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf('.') + 1) + "html");
            System.out.println(htmlFile.getAbsolutePath());
            String str = MarkDownParser.prefix + html + MarkDownParser.suffix;
            byte bytes[];
            bytes = str.getBytes();
            FileOutputStream fos = new FileOutputStream(htmlFile);
            fos.write(bytes);
            fos.close();
        } else */if (file.getOriginalFilename().endsWith(".html")) {
            File temp;
            //store uploaded markdown file in system's path
            String htmlFilePath = BlogController.BASE_PATH + File.separator + BlogController.HTML_PATH;
            file.transferTo(temp = new File(htmlFilePath + File.separator + file.getOriginalFilename()));
            String htmlString = HtmlParser.readFile(temp.getAbsolutePath());

            htmlString = htmlString.replaceFirst("</head>", HtmlParser.prefix);
            htmlString = htmlString.replaceFirst("</html>", HtmlParser.suffix);
            File htmlFile = new File(blogRootDirectory + File.separator + file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf('.') + 1) + "html");
            byte bytes[];
            bytes = htmlString.getBytes();
            FileOutputStream fos = new FileOutputStream(htmlFile);
            fos.write(bytes);
            fos.close();
        }
    }

}
