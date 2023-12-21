package com.invexdijin.init.contact.info.infrastructure.controller;

import com.invexdijin.init.contact.info.application.ICaseUseConfirmStatusPaymentService;
import com.invexdijin.init.contact.info.infrastructure.model.in.InitSearchDto;
import com.invexdijin.init.contact.info.infrastructure.util.UtilDataShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/invexdijin")
public class ConfirmPayController {

    @Autowired
    private ICaseUseConfirmStatusPaymentService confirmPayStatus;

    @Autowired
    private UtilDataShow utilDataShow;

    @GetMapping("/intention-pay/{referenceLocator}")
    ResponseEntity<InitSearchDto> confirmPayStatus(@PathVariable String referenceLocator) {
        return ResponseEntity.ok(utilDataShow
                .showFullNameWithAsterisk(confirmPayStatus.confirmStatusPayment(referenceLocator)));
    }
}
