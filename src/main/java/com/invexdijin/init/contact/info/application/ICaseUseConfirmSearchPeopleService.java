package com.invexdijin.init.contact.info.application;

import com.invexdijin.init.contact.info.infrastructure.model.TriedSearchDto;

@FunctionalInterface
public interface ICaseUseConfirmSearchPeopleService {

    public String confirmSearchPeople(String referenceLocator);
}
