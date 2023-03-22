package com.sevyh.sevyhchatservice.api;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ChatController {
    
    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }
}
