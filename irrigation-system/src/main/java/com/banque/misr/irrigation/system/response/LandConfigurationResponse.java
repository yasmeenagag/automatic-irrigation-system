package com.banque.misr.irrigation.system.response;

import com.banque.misr.irrigation.system.constant.AgriculturalCrop;
import com.banque.misr.irrigation.system.constant.Insecticide;
import com.banque.misr.irrigation.system.constant.Tractor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class LandConfigurationResponse {

    @JsonIgnore
    boolean isFound;
    private Long id;
    private AgriculturalCrop agriculturalCrop;
    private Insecticide insecticide;
    private Tractor tractor;


}
