package cl.mobdev.dogceoy2k.application.domain.usecase;

import cl.mobdev.dogceoy2k.application.data.info.repository.BreedImagesRepository;
import cl.mobdev.dogceoy2k.application.domain.model.BreedImagesModel;

public class BreedImagesUseCaseImpl implements BreedImagesUseCase {

    private final BreedImagesRepository breedImagesRepository;

    public BreedImagesUseCaseImpl( BreedImagesRepository breedImagesRepository){
        this.breedImagesRepository = breedImagesRepository;
    }

    @Override
    public BreedImagesModel getBreedImages(String breed) {

        return this.breedImagesRepository.getBreedImages(breed);
    }
}
