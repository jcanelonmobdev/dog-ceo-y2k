package cl.mobdev.dogceoy2k.application.data.info.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BreedImagesEntity {
    @JsonProperty
    public List<String> message;
    @JsonProperty
    public String status;
}
