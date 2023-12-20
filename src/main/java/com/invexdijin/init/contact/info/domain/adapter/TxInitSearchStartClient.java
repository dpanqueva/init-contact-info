package com.invexdijin.init.contact.info.domain.adapter;

import com.invexdijin.init.contact.info.infrastructure.model.in.InitSearchDto;
import com.invexdijin.init.contact.info.infrastructure.model.in.TriedSearchDto;
import com.invexdijin.init.contact.info.infrastructure.model.out.RsTriedSearchDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class TxInitSearchStartClient {

    @Autowired
    private RestTemplate client;

    @Value("${client.tx.init.search.start.url}")
    private String url;


    public RsTriedSearchDto searchStart(InitSearchDto request) {

            String strUrl = "/init-search-people";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<InitSearchDto> entity = new HttpEntity<>(request, headers);
            ResponseEntity<RsTriedSearchDto> response = client.exchange(url.concat(strUrl), HttpMethod.POST, entity,
                    new ParameterizedTypeReference<>() {
                    });
            return response.getBody();

    }
}
