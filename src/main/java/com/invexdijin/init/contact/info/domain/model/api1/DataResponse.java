package com.invexdijin.init.contact.info.domain.model.api1;

import lombok.Data;

import java.util.List;

@Data
public class DataResponse {
	private String firstName;
	private String lastName;
	private String documentType;
	private String documentNumber;
	private String fullName;
	private List<String> arrayName;
	private String details;
}