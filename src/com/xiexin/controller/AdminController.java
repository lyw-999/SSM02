package com.xiexin.controller;

import com.xiexin.bean.AdminInfo;
import com.xiexin.bean.Dog;
import com.xiexin.bean.Lover;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/api/admin")
public class AdminController {
        //注册成功后，如果 是单体项目----就要跳转到登陆页面，这 个跳转是后台的转发，重定向，总之是
        //后台负责跳转，携带 数据的跳转页面的
        // 如果是新型的项目， 即前后端分离的， 那么后台只负责返回给前端json 数据,
        // 跳转是前端来处理的， 前端根据后台返回code代码，进行跳转，
        // 如果前端负责跳转，他会起一- 个好听的名字，叫做路由!
             //什么是前后端分离即:项目 上的分离.和数据上的分离
            //项目上的分离:前端- 一个项目，后台- 一个项目... 2 项目。他们的认证 是token/ jwt + redis
            //.数据上:的分离:还是一 一个项目，只不过 前后端用json来交互数据。
            //.... 很少在用jstl/ el表达式来写项目。 他们的认证是  session


            //layui在ssm框架中的 使用 其实就是 数据上的分离,也可以是项目上的分离。
            // 那么他就是json交互的  那么后台 只需要给他返回json数据就可以了.


    @RequestMapping("/reg")
    public Map reg(String adminName,String adminPwd ,String adminPwdR,String adminTime) {
        Map codeMap = new HashMap();
        System.out.println("adminTime = " + adminTime);
        if (!adminPwd.equals(adminPwdR)) {
            codeMap.put("code", "4001");
            codeMap.put("msg", "两次密码输入不一致,注册失败");
            return codeMap;
        }
        if (adminName.length() <= 0) {
            codeMap.put("code", "4002");
            codeMap.put("msg", "你的注册表单需要填写完整,注册失败");
            return codeMap;
        }
        if (adminPwd.length() <= 0) {
            codeMap.put("code", "4002");
            codeMap.put("msg", "你的注册表单需要填写完整,注册失败");
            return codeMap;
        }
        codeMap.put("code", 0);
        codeMap.put("msg", " 注册成功");
        return codeMap;
    }


    @RequestMapping("/regForm")
    public String regForm(String adminName,String adminPwd ){
        System.out.println("adminName = " + adminName);
        System.out.println("adminPwd = " + adminPwd);
        return "loginForm";
    }
    // springmvc 第二种收参数方式 用的叫做 实体类收参数
    @RequestMapping("/regByBean")
    @ResponseBody
    public Map regByBean(AdminInfo adminInfo){
        System.out.println("adminInfo = " + adminInfo);
        Map codeMap = new HashMap();
        codeMap.put("code",0);
        codeMap.put("msg","注册成功");
        return codeMap;
    }

    @RequestMapping("/regAll")
    @ResponseBody
    public Map regAll(String adminName, String adminPwd, String adminTime, HttpServletRequest request, String sex, String city, String type){
        System.out.println("adminName = " + adminName);
        System.out.println("adminPwd = " + adminPwd);
        System.out.println("adminTime = " + adminTime);
        System.out.println("sex = " + sex);
        String[] hobbys=request.getParameterValues("hobby");
        for (String hobby : hobbys) {
            System.out.println("hobby = " + hobby);
        }
        System.out.println("city = " + city);
        System.out.println("type = " + type);
        Map codeMap = new HashMap();
        codeMap.put("code",0);
        codeMap.put("msg","注册成功");
        return codeMap;

    }

    // ajax 接受 数组/集合
    @RequestMapping("/ajax03")
    @ResponseBody           //  当前后短参数不一样的时候 就需要 使用注解调整
    public Map ajax03(@RequestParam("ids[]") List<Integer> ids){
        for (Integer id : ids) {
            System.out.println("id = " + id);
        }
        Map codeMap = new HashMap();
        codeMap.put("code",0);
        codeMap.put("msg","请求访问成功");
        codeMap.put("data",ids);
        return codeMap;
    }
    // ajax 接收 JSON 对象
    @RequestMapping("/ajax04")
    @ResponseBody                                         //@ResponseBody  就是后台给前端发送 json不跳转用ajax请求
    public Map ajax04(@RequestBody AdminInfo adminInfo){  //@RequestBody   注解就是指前端json请求
        System.out.println("adminInfo = " + adminInfo);
        Map codeMap = new HashMap();
        codeMap.put("code",0);
        codeMap.put("msg","请求访问成功");
        codeMap.put("data",adminInfo);
        return codeMap;
    }

    // ajax 接收 前端多个对象
    @RequestMapping("/ajax05")
    @ResponseBody
    public Map ajax05(@ModelAttribute Lover lover, @ModelAttribute Dog dog){  //@RequestBody注解就是指前端json请求
        System.out.println("lover = " + lover);
        System.out.println("dog = " + dog);
        Map codeMap = new HashMap();
        codeMap.put("code",0);
        codeMap.put("msg","请求访问成功");
        codeMap.put("data1", lover);
        codeMap.put("data2", dog);
        return codeMap;
    }

    //前端传来的多个对象 需要根据请求的前缀进行绑定
      @InitBinder("lover")
    public void bangding01(WebDataBinder webDataBinder){ // webDataBinder 网络数据绑定
        webDataBinder.setFieldDefaultPrefix("lover.");     //设置前缀 lover.name :薛老师
      }
    @InitBinder("dog")
    public void bangding02(WebDataBinder webDataBinder){
        webDataBinder.setFieldDefaultPrefix("dog.");
    }

    //  ajax06 json 收取多个对象
    @RequestMapping("/ajax06")
    @ResponseBody           // @GetMapping 和 @RequestBody 同时使用 等着被开除
    public Map ajax06(@RequestBody List<Lover> loverList){
        for (Lover lover : loverList) {
            System.out.println("lover = " + lover);
        }
        Map codeMap = new HashMap();
        codeMap.put("code",0);
        codeMap.put("msg","请求访问成功");
        codeMap.put("data", loverList);
        return codeMap;
    }

    @RequestMapping("/ajax07")
    @ResponseBody           // 很常用的    多表的动态参数 就是用的map
    public Map ajax07(@RequestBody Map map){
        System.out.println("map = " + map);
        System.out.println("map的adminName  = " + map.get("adminName"));
        Map codeMap = new HashMap();
        codeMap.put("code",0);
        codeMap.put("msg","请求访问成功");
        codeMap.put("data", map);
        return codeMap;
    }


    @RequestMapping("/ajax08")
    @ResponseBody           // 很常用的    动态的分页查询
    public Map ajax08(Lover lover ,@RequestParam(value = "limit" ,required = false,defaultValue = "6")Integer pageSize,Integer page){
        System.out.println("lover = " + lover);
        System.out.println("page = " + page);
        System.out.println("pageSize = " + pageSize);
        return null;
    }



    //   第一种  springmvc的 传值方式
    @RequestMapping("/yuanshi")
    public String yuanshi(HttpSession session,HttpServletRequest request){
	        System.out.println("原生方式 页面传值");
        // System. out. println( "adminInfo =”+ adminInfo);
        //. 登录如果 验证成功，那么就需要把 登录信息放入到session城当中
        // session. setAttribute( "adminInfo", adminInfo);

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
        //  model 和视图 通俗就是 数据和显示  ModelAndView  可以代替 转发功能  更强大了
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

    //   第五种  springmvc的 传值方式    map
    @RequestMapping("/map")
    public String map (AdminInfo adminInfo,Map map){
        map.put("adminName",adminInfo.getAdminName());
        map.put("adminPwd",adminInfo.getAdminPwd());
        return  "home";
    }
}
