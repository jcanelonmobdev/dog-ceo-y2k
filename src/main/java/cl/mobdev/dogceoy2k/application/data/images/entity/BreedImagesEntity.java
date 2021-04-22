package cl.mobdev.dogceoy2k.application.data.images.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BreedImagesEntity {
    @JsonProperty
    public List<String> message;
    @JsonProperty
    public String status;
}
