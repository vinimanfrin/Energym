package com.globalsolution.energym.controllers;

import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class AssistantController {

    @Autowired
    private OpenAiChatClient openAiChatClient;

    @GetMapping
    public ResponseEntity<String> newChat(
            @RequestParam(value = "message",defaultValue = "Olá, boa tarde!") String message){
        return ResponseEntity.ok(openAiChatClient.call(message));
    }
}
