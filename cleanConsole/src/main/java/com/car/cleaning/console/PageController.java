package com.car.cleaning.console;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by jiangyunfan on 2018/12/10.
 */
@Controller
public class PageController {

    @RequestMapping(value = "/index",
            method = RequestMethod.GET)
    public String renderHomePage(HttpServletRequest request, Model model) {
        return "index";
    }

    @RequestMapping(value = "/register",
            method = RequestMethod.GET)
    public String registerPage(HttpServletRequest request, Model model) {
        return "register";
    }

    @RequestMapping(value = "/404",
            method = RequestMethod.GET)
    public String _404Page(HttpServletRequest request, Model model) {
        return "404";
    }

    @RequestMapping(value = "/forgot",
            method = RequestMethod.GET)
    public String forgotPage(HttpServletRequest request, Model model) {
        return "forgot";
    }

    @RequestMapping(value = "/blank",
            method = RequestMethod.GET)
    public String blankPage(HttpServletRequest request, Model model) {
        return "blank";
    }


    @RequestMapping(value = "/login",
            method = RequestMethod.GET)
    public String loginPage(HttpServletRequest request, Model model) {
        String userId = "user";

        model.addAttribute("userId", userId);
        return "login";
    }

}
