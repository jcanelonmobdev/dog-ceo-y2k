package cl.mobdev.dogceoy2k.application.domain.usecase;

import cl.mobdev.dogceoy2k.application.data.info.repository.BreedImagesRepository;
import cl.mobdev.dogceoy2k.application.data.info.repository.SubBreedsRepository;
import cl.mobdev.dogceoy2k.application.domain.model.BreedImagesModel;
import cl.mobdev.dogceoy2k.application.domain.model.BreedModel;
import cl.mobdev.dogceoy2k.application.domain.model.SubBreedsModel;

public class BreedUseCaseImpl implements BreedUseCase {

    private final SubBreedsRepository subBreedsRepository;
    private final BreedImagesRepository breedImagesRepository;

    public BreedUseCaseImpl(
            SubBreedsRepository subBreedsRepository,
            BreedImagesRepository breedImagesRepository
    ){
        this.subBreedsRepository = subBreedsRepository;
        this.breedImagesRepository = breedImagesRepository;
    }

    @Override
    public BreedModel getInfo(String breed) {
        SubBreedsModel subBreeds = this.subBreedsRepository.getSubBreeds(breed);
        BreedImagesModel breedImages = this.breedImagesRepository.getBreedImages(breed);

        return new BreedModel(breed, subBreeds, breedImages);
    }
}
