package edu.bionic.presentation.controller;

import edu.bionic.service.CheckService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bm on 27.08.17.
 */
@Controller
@RequestMapping("checks")
public class CheckController {

    private final int PAGE_SIZE = 5;

    private CheckService checkService;

    @Autowired
    public CheckController(CheckService checkService) {
        this.checkService = checkService;
    }

    @GetMapping
    public String showAllChecks(Model model){

        model.addAttribute("checks",checkService.getAll());

        return "check/checks-list";
    }
}
