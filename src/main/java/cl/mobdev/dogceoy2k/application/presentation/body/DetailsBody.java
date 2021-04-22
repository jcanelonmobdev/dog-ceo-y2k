package cl.mobdev.dogceoy2k.application.presentation.body;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class DetailsBody {
    @JsonProperty
    @NotBlank
    public String breed;
}
