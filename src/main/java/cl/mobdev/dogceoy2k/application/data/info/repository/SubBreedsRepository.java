package cl.mobdev.dogceoy2k.application.data.info.repository;

import cl.mobdev.dogceoy2k.application.domain.model.SubBreedsModel;

public interface SubBreedsRepository {
    SubBreedsModel getSubBreeds(String breed);
}
