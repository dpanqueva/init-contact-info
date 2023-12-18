package com.invexdijin.init.contact.info.infrastructure.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TriedSearchDto {


    @NotNull(message = "search-message-error-contact-number")
    @NotBlank(message = "search-message-error-contact-number")
    @NotEmpty(message = "search-message-error-contact-number")
    @Size(min = 2, message = "document-type-min-length")
    private String documentType;

    @NotNull(message = "search-message-error-document-number")
    @NotBlank(message = "search-message-error-document-number")
    @NotEmpty(message = "search-message-error-document-number")
    @Size(min = 5, message = "search-message-error-minlengh-document")
    @Size(max = 10, message = "search-message-error-maxlengh-document")
    private String documentNumber;
    @NotNull(message = "search-message-error-contact-number")
    @NotBlank(message = "search-message-error-contact-number")
    @NotEmpty(message = "search-message-error-contact-number")
    @Pattern(regexp = "\\d+", message = "search-message-error-just-number-contact-number")
    @Size(max = 10, message = "search-message-error-maxlengh-contact-number")
    @Size(min = 7, message = "search-message-error-minlengh-contact-number")
    private String cellphone;
    @NotNull(message = "search-type-bad-request")
    @NotBlank(message = "search-type-bad-request")
    @NotEmpty(message = "search-type-bad-request")
    private String searchType;
}
