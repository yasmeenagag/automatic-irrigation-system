package com.banque.misr.irrigation.system.response;

import com.banque.misr.irrigation.system.constant.SoilType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
@Data
public class LandResponse {

    private Long id;
    private String name;
    private String location;
    private SoilType soilType;
    private Long area;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LandConfigurationResponse landConfiguration;
    @JsonIgnore
    boolean isFound;

}
