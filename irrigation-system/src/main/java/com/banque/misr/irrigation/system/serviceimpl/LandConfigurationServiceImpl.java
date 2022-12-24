package com.banque.misr.irrigation.system.serviceimpl;

import com.banque.misr.irrigation.system.constant.AgriculturalCrop;
import com.banque.misr.irrigation.system.constant.SoilType;
import com.banque.misr.irrigation.system.constant.TimeSlot;
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
        Land landEntity = land.get();
        LandConfiguration landConfiguration = landEntity.getLandConfiguration();

        // if old configuration is found , update it
        if (landConfiguration != null) {
            updateLandConfiguration(landConfigurationRequest, landEntity, landConfiguration);
        } else { // create new configuration
            landConfiguration = objectMapper.map(landConfigurationRequest, LandConfiguration.class);
            preDictWaterAndSlot(landConfigurationRequest, landEntity, landConfiguration);
            landConfiguration.setLand(landEntity);
            landConfigurationRepository.save(landConfiguration);
        }

        LandConfigurationResponse landConfigurationResponse = objectMapper.map(landConfiguration, LandConfigurationResponse.class);
        landConfigurationResponse.setFound(true);
        return landConfigurationResponse;
    }

    private void updateLandConfiguration(LandConfigurationRequest landConfigurationRequest, Land landEntity, LandConfiguration landConfiguration) {
        landConfiguration.setInsecticide(landConfigurationRequest.getInsecticide());
        landConfiguration.setAgriculturalCrop(landConfigurationRequest.getAgriculturalCrop());
        landConfiguration.setTractor(landConfigurationRequest.getTractor());
        preDictWaterAndSlot(landConfigurationRequest, landEntity, landConfiguration);
    }

    private void preDictWaterAndSlot(LandConfigurationRequest landConfigurationRequest, Land landEntity, LandConfiguration landConfiguration) {
        if (landConfigurationRequest.getNeededAmountOfWater() == null) {
            landConfiguration.setNeededAmountOfWater(predictNeededAmountOfWater(landEntity, landConfiguration));
        }else {
            landConfiguration.setTimeSlot(landConfigurationRequest.getTimeSlot());

        }

        if (landConfigurationRequest.getTimeSlot() == null) {
            landConfiguration.setTimeSlot(predictTimeSlot(landEntity, landConfiguration));
        }
        else{
            landConfiguration.setTimeSlot(landConfigurationRequest.getTimeSlot());

        }
    }

    private TimeSlot predictTimeSlot(Land land, LandConfiguration landConfiguration) {
        SoilType soilType = land.getSoilType();
        AgriculturalCrop agriculturalCrop = landConfiguration.getAgriculturalCrop();

        if (soilType.equals(SoilType.ClaySoil) || soilType.equals(SoilType.Sandy)) {
            return TimeSlot.Evening;
        } else if (agriculturalCrop.equals(AgriculturalCrop.Hay)) {
            return TimeSlot.Evening;
        }

        return TimeSlot.Morning;
    }

    private Long predictNeededAmountOfWater(Land land, LandConfiguration landConfiguration) {
        SoilType soilType = land.getSoilType();
        AgriculturalCrop agriculturalCrop = landConfiguration.getAgriculturalCrop();
        Long area = land.getArea();
        long neededWater = 0L;
        if (soilType.equals(SoilType.ClaySoil) || soilType.equals(SoilType.Sandy)) {
            neededWater += 2;
        } else if (agriculturalCrop.equals(AgriculturalCrop.Hay)) {
            neededWater += 3;
        } else {
            neededWater += 1;
        }
        return neededWater * area;

    }


}
