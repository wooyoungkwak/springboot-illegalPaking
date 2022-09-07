package com.teraenergy.springbootillegalpaking.controller.area;

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
public class AreaController extends ExtendsController {

    @RequestMapping("/area")
    public ModelAndView area(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(getPath("/area"));
        modelAndView.addObject("title", "불법 주차장");
        return modelAndView;
    }

    @RequestMapping("/area/map")
    public ModelAndView map(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(getPath("/map"));
        modelAndView.addObject("title", "불법 주차장");
        return modelAndView;
    }

    @RequestMapping("/area/areaList")
    public ModelAndView areaList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(getPath("/areaList"));
        modelAndView.addObject("title", "불법 주차장");
        return modelAndView;
    }

    @RequestMapping("/area/areaAdd")
    public ModelAndView areaAdd(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(getPath("/areaAdd"));
        modelAndView.addObject("title", "불법 주차장");
        return modelAndView;
    }

}
