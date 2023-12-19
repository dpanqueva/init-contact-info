package com.invexdijin.init.contact.info.application;

import com.invexdijin.init.contact.info.domain.adapter.ApiSearchPeopleClient;
import com.invexdijin.init.contact.info.domain.model.ResponseTx;
import com.invexdijin.init.contact.info.domain.model.api1.Response;
import com.invexdijin.init.contact.info.infrastructure.model.TriedSearchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitSearchFacade {

    @Autowired
    private ApiSearchPeopleClient peopleClient;

    @Autowired
    private ICaseUseInitSearchPeopleService caseUseInitSearchPeopleService;


    public ResponseTx initIntentionSearchPeople(TriedSearchDto request) {

        Response infoPeopleName = peopleClient.consultSearchPeople(request);

        request.setFirstName(infoPeopleName.getData().getFirstName());
        request.setLastName(infoPeopleName.getData().getLastName());
        request.setFullName(infoPeopleName.getData().getFullName());

        return caseUseInitSearchPeopleService.searchStart(request);

    }


}
