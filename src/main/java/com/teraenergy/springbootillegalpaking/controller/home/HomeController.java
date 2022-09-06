package com.teraenergy.springbootillegalpaking.controller.home;

import com.teraenergy.springbootillegalpaking.controller.ExtendsController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Date : 2022-03-02
 * Author : zilet
 * Project : sbAdmin
 * Description :
 */
@Controller
public class HomeController extends ExtendsController {

    @RequestMapping("/")
    public ModelAndView home_(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(getPath("/home"));
        modelAndView.addObject("title", "");
        return modelAndView;
    }

    @RequestMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(getPath("/home"));
        modelAndView.addObject("title", "Dashboard - SB Admin");
        return modelAndView;
    }

    @RequestMapping("/charts")
    public ModelAndView charts(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(getPath("/charts"));
        modelAndView.addObject("title", "Charts - SB Admin");
        return modelAndView;
    }

    @RequestMapping("/layout-sidenav-light")
    public ModelAndView layout_sidenav_light(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(getPath("/layout-sidenav-light"));
        modelAndView.addObject("title", "Sidenav Light - SB Admin");
        return modelAndView;
    }

    @RequestMapping("/layout-static")
    public ModelAndView layout_static(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(getPath("/layout-static"));
        modelAndView.addObject("title", "Static Navigation - SB Admin");
        return modelAndView;
    }

    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(getPath("/login"));
        modelAndView.addObject("title", "Login - SB Admin");
        return modelAndView;
    }

    @RequestMapping("/password")
    public ModelAndView password(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(getPath("/password"));
        modelAndView.addObject("title", "Password Reset - SB Admin");
        return modelAndView;
    }

    @RequestMapping("/register")
    public ModelAndView register(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(getPath("/register"));
        modelAndView.addObject("title", "Register - SB Admin");
        return modelAndView;
    }

    @RequestMapping("/tables")
    public ModelAndView tables(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(getPath("/tables"));
        modelAndView.addObject("title", "Tables - SB Admin");
        return modelAndView;
    }

}
