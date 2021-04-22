package cl.mobdev.dogceoy2k.application.data.subbreeds.datasource;

import cl.mobdev.dogceoy2k.application.data.subbreeds.entity.SubBreedsEntity;

public interface SubBreedsDataSource {
    SubBreedsEntity getSubBreeds(String breed);
}
