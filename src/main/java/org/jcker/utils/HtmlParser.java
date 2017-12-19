package org.jcker.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by <a href='http://jcker.org'>Alan Turing</a>
 * on 2017-11-07 at 10:59 AM
 *
 * @version 1.0
 */
public class HtmlParser {
    public static String prefix = "\n" +
            "    <link rel=\"stylesheet\" href=\"/assets/bootstrap/css/bootstrap.min.css\">\n" +
            "    <link href=\"/assets/commons/sticky-footer-navbar.css\" rel=\"stylesheet\">\n" +
            "</head>\n" +
            "<body class='typora-export'>\n" +
            "<nav class=\"navbar navbar-expand-md fixed-top  navbar-light  bg-light\">\n" +
            "    <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#containerNavbarCenter\"\n" +
            "            aria-controls=\"containerNavbarCenter\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
            "        <span class=\"navbar-toggler-icon\"></span>\n" +
            "    </button>\n" +
            "    <div class=\"collapse navbar-collapse justify-content-md-center\" id=\"containerNavbarCenter\">\n" +
            "        <ul class=\"navbar-nav\">\n" +
            "            <li class=\"nav-item active\">\n" +
            "                <a class=\"nav-link\" href=\"/index.jsp\">首页<span class=\"sr-only\">(current)</span></a>\n" +
            "            </li>\n" +
            "        </ul>\n" +
            "    </div>\n" +
            "</nav>\n" +
            "<div class=\"container\">\n" +
            "    <div class=\"row\">\n" +
            "        <div class=\"col-md-12\">" +
            "\n";
    public static String suffix = "\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" +
            "<footer class=\"footer\">\n" +
            "    <div class=\"container\">\n" +
            "        <p class=\"text-muted\">Copyright &copy; jcker.org 2017</p>\n" +
            "    </div>\n" +
            "</footer>\n" +
            "<script src=\"/assets/popper/popper.js\"></script>\n" +
            "<script src=\"/assets/jquery/jquery.js\"></script>\n" +
            "<script src=\"/assets/bootstrap/js/bootstrap.min.js\"></script>\n" +
            "\n" +
            "</body>\n" +
            "</html>";
    public static String readFile(String fileName) {
        File file02 = new File(fileName);
        FileInputStream is;
        StringBuilder stringBuilder = null;
        try {
            if (file02.length() != 0) {
                is = new FileInputStream(file02);
                InputStreamReader streamReader = new InputStreamReader(is);
                BufferedReader reader = new BufferedReader(streamReader);
                String line;
                stringBuilder = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                reader.close();
                is.close();
            } else {
                System.out.println("it's an empty file");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(stringBuilder);

    }
}
