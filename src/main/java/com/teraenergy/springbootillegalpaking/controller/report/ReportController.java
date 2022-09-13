package com.teraenergy.springbootillegalpaking.controller.report;

import com.teraenergy.springbootillegalpaking.controller.ExtendsController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Date : 2022-03-02
 * Author : zilet
 * Project : sbAdmin
 * Description :
 */
@Controller
public class ReportController extends ExtendsController {

    private String subTitle = "신고";
    
    @RequestMapping("/report")
    public RedirectView report() {
        return new RedirectView("/report/reportList");
    }

    @RequestMapping("/report/reportList")
    public ModelAndView reportList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(getPath("/reportList"));
        modelAndView.addObject("mainTitle", mainTitle);
        modelAndView.addObject("subTitle", subTitle);
        return modelAndView;
    }

}
