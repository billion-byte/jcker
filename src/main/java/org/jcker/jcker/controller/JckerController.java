package org.jcker.jcker.controller;

import org.apache.log4j.Logger;
import org.jcker.blog.controller.BlogController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by <a href='http://jcker.org'>Alan Turing</a>
 * on 2017-12-19 at 1:41 PM
 *
 * @version 1.0
 */

@Controller
@RequestMapping("/jcker")
public class JckerController {
    Logger log = Logger.getLogger(JckerController.class);


    @RequestMapping("/login")
    public String login(String email, String password) {
        System.out.println("email = " + email);
        System.out.println("password = " + password);
        if ("helloalanturing@gmail.com".equals(email) && "jcker.org".equals(password)) {
            return "admin";
        } else {
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String logout() {
        return "index";
    }

    @RequestMapping("/admin")
    public String admin(HttpServletRequest request) {
        BlogController.BASE_PATH = request.getServletContext().getRealPath("/");

        return "admin";
    }
}
