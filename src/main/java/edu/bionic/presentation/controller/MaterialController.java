package edu.bionic.presentation.controller;

import edu.bionic.dto.MaterialSort;
import edu.bionic.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by bm on 27.08.17.
 */
@Controller
@RequestMapping("materials")
public class MaterialController {

    private final int PAGE_SIZE = 5;

    private MaterialService materialService;

    @Autowired
    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }


    // TODO ask about required = false
    @GetMapping
    public String showAllMaterial(Model model){



        return "material/material-list";
    }
}
