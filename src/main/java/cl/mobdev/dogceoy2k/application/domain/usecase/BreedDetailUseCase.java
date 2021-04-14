package cl.mobdev.dogceoy2k.application.domain.usecase;

import cl.mobdev.dogceoy2k.application.domain.model.BreedDetailModel;
import cl.mobdev.dogceoy2k.application.domain.repository.BreedDetailRepository;

public class BreedDetailUseCase {
    private final BreedDetailRepository breedDetailRepository;

    public BreedDetailUseCase(BreedDetailRepository breedDetailRepository) {
        this.breedDetailRepository = breedDetailRepository;
    }

    public BreedDetailModel getBreedDetails(String breed) {
        return this.breedDetailRepository.getDetails(breed);
    }
}
