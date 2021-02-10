package com.meteergin.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @GetMapping
    @RequestMapping(path = {"/", "/index"})
    public String index(Model model) {
        return "index";
    }

    @GetMapping
    @RequestMapping(path = { "/profile"})
    public String generic(Model model) {
        return "profile";
    }

    @GetMapping
    @RequestMapping(path = { "/elements"})
    public String elements(Model model) {
        return "elements";
    }
}
