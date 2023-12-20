package com.invexdijin.init.contact.info.application;

import com.invexdijin.init.contact.info.infrastructure.model.in.InitSearchDto;

@FunctionalInterface
public interface ICaseUseConfirmSearchPeopleService {

    public InitSearchDto confirmSearchPeople(String referenceLocator);
}
