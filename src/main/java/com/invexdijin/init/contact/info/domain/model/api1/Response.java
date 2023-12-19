package com.invexdijin.init.contact.info.domain.model.api1;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Response {
    @JsonProperty("data")
    private DataResponse data;
    private Signature signature;
    private String id;
}