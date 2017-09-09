package edu.bionic.presentation.controller;

import edu.bionic.domain.my.Checks;
import edu.bionic.service.CheckService;
import edu.bionic.service.UserRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

/**
 * Created by bm on 27.08.17.
 */
@Controller
@SessionAttributes("currentCheck")
@RequestMapping("checks")
public class CheckController {

    private final int PAGE_SIZE = 5;

    private CheckService checkService;

    private UserRService userRService;

    @Autowired
    public CheckController(CheckService checkService, UserRService userRService) {
        this.checkService = checkService;
        this.userRService = userRService;
    }

    @GetMapping
    public String showChecksForUser(Model model) {

            model.addAttribute("checks", checkService.getAllByAuthUser());
//            model.addAttribute("dateTimeFormatter", dateTimeFormatter);

        return "checks/check-list";
    }

    @GetMapping("newCheck")
    public String showNewOrderPage(@ModelAttribute("currentCheck") Checks check) {
        userRService.getAuthenticatedUser().ifPresent(user -> {
            check.setName(user.getName());
            check.setEmail(user.getEmail());
        });

        return "checks/newCheck";
    }

    @PostMapping("newCheck")
    public String submitNewOrder(@Valid @ModelAttribute("currentCheck") Checks newCheck,
                                 BindingResult bindingResult,
                                 SessionStatus sessionStatus) {
        if (bindingResult.hasErrors()) {
            return "checks/newCheck";
        }
        checkService.createNewCheck(newCheck);
        sessionStatus.setComplete();

        return "redirect:/checks/success";
    }

    @PostMapping("newCheck/delete")
    public String removeItemFromCheck(@SessionAttribute("currentCheck") Checks currentCheck,
                                      @RequestParam("index") Integer index) {
        checkService.removeProductFromCheck(currentCheck, index);

        return "redirect:/checks/newCheck";
    }

    @GetMapping("success")
    public String successCreatedOrderPage() {
        return "checks/checkCreated";
    }
}

