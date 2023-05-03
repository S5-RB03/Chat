package com.sevyh.sevyhchatservice.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sevyh.sevyhchatservice.api.model.ApiResponse;
import com.sevyh.sevyhchatservice.api.model.Message;
import com.sevyh.sevyhchatservice.service.MessageService;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/chat")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/message")
    public ApiResponse<List<Message>> getMessages(
            @RequestParam UUID senderId,
            @RequestParam UUID receiverId,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "pageSize", defaultValue = "25") int pageSize
    ) {
        List<Message> messages = messageService.getPaginatedMessages(senderId, receiverId, page, pageSize);
        ApiResponse<List<Message>> response = new ApiResponse<>(true, "Chat messages retrieved successfully", messages);
        return response;
    }

    @PostMapping("/message")
    public ApiResponse<Message> postChatMessage(@RequestBody Message message) {
        messageService.saveMessage(message);

        ApiResponse<Message> response = new ApiResponse<>(true, "Chat message posted successfully", message);

        return response;
    }
}