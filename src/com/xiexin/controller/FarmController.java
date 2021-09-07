package com.xiexin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/farm")
public class FarmController {


    @RequestMapping("/buy")
    @ResponseBody
    public Map buy(@RequestBody Map map){
        System.out.println("map = " + map);
        System.out.println("map的name " + map.get("name"));
        System.out.println("map的price " + map.get("price"));
        System.out.println("map的count " + map.get("count"));
        Map codeMap = new HashMap();
        codeMap.put("code",0);
        codeMap.put("msg","购买成功");
        codeMap.put("data", map);
        return codeMap;
    }


}
