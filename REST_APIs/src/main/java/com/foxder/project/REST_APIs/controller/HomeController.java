package com.foxder.project.REST_APIs.controller;

import com.foxder.project.REST_APIs.model.App;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private final App app;

    public HomeController(App app) {
        this.app = app;
    }

    //Get App information.
    @GetMapping
    public App getApp() {

        return app;
    }
}
