package com.api.controller;
import java.util.List;
import java.util.Map;
import com.api.gmailservice.impl.GmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/gmail")
public class GmailController {
    @Autowired
    private GmailServiceImpl gmailService;

    @GetMapping
    public ResponseEntity<?> getData() {
        List<Map<String, String>> mail = gmailService.getMail();
        return ResponseEntity.status(HttpStatus.OK).body(mail);
    }
}