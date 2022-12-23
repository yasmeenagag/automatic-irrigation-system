package com.banque.misr.irrigation.system.service;

import com.banque.misr.irrigation.system.request.LandConfigurationRequest;
import com.banque.misr.irrigation.system.response.LandConfigurationResponse;

public interface LandConfigurationService {

    LandConfigurationResponse configureLand(LandConfigurationRequest landConfigurationRequest);

}
