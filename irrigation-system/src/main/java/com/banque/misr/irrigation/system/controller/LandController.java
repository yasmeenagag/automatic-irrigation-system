package com.banque.misr.irrigation.system.controller;

import com.banque.misr.irrigation.system.request.LandRequest;
import com.banque.misr.irrigation.system.response.BaseResponse;
import com.banque.misr.irrigation.system.response.LandResponse;
import com.banque.misr.irrigation.system.service.LandService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping( "/api/land")
public class LandController {

    final LandService landService;

    public LandController(LandService landService) {
        this.landService = landService;
    }

    @GetMapping
    public ResponseEntity<BaseResponse<Page<LandResponse>>> getLands(Pageable pageable) {
        return new ResponseEntity<>(new BaseResponse<>(landService.getLands(pageable), null), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BaseResponse<LandResponse>> registerLand(@Valid @RequestBody LandRequest registerLandRequest) {
        return new ResponseEntity<>(new BaseResponse<>(landService.registerLand(registerLandRequest), null), HttpStatus.CREATED);

    }

}
