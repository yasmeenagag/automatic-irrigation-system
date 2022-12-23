package com.banque.misr.irrigation.system.controller;

import com.banque.misr.irrigation.system.request.LandConfigurationRequest;
import com.banque.misr.irrigation.system.request.LandRequest;
import com.banque.misr.irrigation.system.response.BaseResponse;
import com.banque.misr.irrigation.system.response.LandConfigurationResponse;
import com.banque.misr.irrigation.system.response.LandResponse;
import com.banque.misr.irrigation.system.service.LandConfigurationService;
import com.banque.misr.irrigation.system.service.LandService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/land")
public class LandController {

    final LandService landService;
    final LandConfigurationService landConfigurationService;

    public LandController(LandService landService, LandConfigurationService landConfigurationService) {
        this.landService = landService;
        this.landConfigurationService = landConfigurationService;
    }

    @GetMapping
    public ResponseEntity<BaseResponse<Page<LandResponse>>> getLands(Pageable pageable) {
        return new ResponseEntity<>(new BaseResponse<>(landService.getLands(pageable), null), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BaseResponse<LandResponse>> registerLand(@Valid @RequestBody LandRequest landRequest) {
        return new ResponseEntity<>(new BaseResponse<>(landService.registerLand(landRequest), null), HttpStatus.CREATED);

    }

    @PutMapping("/{landId}")
    public ResponseEntity<BaseResponse<LandResponse>> editLand(@Valid @RequestBody LandRequest landRequest, @PathVariable Long landId) {
        landRequest.setLandId(landId);
        LandResponse response = landService.editLand(landRequest);
        if (response.isFound())
            return new ResponseEntity<>(new BaseResponse<>(response, null), HttpStatus.OK);
        return new ResponseEntity<>(new BaseResponse<>(null, null), HttpStatus.NOT_FOUND);
    }

    @PostMapping("/configure/{landId}")
    public ResponseEntity<BaseResponse<LandConfigurationResponse>> configureLand(@Valid @RequestBody LandConfigurationRequest landConfigurationRequest,
                                                                                 @PathVariable Long landId) {
        landConfigurationRequest.setLandId(landId);
        LandConfigurationResponse response = landConfigurationService.configureLand(landConfigurationRequest);
        if (response.isFound())
            return new ResponseEntity<>(new BaseResponse<>(response, null), HttpStatus.OK);
        return new ResponseEntity<>(new BaseResponse<>(null, null), HttpStatus.NOT_FOUND);
    }

}
