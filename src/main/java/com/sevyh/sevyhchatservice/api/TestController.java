package com.sevyh.sevyhchatservice.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sevyh.sevyhchatservice.api.model.ApiResponse;

@RestController
public class TestController {
    @GetMapping("/ping")
    public ApiResponse<String> ping() {
        ApiResponse<String> response = new ApiResponse<>(true, "pong", "pong");
        return response;
    }
}
