package edu.bionic.presentation.controller;

import edu.bionic.service.MaterialService;
import edu.bionic.service.ProductRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bm on 27.08.17.
 */
@Controller
@RequestMapping("productsR")
public class ProductRController {

    private final int PAGE_SIZE = 5;

    private ProductRService productService;

    @Autowired
    public ProductRController(ProductRService productService) {
        this.productService = productService;
    }



    @GetMapping
    public String showAllproduct(Model model){

        model.addAttribute("products",productService.getAll());


        return "productR/product-list";
    }
}
