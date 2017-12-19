package org.jcker.jcker.controller;

import org.apache.log4j.Logger;
import org.jcker.blog.controller.BlogController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by <a href='http://jcker.org'>Alan Turing</a>
 * on 2017-12-19 at 1:47 PM
 *
 * @version 1.0
 */
@Controller
public class FacadeController {
    Logger log = Logger.getLogger(FacadeController.class);


    @RequestMapping("/")
    public String index() {
        log.info("Welcome to Jcker .............");
        return "index";
    }
}
