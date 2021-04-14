package cl.mobdev.dogceoy2k.application.domain.repository;

import cl.mobdev.dogceoy2k.application.domain.model.BreedDetailModel;

public interface BreedDetailRepository {
    BreedDetailModel getDetails(String breed);
}
