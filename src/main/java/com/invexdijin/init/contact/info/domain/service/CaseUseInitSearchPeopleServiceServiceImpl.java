package com.invexdijin.init.contact.info.domain.service;

import com.invexdijin.init.contact.info.application.ICaseUseInitSearchPeopleService;
import com.invexdijin.init.contact.info.domain.client.TxInitSearchStartClient;
import com.invexdijin.init.contact.info.domain.model.ResponseTx;
import com.invexdijin.init.contact.info.infrastructure.model.TriedSearchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaseUseInitSearchPeopleServiceServiceImpl implements ICaseUseInitSearchPeopleService {

    @Autowired
    private TxInitSearchStartClient client;

    @Override
    public ResponseTx searchStart(TriedSearchDto request) {
        return client.searchStart(request);
    }
}
