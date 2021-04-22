package cl.mobdev.dogceoy2k.application.domain.repository;

import cl.mobdev.dogceoy2k.application.domain.model.BreedDetailsModel;

public interface BreedRepository {
    BreedDetailsModel getDetails(String breed);
}
