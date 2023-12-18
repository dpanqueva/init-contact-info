package com.invexdijin.init.contact.info.application;

import com.invexdijin.init.contact.info.domain.model.ResponseTx;
import com.invexdijin.init.contact.info.infrastructure.model.ContactDto;

@FunctionalInterface
public interface ICaseUseContactMeService {

    ResponseTx saveContactMe(ContactDto contact);

}
