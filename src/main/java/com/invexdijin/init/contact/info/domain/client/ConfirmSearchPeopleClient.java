package com.invexdijin.init.contact.info.domain.client;

import com.invexdijin.init.contact.info.domain.model.ResponseTx;
import com.invexdijin.init.contact.info.infrastructure.model.InitSearchDto;
import com.invexdijin.init.contact.info.infrastructure.model.TriedSearchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ConfirmSearchPeopleClient {

    @Autowired
    private RestTemplate client;

    @Value("${client.tx.init.search.start.url}")
    private String url;

    public InitSearchDto confirmPeopleClient(String referenceLocator){
        String strUrl = "/intention-search-pay".concat("/").concat(referenceLocator);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<TriedSearchDto> entity = new HttpEntity<>(null, headers);
        ResponseEntity<InitSearchDto> response = client.exchange(url.concat(strUrl), HttpMethod.GET, entity,
                new ParameterizedTypeReference<>() {
                });
        return response.getBody();
    }
}
