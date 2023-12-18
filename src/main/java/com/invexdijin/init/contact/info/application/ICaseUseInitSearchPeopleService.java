package com.invexdijin.init.contact.info.application;

import com.invexdijin.init.contact.info.domain.model.ResponseTx;
import com.invexdijin.init.contact.info.infrastructure.model.TriedSearchDto;

@FunctionalInterface
public interface ICaseUseInitSearchPeopleService {

    public ResponseTx searchStart(TriedSearchDto request);
}
