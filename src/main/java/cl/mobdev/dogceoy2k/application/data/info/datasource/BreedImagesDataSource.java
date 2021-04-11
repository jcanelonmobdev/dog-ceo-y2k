package cl.mobdev.dogceoy2k.application.data.info.datasource;

import cl.mobdev.dogceoy2k.application.data.info.entity.BreedImagesEntity;

public interface BreedImagesDataSource {
    BreedImagesEntity getImages(String breed);
}
