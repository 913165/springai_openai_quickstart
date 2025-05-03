package com.example.demochatquickstart.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    ChatClient chatClient;

    public ChatService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String getChatResponse(String message) {
        return chatClient.prompt(message)
                .call()
                .chatResponse()
                .getResult()
                .getOutput()
                .getText();
    }
}
