package edu.bionic.presentation.controller;

import edu.bionic.service.MaterialService;
import edu.bionic.service.UserRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bm on 27.08.17.
 */
@Controller
@RequestMapping("usersR")
public class UserRController {

    private final int PAGE_SIZE = 5;

    private UserRService userRService;

    @Autowired
    public UserRController(UserRService userRService) {
        this.userRService = userRService;
    }



    @GetMapping
    public String showAllMaterial(Model model){

        model.addAttribute("users",userRService.getAuthenticatedUser());

        return "user/user-list";
    }
}
