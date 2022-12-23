package com.banque.misr.irrigation.system.serviceimpl;

import com.banque.misr.irrigation.system.entity.Land;
import com.banque.misr.irrigation.system.entity.LandConfiguration;
import com.banque.misr.irrigation.system.repostiory.LandRepository;
import com.banque.misr.irrigation.system.request.LandRequest;
import com.banque.misr.irrigation.system.response.LandResponse;
import com.banque.misr.irrigation.system.service.LandService;
import com.banque.misr.irrigation.system.service.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LandServiceImpl implements LandService {

    private final LandRepository landRepository;
    private final ObjectMapper objectMapper;


    public LandServiceImpl(LandRepository landRepository, ObjectMapper objectMapper) {
        this.landRepository = landRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public Optional<Land> getLand(Long landId) {
        return landRepository.findById(landId);
    }

    @Override
    public Page<LandResponse> getLands(Pageable pageable) {
        Page<Land> lands = landRepository.findAll(pageable);
        return objectMapper.mapPage(lands, LandResponse.class);
    }

    @Override
    public LandResponse registerLand(LandRequest landRequest) {
        Land land = landRepository.save(objectMapper.map(landRequest, Land.class));
        return objectMapper.map(land, LandResponse.class);
    }

    @Override
    public LandResponse editLand(LandRequest editLandRequest) {
        Optional<Land> landOptional = landRepository.findById(editLandRequest.getLandId());
        LandResponse response;
        if (landOptional.isPresent()) {
            response = objectMapper.map(landRepository.save(objectMapper.map(editLandRequest, Land.class)), LandResponse.class);
            response.setFound(true);
        } else {
            response = new LandResponse();
            response.setFound(false);
        }
        return response;

    }

}
