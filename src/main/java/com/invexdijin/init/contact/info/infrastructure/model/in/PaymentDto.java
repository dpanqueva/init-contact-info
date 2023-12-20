package com.invexdijin.init.contact.info.infrastructure.model.in;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentDto {

    private Long id;


    private String paymentName;


    private String paymentLastName;


    private String paymentEmail;


    private String paymentDocumentType;


    private String paymentDocumentNumber;


    private String paymentContact;


    private String paymentSignature;


    private String paymentStatus;

    private Date paymentDate;


}
