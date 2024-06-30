package com.assessment.maybank.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Tag(name = "Welcome", description = "Welcome API")
public class WelcomeController {
    //ttest
    @RequestMapping("/")
    public @ResponseBody String greeting() {
        return "Hello, World s";
    }

}
