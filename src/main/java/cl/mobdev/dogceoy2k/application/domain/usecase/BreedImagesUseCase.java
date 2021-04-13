package cl.mobdev.dogceoy2k.application.domain.usecase;

import cl.mobdev.dogceoy2k.application.domain.model.BreedImagesModel;

public interface BreedImagesUseCase {
    BreedImagesModel getBreedImages(String breed);
}
