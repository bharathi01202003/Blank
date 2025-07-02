package com.example.controller;

import com.example.dto.MergedResult;
import com.example.service.MergerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/merge")
public class MergerController {

    @Autowired
    private MergerService mergerService;

    @GetMapping
    public List<MergedResult> getMergedResults() {
        return mergerService.getMergedData();
    }
}
