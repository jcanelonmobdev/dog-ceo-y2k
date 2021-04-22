package cl.mobdev.dogceoy2k.application.domain.usecase;

import cl.mobdev.dogceoy2k.application.domain.model.BreedDetailsModel;
import cl.mobdev.dogceoy2k.application.domain.repository.BreedRepository;

public class BreedDetailUseCase {
    private final BreedRepository breedRepository;

    public BreedDetailUseCase(BreedRepository breedRepository) {
        this.breedRepository = breedRepository;
    }

    public BreedDetailsModel getBreedDetails(String breed) {
        return this.breedRepository.getDetails(breed);
    }
}
