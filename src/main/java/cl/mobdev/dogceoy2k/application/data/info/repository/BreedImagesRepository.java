package cl.mobdev.dogceoy2k.application.data.info.repository;

import cl.mobdev.dogceoy2k.application.domain.model.BreedImagesModel;

public interface BreedImagesRepository {
    BreedImagesModel getBreedImages(String breed);
}
