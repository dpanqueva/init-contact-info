package com.invexdijin.init.contact.info.domain.service;

import com.invexdijin.init.contact.info.application.ICaseUseContactMeService;
import com.invexdijin.init.contact.info.domain.adapter.ContactMeClient;
import com.invexdijin.init.contact.info.domain.model.ResponseTx;
import com.invexdijin.init.contact.info.infrastructure.model.in.ContactDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaseUseContactMeServiceImpl implements ICaseUseContactMeService {

    @Autowired
    private ContactMeClient contactMeClient;

    @Override
    public ResponseTx saveContactMe(ContactDto contact) {
        return contactMeClient.confirmPeopleClient(contact);
    }
}
