package com.xiexin.springmvc;

import com.xiexin.bean.AdminInfo;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RequestMapping("/admin3")
public class AdminController3 {


    //   第一种  springmvc的 传值方式
    @RequestMapping("/yuansheng")
    public String yuanshi(HttpSession session, HttpServletRequest request){
        System.out.println("原生方式 页面传值");

        String adminName =request.getParameter("adminName");
        String adminPwd =request.getParameter("adminPwd");
        request.setAttribute( "adminName" , adminName);
        request.setAttribute("adminPwd" , adminPwd);
        return "home";
        // request.getReques tDispatcher(home.jsp").forward(request,response); // servlet 的转发
        //return "forward:/WEB-INF/pages/home.jsp"; // springMVC中的转发
        // return "forward:/pages/home"; // springMVC中的转发
        //重定向， servlet.. response. sendredDirect( "/www.baidu.com")重定向携带不了数据
        //return "redirect:https://www. baidu.com"; //不带/和带/区别
        //  return "redirect:/https://www.baidu.com";//不带/和带/区别  http://loca lhost :8080/https://www. baidu. com


    }
    //   第二种  springmvc的 传值方式
    @RequestMapping("/modelAndView")
    public ModelAndView modelAndView(AdminInfo adminInfo){
        ModelAndView mv = new ModelAndView();
        mv.addObject("adminName",adminInfo.getAdminName());
        mv.addObject("adminPwd",adminInfo.getAdminPwd());
        System.out.println("以上是 model的绑定 即 数据的绑定");
        mv.setViewName("home");
        return mv;
    }


    //   第三种  springmvc的 传值方式    model 代码很少
    @RequestMapping("/model")
    public String moedl (AdminInfo adminInfo, Model model){
        model.addAttribute("adminName",adminInfo.getAdminName());
        model.addAttribute("adminPwd",adminInfo.getAdminPwd());
        return  "home";
    }


    //   第四种  springmvc的 传值方式    modelMap
    @RequestMapping("/modelMap")
    public String moedlMap (AdminInfo adminInfo, ModelMap modelMap){
        modelMap.put("adminName",adminInfo.getAdminName());
        modelMap.put("adminPwd",adminInfo.getAdminPwd());
        return  "home";
    }

    //   第五种  springmvc的 传值方式    modelMap
    @RequestMapping("/map")
    public String map (AdminInfo adminInfo, Map map){
        map.put("adminName",adminInfo.getAdminName());
        map.put("adminPwd",adminInfo.getAdminPwd());
        return  "home";
    }
}
