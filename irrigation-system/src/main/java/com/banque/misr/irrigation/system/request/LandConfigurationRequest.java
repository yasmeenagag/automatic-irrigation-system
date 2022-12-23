package com.banque.misr.irrigation.system.request;

import com.banque.misr.irrigation.system.constant.AgriculturalCrop;
import com.banque.misr.irrigation.system.constant.Insecticide;
import com.banque.misr.irrigation.system.constant.Tractor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode
@ToString
public class LandConfigurationRequest {

    @JsonIgnore
    private Long landId;

    @NotNull(message = "agriculturalCrop is required")
    private AgriculturalCrop agriculturalCrop;

    @NotNull(message = "insecticide is required")
    private Insecticide insecticide;

    @NotNull(message = "tractor is required")
    private Tractor tractor;

}
