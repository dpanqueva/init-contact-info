package com.invexdijin.init.contact.info.domain.adapter;

import com.invexdijin.init.contact.info.application.ICaseUseTokenRenew;
import com.invexdijin.init.contact.info.domain.model.api1.Response;
import com.invexdijin.init.contact.info.infrastructure.model.in.TriedSearchDto;
import com.invexdijin.init.contact.info.infrastructure.model.out.TokenRenew;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@Slf4j
public class ApiSearchPeopleClient {


    @Autowired
    private RestTemplate client;

    @Autowired
    private ICaseUseTokenRenew iCaseUseTokenRenew;

    @Value("${client.api1.search.people.url}")
    private String url;

    @Value("${client.api1.token.key}")
    private String token;

@SneakyThrows
    public Response consultSearchPeople(TriedSearchDto request) {

        try{
            TokenRenew tokenRenew = iCaseUseTokenRenew.renewToken(token);
            token = "Bearer "+tokenRenew.getAccessToken();
        }catch (Exception ex){
            log.error("Failed request to token renew service");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer ".concat(token));
        String finalUrl = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("documentType", request.getDocumentType())
                .queryParam("documentNumber", request.getDocumentNumber())
                .toUriString();

        RequestEntity<?> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, new URI(finalUrl));
        ResponseEntity<Response> responseEntity = new RestTemplate().exchange(requestEntity, Response.class);

        return responseEntity.getBody();

    }

}
