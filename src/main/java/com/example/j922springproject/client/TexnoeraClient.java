package com.example.j922springproject.client;

import com.example.j922springproject.model.client.LessonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(
        name = "texnoera-spring-example",
        url = "http://localhost:8080",
        configuration = TexnoeraClientErrorDecoder.class
)
public interface TexnoeraClient {
    @GetMapping("/v1/lessons")
    List<LessonResponse> getLessons();

    @PostMapping("/v1/mails")
    void sendMail(@RequestBody MailDto dto);
}

class MailDto{
    String to;
    String subject;
}
