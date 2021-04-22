package cl.mobdev.dogceoy2k.application.data.images.datasource;

import cl.mobdev.dogceoy2k.application.data.images.entity.BreedImagesEntity;

public interface BreedImagesDataSource {
    BreedImagesEntity getImages(String breed);
}
