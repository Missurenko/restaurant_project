package edu.bionic.presentation.controller;

import edu.bionic.domain.Order;
import edu.bionic.domain.my.Checks;
import edu.bionic.util.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute("currentCheck")
    public Checks createBasket() {
        return new Checks();
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFoundException(Model model, Exception ex) {
        model.addAttribute("errorMessage", ex.getMessage() );

        return "notFound";
    }
}
