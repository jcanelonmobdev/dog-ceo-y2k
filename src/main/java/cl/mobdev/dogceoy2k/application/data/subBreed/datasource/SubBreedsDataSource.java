package cl.mobdev.dogceoy2k.application.data.subBreed.datasource;

import cl.mobdev.dogceoy2k.application.data.subBreed.entity.SubBreedsEntity;

public interface SubBreedsDataSource {
    SubBreedsEntity getSubBreeds(String breed);
}
