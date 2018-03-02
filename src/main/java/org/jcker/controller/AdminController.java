package org.jcker.controller;

import org.jcker.dao.MenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class AdminController {
    @Autowired
    MenuDao menuDao;
    @RequestMapping("/admin")
    public String admin() {
        return "dashboard";
    }

    @RequestMapping("/admin/menu_list")
    public String menu (Model model) {
//        model.addAttribute("menuList", menuDao.findAll());
        return "menu_edit";
    }
    @RequestMapping("/admin/menuList")
    @ResponseBody
    public Object menu () {
        return menuDao.findAll();
    }
}
