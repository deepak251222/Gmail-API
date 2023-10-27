package com.api.gmailservice.impl;

import com.api.gmailservice.GmailService;
import jakarta.mail.Folder;
import jakarta.mail.Message;
import jakarta.mail.Session;
import jakarta.mail.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class GmailServiceImpl implements GmailService {
    @Autowired
    private Environment env;
    @Override
    public List<Map<String, String>> getMail() {
        List<Map<String, String>> list = new ArrayList<>();
       String host = env.getProperty("spring.mail.host");
        String username =env.getProperty("spring.mail.username");
        String password=env.getProperty("spring.mail.password");
        int numberOfEmailsToRetrieve = 200;
        Properties properties = new Properties();
        properties.put("mail.store.protocol", "imaps");
        properties.put("mail.imaps.host", host);
        properties.put("mail.imaps.port", "993");
        try {
            Session session = Session.getDefaultInstance(properties);
            Store store = session.getStore("imaps");
            store.connect(host, username, password);
            Folder sentFolder = store.getFolder("[Gmail]/Sent Mail");
            if (sentFolder == null) {
                return list;
            }
            sentFolder.open(Folder.READ_ONLY);
            int totalEmails = sentFolder.getMessageCount();
            int start = Math.max(1, totalEmails - numberOfEmailsToRetrieve + 1);
            int end = totalEmails;
            Message[] messages = sentFolder.getMessages(start, end);
            for (Message message : messages) {
                String sender = message.getFrom()[0].toString();
                String subject = message.getSubject();
                Map<String, String> map = new HashMap<>();
                map.put("Sender", sender);
                map.put("Subject", subject);
                list.add(map);
            }
            sentFolder.close(false);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("service 1");
        return list;
    }
}
