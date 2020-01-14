package ch.heigvd.amt.authentication.api.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailService")
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    //constructor
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender =  javaMailSender;
    }

    /**
     * @Brief : envoie le un mail a un utilisateur
     * @param toEmail : adresse email de reception du mail
     * @param subject : object du mail
     * @param message : contenu du mail
     */
    public void sendMail(String toEmail, String subject, String message) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(toEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        //set l'expediteur des mails
        mailMessage.setFrom("amtprojet2@gmail.com");
        javaMailSender.send(mailMessage);
    }
}
