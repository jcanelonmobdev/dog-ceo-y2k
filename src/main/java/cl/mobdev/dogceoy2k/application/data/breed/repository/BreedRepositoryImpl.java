package cl.mobdev.dogceoy2k.application.data.breed.repository;

import cl.mobdev.dogceoy2k.application.data.images.datasource.BreedImagesDataSource;
import cl.mobdev.dogceoy2k.application.data.subbreeds.datasource.SubBreedsDataSource;
import cl.mobdev.dogceoy2k.application.domain.model.BreedDetailsModel;
import cl.mobdev.dogceoy2k.application.domain.repository.BreedRepository;
import cl.mobdev.dogceoy2k.common.Mapper;

public class BreedRepositoryImpl implements BreedRepository {
    private final BreedImagesDataSource breedImagesDataSource;
    private final SubBreedsDataSource subBreedsDataSource;
    private final Mapper<BreedDetailsModel, String> breedDetailModelStringMapper;

    public BreedRepositoryImpl(
            BreedImagesDataSource breedImagesDataSource,
            SubBreedsDataSource subBreedsDataSource,
            Mapper<BreedDetailsModel, String> breedDetailModelStringMapper) {
        this.breedImagesDataSource = breedImagesDataSource;
        this.subBreedsDataSource = subBreedsDataSource;
        this.breedDetailModelStringMapper = breedDetailModelStringMapper;
    }

    @Override
    public BreedDetailsModel getDetails(String breed) {
        BreedDetailsModel breedDetailsModel = this.breedDetailModelStringMapper.reverseMap(breed);

        breedDetailsModel.subBreeds = this.subBreedsDataSource.getSubBreeds(breed).message;
        breedDetailsModel.images = this.breedImagesDataSource.getImages(breed).message;

        return breedDetailsModel;
    }
}
