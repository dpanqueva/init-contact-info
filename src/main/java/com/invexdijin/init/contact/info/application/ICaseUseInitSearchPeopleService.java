package com.invexdijin.init.contact.info.application;

import com.invexdijin.init.contact.info.infrastructure.model.in.InitSearchDto;
import com.invexdijin.init.contact.info.infrastructure.model.out.RsTriedSearchDto;

@FunctionalInterface
public interface ICaseUseInitSearchPeopleService {

    public RsTriedSearchDto searchStart(InitSearchDto request);
}
