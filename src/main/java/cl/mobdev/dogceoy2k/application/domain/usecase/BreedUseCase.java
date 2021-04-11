package cl.mobdev.dogceoy2k.application.domain.usecase;

import cl.mobdev.dogceoy2k.application.domain.model.BreedModel;

public interface BreedUseCase {
    BreedModel getInfo(String breed);
}
