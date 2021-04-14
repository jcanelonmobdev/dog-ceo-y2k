package cl.mobdev.dogceoy2k.application.data.breedImage.datasource;

import cl.mobdev.dogceoy2k.application.data.breedImage.entity.BreedImagesEntity;

public interface BreedImagesDataSource {
    BreedImagesEntity getImages(String breed);
}
