package co.com.sofka.questions.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class SendEmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    private final String FROM = "josedavidsofkau@gmail.com";

    public SendEmailService() {
    }

    public Mono<String> sendEmail(String to, String subject, String body){

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        System.out.println("ESTO ES DE CONTROL!!!!!!!!!!!!!!!");
        System.out.println(to);

        String message = "Someone added an answer to your question " + body;

        simpleMailMessage.setFrom(FROM);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);

        javaMailSender.send(simpleMailMessage);

        return Mono.just("¡Send!");
    }
}
