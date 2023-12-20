package com.invexdijin.init.contact.info.infrastructure.model.in;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InitSearchDto {
    private String id;

    private String documentType;

    private String documentNumber;

    private String cellphone;

    private String searchType;

    private Date searchDate;

    private String firstName;

    private String lastName;

    private String fullName;

    private PaymentDto payment;


}
