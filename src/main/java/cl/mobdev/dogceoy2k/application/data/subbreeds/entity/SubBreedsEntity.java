package cl.mobdev.dogceoy2k.application.data.subbreeds.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SubBreedsEntity {
    @JsonProperty
    public List<String> message;
    @JsonProperty
    public String status;
}
