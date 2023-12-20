package com.invexdijin.init.contact.info.application;

import com.invexdijin.init.contact.info.infrastructure.model.in.ContactDto;

@FunctionalInterface
public interface ICaseUseSendEmailContactService {

    void sendEmailContact(ContactDto request);
}
