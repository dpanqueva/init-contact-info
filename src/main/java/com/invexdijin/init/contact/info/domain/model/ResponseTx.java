package com.invexdijin.init.contact.info.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseTx {

    @JsonProperty("message")
    private String message;
    @JsonProperty("referenceLocator")
    private String referenceLocator;
    @JsonProperty("code")
    private String code;
}
