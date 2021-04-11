package cl.mobdev.dogceoy2k.application.data.info.datasource;

import cl.mobdev.dogceoy2k.application.data.info.entity.SubBreedsEntity;

public interface SubBreedsDataSource {
    SubBreedsEntity getSubBreeds(String breed);
}
