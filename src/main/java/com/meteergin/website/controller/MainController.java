package com.meteergin.website.controller;

import com.meteergin.website.service.RequestService;
import com.meteergin.website.service.VisitorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    private RequestService requestService;
    private VisitorService visitorService;

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    public MainController(RequestService requestService, VisitorService visitorService) {
        this.requestService = requestService;
        this.visitorService = visitorService;
    }

    @GetMapping
    @RequestMapping(path = {"/", "/index"})
    public String index(HttpServletRequest request) {
        try {
            visitorService.saveVisitor("index", requestService.getClientIp(request));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }

    @GetMapping
    @RequestMapping(path = {"/profile"})
    public String profile(Model model, HttpServletRequest request) {
        try {
            visitorService.saveVisitor("profile", requestService.getClientIp(request));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "profile";
    }

    @GetMapping
    @RequestMapping(path = {"/elements"})
    public String elements(Model model, HttpServletRequest request) {
        try {
            visitorService.saveVisitor("elements", requestService.getClientIp(request));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "elements";
    }

    @GetMapping
    @RequestMapping(path = {"/photo"})
    public String photo(Model model, HttpServletRequest request) {
        try {
            visitorService.saveVisitor("photo", requestService.getClientIp(request));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "photo";
    }
}
