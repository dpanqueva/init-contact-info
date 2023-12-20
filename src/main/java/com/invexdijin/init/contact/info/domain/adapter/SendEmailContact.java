package com.invexdijin.init.contact.info.domain.adapter;

import com.invexdijin.init.contact.info.infrastructure.model.in.ContactDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SendEmailContact {

    @Autowired
    private RestTemplate client;

    @Value("${client.send.email.contact.url}")
    private String url;

    public void sendEmail(ContactDto request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ContactDto> entity = new HttpEntity<>(request, headers);
        client.exchange(url.concat(url), HttpMethod.POST, entity,
                new ParameterizedTypeReference<>() {
                });

    }
}
