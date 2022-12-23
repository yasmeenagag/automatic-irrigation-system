package com.banque.misr.irrigation.system.serviceimpl;

import com.banque.misr.irrigation.system.entity.Land;
import com.banque.misr.irrigation.system.entity.LandConfiguration;
import com.banque.misr.irrigation.system.repostiory.LandConfigurationRepository;
import com.banque.misr.irrigation.system.request.LandConfigurationRequest;
import com.banque.misr.irrigation.system.response.LandConfigurationResponse;
import com.banque.misr.irrigation.system.service.LandConfigurationService;
import com.banque.misr.irrigation.system.service.LandService;
import com.banque.misr.irrigation.system.service.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LandConfigurationServiceImpl implements LandConfigurationService {

    private final LandService landService;
    private final LandConfigurationRepository landConfigurationRepository;
    private final ObjectMapper objectMapper;

    public LandConfigurationServiceImpl(LandService landService, LandConfigurationRepository landConfigurationRepository, ObjectMapper objectMapper) {
        this.landService = landService;
        this.landConfigurationRepository = landConfigurationRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public LandConfigurationResponse configureLand(LandConfigurationRequest landConfigurationRequest) {
        Optional<Land> land = landService.getLand(landConfigurationRequest.getLandId());
        if (!land.isPresent()) {
            LandConfigurationResponse landConfigurationResponse = new LandConfigurationResponse();
            landConfigurationResponse.setFound(false);
            return landConfigurationResponse;
        }
        LandConfiguration landConfiguration = land.get().getLandConfiguration();
        // if old configuration is found , update it
        if (landConfiguration != null) {
            landConfiguration.setInsecticide(landConfigurationRequest.getInsecticide());
            landConfiguration.setAgriculturalCrop(landConfigurationRequest.getAgriculturalCrop());
            landConfiguration.setTractor(landConfigurationRequest.getTractor());
        } else { // create new configuration
            landConfiguration = objectMapper.map(landConfigurationRequest, LandConfiguration.class);
            landConfiguration.setLand(land.get());
            landConfigurationRepository.save(landConfiguration);
        }

        LandConfigurationResponse landConfigurationResponse = objectMapper.map(landConfiguration, LandConfigurationResponse.class);
        landConfigurationResponse.setFound(true);
        return landConfigurationResponse;
    }


}
