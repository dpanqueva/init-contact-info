package com.invexdijin.init.contact.info.domain.adapter;

import com.invexdijin.init.contact.info.domain.model.ResponseTx;
import com.invexdijin.init.contact.info.infrastructure.model.ContactDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ContactMeClient {
    @Autowired
    private RestTemplate client;

    @Value("${client.tx.init.search.start.url}")
    private String url;

    public ResponseTx confirmPeopleClient(ContactDto request) {
        String strUrl = "/contact-me";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ContactDto> entity = new HttpEntity<>(request, headers);
        ResponseEntity<ResponseTx> response = client.exchange(url.concat(strUrl), HttpMethod.POST, entity,
                new ParameterizedTypeReference<>() {
                });
        return response.getBody();
    }
}