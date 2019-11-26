package com.apress.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wei on 2019-11-23.
 */
@RestController
public class WebController {
   @GetMapping
   public String index() {
       return "Hello String Boot";
   }
}

