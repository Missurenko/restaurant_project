package edu.bionic.presentation.controller;

import edu.bionic.domain.my.User;
import edu.bionic.service.UserRService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RootController {

    private UserRService userRService;

  
    public RootController(UserRService userRService) {
        this.userRService = userRService;
    }

    @GetMapping("/")
    public String showMainPage() {
        return "index";
    }

    @GetMapping("/login")
    public String loginPage(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/";
        }
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model, Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/";
        }

        model.addAttribute("newUser", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(@Valid @ModelAttribute("newUser") User user,
                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        userRService.registerNewUser(user);
        return "redirect:/";
    }
}