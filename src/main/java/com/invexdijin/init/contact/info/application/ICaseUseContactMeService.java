package com.invexdijin.init.contact.info.application;

import com.invexdijin.init.contact.info.domain.model.ResponseTx;
import com.invexdijin.init.contact.info.infrastructure.model.in.ContactDto;

@FunctionalInterface
public interface ICaseUseContactMeService {

    ResponseTx saveContactMe(ContactDto contact);

}
