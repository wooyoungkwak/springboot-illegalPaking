package com.teraenergy.springbootillegalpaking.controller.area;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teraenergy.springbootillegalpaking.controller.ExtendsController;
import com.teraenergy.springbootillegalpaking.model.entity.parking.domain.Parking;
import com.teraenergy.springbootillegalpaking.model.entity.parking.service.ParkingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

    private final ParkingService parkingService;

    @GetMapping("/area")
    public ModelAndView area(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(getPath("/area"));
        modelAndView.addObject("title", "불법 주차장");
        return modelAndView;
    }

    @GetMapping("/area/map")
    public ModelAndView map(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(getPath("/map"));
        modelAndView.addObject("title", "불법 주차장");
        return modelAndView;
    }

    @GetMapping("/area/areaList")
    public ModelAndView areaList(){
        ModelAndView modelAndView = new ModelAndView();
        List<Parking> parkings = parkingService.gets();

        modelAndView.setViewName(getPath("/areaList"));
        modelAndView.addObject("title", "불법 주차장");
        modelAndView.addObject("parkings", parkings);
        return modelAndView;
    }

    @GetMapping("/area/areaAdd")
    public ModelAndView areaAdd(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(getPath("/areaAdd"));
        modelAndView.addObject("title", "불법 주차장");
        return modelAndView;
    }

}
