package com.invexdijin.init.contact.info.domain.adapter;

import com.invexdijin.init.contact.info.domain.model.ResponseTx;
import com.invexdijin.init.contact.info.infrastructure.model.TriedSearchDto;
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


    public ResponseTx searchStart(TriedSearchDto request) {

            String strUrl = "/init-search-people";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<TriedSearchDto> entity = new HttpEntity<>(request, headers);
            ResponseEntity<ResponseTx> response = client.exchange(url.concat(strUrl), HttpMethod.POST, entity,
                    new ParameterizedTypeReference<>() {
                    });
            return response.getBody();

    }
}
