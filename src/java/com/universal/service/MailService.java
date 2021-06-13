package com.universal.service;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailService {

    public void sendVerifyMail(String to, String name, int otp)
    {
        try 
        {
            String from = "akashjain250599@gmail.com";
            String pass = "Akash250599";

            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    //char  password[] = "9009557337".toCharArray();
                    return new PasswordAuthentication(from, pass);//change accordingly
                }
            });

          
                System.out.println("Inside try called...");
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(from));//change accordingly

                System.out.println("After From ");
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

                message.setSubject("College Quera Email Verification");
                System.out.println("After Thank you");

                String msg = "<h1>College Quera Email Verification </h1>"
                        + "<hr>"
                        + "Hello <b>" + name + "</b>,<br><br>"
                        + "Your registeration on College Quera is Done Successfully."
                        + "Please Verify your Email with this OTP : <b>" + otp + "</b>.";

                System.out.println("After Thank You");

                message.setContent(msg, "text/html");
                Transport.send(message);
                System.out.println("message sent successfully");

            }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
