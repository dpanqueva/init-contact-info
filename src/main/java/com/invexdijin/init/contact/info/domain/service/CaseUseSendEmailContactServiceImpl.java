package com.invexdijin.init.contact.info.domain.service;

import com.invexdijin.init.contact.info.application.ICaseUseSendEmailContactService;
import com.invexdijin.init.contact.info.domain.adapter.SendEmailContact;
import com.invexdijin.init.contact.info.infrastructure.model.in.ContactDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaseUseSendEmailContactServiceImpl implements ICaseUseSendEmailContactService {

    @Autowired
    private SendEmailContact sendEmailContact;

    @Override
    public void sendEmailContact(ContactDto request) {
        sendEmailContact.sendEmail(request);
    }
}
