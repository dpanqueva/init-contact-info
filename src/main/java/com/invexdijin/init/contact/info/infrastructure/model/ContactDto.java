package com.invexdijin.init.contact.info.infrastructure.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactDto {

    @NotNull(message = "contact-name-error-message")
    @NotEmpty(message = "contact-name-error-message")
    @NotBlank(message = "contact-name-error-message")
    private String contactName;

    @Email(message = "contact-mail-error-message-valid")
    @NotNull(message = "contact-mail-error-message")
    @NotEmpty(message = "contact-mail-error-message")
    @NotBlank(message = "contact-mail-error-message")
    @Size(min = 4, message = "contact-mail-error-message-characters")
    private String contactEmail;

    @NotNull(message = "contact-number-message")
    @NotEmpty(message = "contact-number-message")
    @NotBlank(message = "contact-number-message")
    @Pattern(regexp = "\\d+",message = "contact-number-message-number")
    private String contactNumber;


    @NotNull(message = "contact-message-error-message")
    @NotEmpty(message = "contact-message-error-message")
    @NotBlank(message = "contact-message-error-message")
    @Size(min = 5, message = "contact-message-error-message-characters")
    @Size(max = 400, message = "contact-message-error-message-characters-max")
    private String contactMessage;
}
