package ru.itis.spring_test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetSearchController {

    @GetMapping("/search")
    public String getSearchPage() {
        return "ajax";
    }
}
