package com.amandaw.covid19statistics.controller;

import com.amandaw.covid19statistics.entity.AreaState;
import com.amandaw.covid19statistics.service.DataFetchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    DataFetchService dataFetchService;

    @RequestMapping("/")
    public ModelAndView index() throws IOException, InterruptedException {
        ModelAndView modelAndView = new ModelAndView();
        List<AreaState> areaStates = dataFetchService.FetchData();
        modelAndView.addObject("all_info",areaStates);
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
