package com.invexdijin.init.contact.info.infrastructure.model.in;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
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
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "search-message-error-document-number")
    private String documentNumber;
    @NotNull(message = "search-message-error-contact-number")
    @NotBlank(message = "search-message-error-contact-number")
    @NotEmpty(message = "search-message-error-contact-number")
    @Pattern(regexp = "^([\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}|^\\d{10})$", message = "search-message-error-just-number-contact-number")
    private String cellphone;
    @NotNull(message = "search-type-bad-request")
    @NotBlank(message = "search-type-bad-request")
    @NotEmpty(message = "search-type-bad-request")
    private String searchType;
    @NotNull(message = "search-terms-conditions-bad-request")
    @NotBlank(message = "search-terms-conditions-bad-request")
    @NotEmpty(message = "search-terms-conditions-bad-request")
    private boolean termsConditions;

}
