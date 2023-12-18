package com.invexdijin.init.contact.info.infrastructure.controller;

import com.invexdijin.init.contact.info.application.ICaseUseInitSearchPeopleService;
import com.invexdijin.init.contact.info.infrastructure.model.TriedSearchDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/invexdijin")
public class TriedSearchController {

    @Autowired
    private ICaseUseInitSearchPeopleService searchPeople;

    @PostMapping("/init-search-people")
    public ResponseEntity<Map<String, Object>> triedSearch(@Valid @RequestBody TriedSearchDto triedSearch
            , BindingResult result) {
        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream()
                    .map(err -> err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("error", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        response.put("message", searchPeople.searchStart(triedSearch));
        return ResponseEntity.ok(response);

    }


}
