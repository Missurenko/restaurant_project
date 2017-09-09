package edu.bionic.presentation.controller;

import edu.bionic.domain.my.Category;
import edu.bionic.domain.my.Checks;
import edu.bionic.service.CheckService;
import edu.bionic.service.ProductRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by bm on 27.08.17.
 */
@Controller
@RequestMapping("productsR")
@SessionAttributes("currentCheck")
public class ProductRController {

    private final int PAGE_SIZE = 6;

    private ProductRService productService;

    private CheckService checkService;

    @Autowired
    public ProductRController(ProductRService productService, CheckService checkService) {
        this.productService = productService;
        this.checkService = checkService;
    }

    @GetMapping
    public String showAllproduct(Model model,
                                 @RequestParam(value = "name", required = false) String name,
                                 @RequestParam(value = "category", required = false) Category categoty,
                                 @RequestParam(value = "page", defaultValue = "1") int page) {

        int offset = (page - 1) * PAGE_SIZE;
        int limit = PAGE_SIZE;

        model.addAttribute("products", productService.getAll(categoty, name, offset, limit));
        model.addAttribute("productCount", productService.getCount(categoty, name));
        model.addAttribute("pageSize", PAGE_SIZE);

        return "productR/product-list";
    }

    @GetMapping("{productId}")
    public String showProduct(Model model,
                              @PathVariable("productId") Integer productId) {
        model.addAttribute(productService.getById(productId));
        return "productR/product";
    }

    @PostMapping("{productId}/addToCheck")
    public String addToCheck(@PathVariable("productId") Integer productId,
                             @SessionAttribute("currentCheck") Checks currentCheck) {

        checkService.addProductToCheck(currentCheck, productId);

        return "redirect:/productsR/" + productId;
    }
}
