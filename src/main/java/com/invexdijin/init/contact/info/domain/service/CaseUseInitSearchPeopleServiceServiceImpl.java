package com.invexdijin.init.contact.info.domain.service;

import com.invexdijin.init.contact.info.application.ICaseUseInitSearchPeopleService;
import com.invexdijin.init.contact.info.domain.adapter.TxInitSearchStartClient;
import com.invexdijin.init.contact.info.infrastructure.model.in.InitSearchDto;
import com.invexdijin.init.contact.info.infrastructure.model.in.TriedSearchDto;
import com.invexdijin.init.contact.info.infrastructure.model.out.RsTriedSearchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaseUseInitSearchPeopleServiceServiceImpl implements ICaseUseInitSearchPeopleService {

    @Autowired
    private TxInitSearchStartClient client;

    @Override
    public RsTriedSearchDto searchStart(InitSearchDto request) {
        return client.searchStart(request);
    }
}
