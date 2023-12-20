package com.invexdijin.init.contact.info.application;

import com.invexdijin.init.contact.info.domain.model.ResponseTx;
import com.invexdijin.init.contact.info.infrastructure.model.in.ContactDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContactFacade {

    @Autowired
    private ICaseUseSendEmailContactService contactService;

    @Autowired
    private ICaseUseContactMeService contactMeService;

    public ResponseTx facadeContactMe(ContactDto request) {

        contactService.sendEmailContact(request);

        return contactMeService.saveContactMe(request);

    }
}
