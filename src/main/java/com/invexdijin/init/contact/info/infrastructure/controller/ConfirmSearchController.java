package com.invexdijin.init.contact.info.infrastructure.controller;

import com.invexdijin.init.contact.info.application.ICaseUseConfirmSearchPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/invexdijin")
public class ConfirmSearchController {

    @Autowired
    private ICaseUseConfirmSearchPeopleService confirmSearchPeople;

    @GetMapping("/intention-search-pay/{referenceLocator}")
    ResponseEntity<Map<String, Object>> testTest(@PathVariable String referenceLocator) {
        Map<String, Object> response = new HashMap<>();

        response.put("message", confirmSearchPeople.confirmSearchPeople(referenceLocator));

        return ResponseEntity.ok(response);

    }
}
