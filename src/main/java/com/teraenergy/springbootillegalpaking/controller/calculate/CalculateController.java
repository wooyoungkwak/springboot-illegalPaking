package com.teraenergy.springbootillegalpaking.controller.calculate;

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
public class CalculateController extends ExtendsController {

    @RequestMapping("/calculate")
    public ModelAndView calculate() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(getPath("/calculate"));
        modelAndView.addObject("title", "불법 주차장");
        return modelAndView;
    }
}
