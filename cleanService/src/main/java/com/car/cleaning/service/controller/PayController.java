package com.car.cleaning.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by jiangyunfan on 2018/12/10.
 */
@Controller
public class PayController {

    @RequestMapping(value = "/demo",
            method = RequestMethod.GET)
    public String showDemo(HttpServletRequest request, Model model) {
        return "twofactorDemo";
    }

    @RequestMapping(value = "/pay",
            method = RequestMethod.GET)
    public String pay(HttpServletRequest request, Model model) {
        String userId = "user";

        model.addAttribute("userId", userId);
        return "pay";
    }

}
