package com.invexdijin.init.contact.info.domain.service;

import com.invexdijin.init.contact.info.application.ICaseUseConfirmStatusPaymentService;
import com.invexdijin.init.contact.info.domain.adapter.ConfirmSearchPeopleClient;
import com.invexdijin.init.contact.info.infrastructure.exceptions.WithOutPaymentReferenceException;
import com.invexdijin.init.contact.info.infrastructure.exceptions.WithPaymentReferenceException;
import com.invexdijin.init.contact.info.infrastructure.model.in.InitSearchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaseUseConfirmStatusPaymentServiceImpl implements ICaseUseConfirmStatusPaymentService {

    @Autowired
    private ConfirmSearchPeopleClient confirmSearch;

    @Override
    public InitSearchDto confirmStatusPayment(String referenceLocator) {
        InitSearchDto initSearchDto = confirmSearch.confirmPeopleClient(referenceLocator);
        if (initSearchDto.getPayment() == null) {
            throw new WithPaymentReferenceException("This referenceLocator has a reference payment");
        }
        if (initSearchDto.getPayment() == null) {
            throw new WithOutPaymentReferenceException("The product does not have a payment reference. Try again.");
        }
        return initSearchDto;
    }
}
