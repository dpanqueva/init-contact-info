package com.invexdijin.init.contact.info.application;

import com.invexdijin.init.contact.info.domain.adapter.ApiSearchPeopleClient;
import com.invexdijin.init.contact.info.domain.model.api1.Response;
import com.invexdijin.init.contact.info.infrastructure.model.in.InitSearchDto;
import com.invexdijin.init.contact.info.infrastructure.model.in.TriedSearchDto;
import com.invexdijin.init.contact.info.infrastructure.model.out.RsTriedSearchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitSearchFacade {

    @Autowired
    private ApiSearchPeopleClient peopleClient;

    @Autowired
    private ICaseUseInitSearchPeopleService caseUseInitSearchPeopleService;


    public RsTriedSearchDto initIntentionSearchPeople(TriedSearchDto requestSearch) {

        Response infoPeopleName = peopleClient.consultSearchPeople(requestSearch);

        InitSearchDto request = InitSearchDto.builder()
                .cellphone(requestSearch.getCellphone())
                .documentNumber(requestSearch.getDocumentNumber())
                .documentType(requestSearch.getDocumentType())
                .firstName(infoPeopleName.getData().getFirstName())
                .fullName(infoPeopleName.getData().getFullName())
                .searchType(requestSearch.getSearchType())
                .lastName(infoPeopleName.getData().getLastName())
                .build();

        return caseUseInitSearchPeopleService.searchStart(request);

    }


}
