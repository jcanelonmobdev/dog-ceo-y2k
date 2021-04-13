package cl.mobdev.dogceoy2k.application.data.info.repository;

import cl.mobdev.dogceoy2k.application.domain.model.BreedInfoModel;

public class BreedInfoRepositoryImpl implements BreedInfoRepository {

    private final SubBreedsRepository subBreedsRepository;
    private final BreedImagesRepository breedImagesRepository;

    public BreedInfoRepositoryImpl(
            BreedImagesRepository breedImagesRepository,
            SubBreedsRepository subBreedsRepository
    ) {
        this.breedImagesRepository = breedImagesRepository;
        this.subBreedsRepository = subBreedsRepository;
    }

    @Override
    public BreedInfoModel GetBreedInfo(String breed) {
        BreedInfoModel breedInfoModel = new BreedInfoModel();

        breedInfoModel.breed = breed;
        breedInfoModel.images = this.breedImagesRepository.getBreedImages(breed).images;
        breedInfoModel.subBreed = this.subBreedsRepository.getSubBreeds(breed).subBreed;

        return breedInfoModel;
    }
}
