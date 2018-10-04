package com.yang.springboottask;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    public void contextLoads() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("通知-今天开会");
        simpleMailMessage.setText("今晚八点开会");
        simpleMailMessage.setTo("sjdajk@qq.com");
        simpleMailMessage.setFrom("1909227160@qq.com");
        mailSender.send(simpleMailMessage);
    }

    @Test
    public void test2(){
        //创建一个复杂消息邮件
        MimeMessage mimeMailMessage = mailSender.createMimeMessage();


    }

}
