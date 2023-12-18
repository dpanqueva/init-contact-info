package com.invexdijin.init.contact.info.infrastructure.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
