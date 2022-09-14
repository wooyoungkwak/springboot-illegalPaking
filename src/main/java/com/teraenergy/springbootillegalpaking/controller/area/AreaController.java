package com.teraenergy.springbootillegalpaking.controller.area;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teraenergy.springbootillegalpaking.controller.ExtendsController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Date : 2022-03-02
 * Author : zilet
 * Project : sbAdmin
 * Description :
 */

@RequiredArgsConstructor
@Controller
public class AreaController extends ExtendsController {

    private final ObjectMapper objectMapper;

    private String subTitle = "불법주정차 구역";

    @GetMapping("/area")
    public RedirectView area(){
        return new RedirectView("/area/map");
    }

    @GetMapping("/area/map")
    public ModelAndView map(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(getPath("/map"));
        modelAndView.addObject("mainTitle", mainTitle);
        modelAndView.addObject("subTitle", subTitle);
        return modelAndView;
    }



}
