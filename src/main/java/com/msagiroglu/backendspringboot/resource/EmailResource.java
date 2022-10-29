package com.msagiroglu.backendspringboot.resource;

import com.msagiroglu.backendspringboot.captcha.CaptchaValidator;
import com.msagiroglu.backendspringboot.email.EmailServiceImpl;
import com.msagiroglu.backendspringboot.model.Email;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class EmailResource {
    @Autowired
    public EmailServiceImpl emailService;

    @Autowired
    private CaptchaValidator validator;

    @PostMapping("/email/send")
    public ResponseEntity<Email> createMail(@RequestBody Email mailObject, @RequestParam("g-recaptcha-response") String captcha) {
        if(validator.isValidCaptcha(captcha)) {
            try {
                emailService.sendSimpleMessage(mailObject.getName(), mailObject.getText(), mailObject.getEmail());
                return ResponseEntity.ok().body(mailObject);
            } catch (MailException e) {
                log.error(e.getMessage());
                return ResponseEntity.badRequest().body(mailObject);
            }
        } else {
            log.error("Captcha invalid");
            return ResponseEntity.badRequest().body(mailObject);
        }
    }

}
