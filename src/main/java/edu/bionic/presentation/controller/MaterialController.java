package edu.bionic.presentation.controller;

import edu.bionic.service.MaterialService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by bm on 27.08.17.
 */
@Controller
@RequestMapping("materials")
public class MaterialController {

    private final int PAGE_SIZE = 5;

    private MaterialService materialService;

//    @Autowired
//    public MaterialController(MaterialService materialService) {
//        this.materialService = materialService;
//    }
//
//    @Autowired
//    public ProductController(ProductService productService, CommentService commentService, OrderService orderService) {
//        this.productService = productService;
//        this.commentService = commentService;
//        this.orderService = orderService;
//    }
//
//    @GetMapping
//    public String showProducts(Model model,
//                               @RequestParam(value = "name", required = false) String name,
//                               @RequestParam(value = "min", required = false) BigDecimal min,
//                               @RequestParam(value = "max", required = false) BigDecimal max,
//                               @RequestParam(value = "productSort", required = false) ProductSort productSort,
//                               @RequestParam(value = "page", defaultValue = "1") int page) {
//        int offset = (page - 1) * PAGE_SIZE;
//        int limit = PAGE_SIZE;
//        if (productSort == null) productSort = ProductSort.NAME_ASC;
//
//        model.addAttribute("products", productService.getAll(name, min, max, productSort, offset, limit));
//        model.addAttribute("productCount", productService.getCount(name, min, max));
//        model.addAttribute("pageSize", PAGE_SIZE);
//        return "product/product-list";
//    }
//
//    @GetMapping("{productId}")
//    public String showProduct(Model model,
//                              @PathVariable("productId") Integer productId) {
//        model.addAttribute(productService.getById(productId));
//        model.addAttribute("comments", commentService.getByProduct(productId));
//        if (!model.containsAttribute("newComment")) {
//            model.addAttribute("newComment", new Comment());
//        }
//        model.addAttribute("dateTimeFormatter", dateTimeFormatter);
//
//        return "product/product";
//    }
//
//    @PostMapping("{productId}/addToBasket")
//    public String addToBasket(@PathVariable("productId") Integer productId,
//                              @SessionAttribute("currentOrder") Order currentOrder) {
//
//        orderService.addProductToOrder(currentOrder, productId);
//
//        return "redirect:/products/" + productId;
//    }
}
