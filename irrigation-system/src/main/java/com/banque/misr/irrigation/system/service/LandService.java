package com.banque.misr.irrigation.system.service;

import com.banque.misr.irrigation.system.entity.Land;
import com.banque.misr.irrigation.system.request.LandRequest;
import com.banque.misr.irrigation.system.response.LandResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface LandService {

    Page<LandResponse> getLands(Pageable pageable);

    LandResponse registerLand(LandRequest registerLandRequest);

    LandResponse editLand(LandRequest editLandRequest);

    Optional<Land> getLand(Long landId);


}
