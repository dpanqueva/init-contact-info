package com.invexdijin.init.contact.info.infrastructure.model.out;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RsTriedSearchDto {

    private String id;

    private String documentType;

    private String documentNumber;

    private String cellphone;

    private String searchType;

    private String firstName;

    private String lastName;

    private String fullName;
}
