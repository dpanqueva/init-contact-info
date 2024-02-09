package com.invexdijin.init.contact.info.application;

import com.invexdijin.init.contact.info.infrastructure.model.out.TokenRenew;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "antecedents",
        url = "https://api.verifik.co")
public interface ICaseUseTokenRenew {
    @RequestMapping(method = RequestMethod.POST, value = "/v2/auth/session")
    TokenRenew renewToken(@RequestHeader("Authorization") String bearerToken);

}
