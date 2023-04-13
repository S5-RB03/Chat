package com.sevyh.sevyhchatservice.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sevyh.sevyhchatservice.api.model.ApiResponse;
import com.sevyh.sevyhchatservice.api.model.Message;

@RestController
@RequestMapping("/api/v1/chat")
public class MessageController {

    @GetMapping("/message")
    public ApiResponse<Message> getChatMessageById() {
        Message message = new Message();
        message.setTextContent("Hello World!");
        ApiResponse<Message> response = new ApiResponse<>(true, "Chat message retrieved successfully", message);
        return response;
    }
}