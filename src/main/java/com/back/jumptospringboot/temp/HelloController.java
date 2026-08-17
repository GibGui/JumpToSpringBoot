package com.back.jumptospringboot.temp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello SBB";
    }

    @GetMapping("/sbb")
    public String sbb(){
        return "Sbb라고!!";
    }
}
