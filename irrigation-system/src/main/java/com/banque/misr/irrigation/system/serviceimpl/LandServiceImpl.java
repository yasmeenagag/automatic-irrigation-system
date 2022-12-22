package com.banque.misr.irrigation.system.serviceimpl;

import com.banque.misr.irrigation.system.entity.Land;
import com.banque.misr.irrigation.system.repostiory.LandRepository;
import com.banque.misr.irrigation.system.request.LandRequest;
import com.banque.misr.irrigation.system.response.LandResponse;
import com.banque.misr.irrigation.system.service.LandService;
import com.banque.misr.irrigation.system.service.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LandServiceImpl implements LandService {

    private final LandRepository landRepository;
    private final ObjectMapper objectMapper;

    public LandServiceImpl(LandRepository landRepository, ObjectMapper objectMapper) {
        this.landRepository = landRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public Page<LandResponse> getLands(Pageable pageable) {
        Page<Land> lands = landRepository.findAll(pageable);
        return objectMapper.mapPage(lands , LandResponse.class);
    }

    @Override
    public LandResponse registerLand(LandRequest registerLandRequest) {
        return null;
    }

}
