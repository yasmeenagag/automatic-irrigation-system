package com.banque.misr.irrigation.system.service;

import com.banque.misr.irrigation.system.request.LandRequest;
import com.banque.misr.irrigation.system.response.LandResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


public interface LandService {

    Page<LandResponse> getLands(Pageable pageable);

    LandResponse registerLand(LandRequest registerLandRequest);

}
