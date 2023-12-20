package com.invexdijin.init.contact.info.infrastructure.controller;

import com.invexdijin.init.contact.info.application.InitSearchFacade;
import com.invexdijin.init.contact.info.infrastructure.model.in.TriedSearchDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/invexdijin")
public class TriedSearchController {

    @Autowired
    private InitSearchFacade initSearchFacade;

    @PostMapping("/init-search-people")
    public ResponseEntity<Object> triedSearch(@Valid @RequestBody TriedSearchDto triedSearch
            , BindingResult result) {
        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream()
                    .map(err -> err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("error", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.created(URI.create("/api/v1/invexdijin/init-search-people"))
                .body(initSearchFacade.initIntentionSearchPeople(triedSearch));

    }


}
