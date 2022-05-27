package com.controller;

import com.repository.DetailTransRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/detail")
public class DetailTransController {
    private final DetailTransRepository detailTransRepository;

    public DetailTransController(DetailTransRepository detailTransRepository) {
        this.detailTransRepository = detailTransRepository;
    }
}
