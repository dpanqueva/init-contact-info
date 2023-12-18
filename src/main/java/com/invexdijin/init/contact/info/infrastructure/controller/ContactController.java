package com.invexdijin.init.contact.info.infrastructure.controller;

import com.invexdijin.init.contact.info.application.ICaseUseContactMeService;
import com.invexdijin.init.contact.info.infrastructure.model.ContactDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/invexdijin")
public class ContactController {

    @Autowired
    private ICaseUseContactMeService contactMeService;

    @PostMapping("/contact-me")
    public ResponseEntity<Map<String, Object>> saveContactMe(@Valid @RequestBody ContactDto contact
            , BindingResult result) {
        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream()
                    .map(err -> err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("error", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        contactMeService.saveContactMe(contact);
        response.put("message", "Thank you for writing to us, an advisor will contact you.");
        response.put("code", "sweet-alert-registered-contact");

        return ResponseEntity.created(URI.create("/api/v1/invexdijin/contact-me")).body(response);

    }
}
