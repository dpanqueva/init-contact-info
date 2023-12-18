package com.invexdijin.init.contact.info.infrastructure.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InitSearchDto {
    private String id;

    private String documentType;

    private String documentNumber;

    private String cellphone;

    private String searchType;

    private Date searchDate;

    private PaymentDto payment;


}
