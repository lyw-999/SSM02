package com.xiexin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pagesRest")
public class PagesRestFulController {

    @RequestMapping("/{path}")
    public  String path(@PathVariable ("path") String path){
        System.out.println("path = " + path);
        return   path;
    }
}
