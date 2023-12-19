package com.invexdijin.init.contact.info.domain.service;

import com.invexdijin.init.contact.info.application.ICaseUseConfirmSearchPeopleService;
import com.invexdijin.init.contact.info.domain.adapter.ConfirmSearchPeopleClient;
import com.invexdijin.init.contact.info.infrastructure.exceptions.WithPaymentReferenceException;
import com.invexdijin.init.contact.info.infrastructure.model.InitSearchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaseUseConfirmSearchPeopleServiceServiceImpl implements ICaseUseConfirmSearchPeopleService {

    @Autowired
    private ConfirmSearchPeopleClient confirmSearch;

    @Override
    public String confirmSearchPeople(String referenceLocator) {
        InitSearchDto initSearchDto = confirmSearch.confirmPeopleClient(referenceLocator);
        if(initSearchDto.getPayment() != null){
            throw new WithPaymentReferenceException("This referenceLocator has a reference payment");
        }
        return referenceLocator;
    }
}
