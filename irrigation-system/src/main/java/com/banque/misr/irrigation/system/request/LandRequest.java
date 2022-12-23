package com.banque.misr.irrigation.system.request;

import com.banque.misr.irrigation.system.constant.SoilType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class LandRequest {

    @NotBlank(message = "name is required")
    private String name;
    @NotBlank(message = "location is required")
    private String location;
    @NotNull(message = "soilType is required")
    private SoilType soilType;
    @NotNull(message = "area is required")
    @Min(value = 10, message = "area min size is equal to 10")
    private Long area;

    @JsonIgnore
    private Long landId;


}
