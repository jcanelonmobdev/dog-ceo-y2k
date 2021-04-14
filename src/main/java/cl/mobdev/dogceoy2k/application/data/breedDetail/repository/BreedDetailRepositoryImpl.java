package cl.mobdev.dogceoy2k.application.data.breedDetail.repository;

import cl.mobdev.dogceoy2k.application.data.breedImage.datasource.BreedImagesDataSource;
import cl.mobdev.dogceoy2k.application.data.breedImage.entity.BreedImagesEntity;
import cl.mobdev.dogceoy2k.application.data.subBreed.datasource.SubBreedsDataSource;
import cl.mobdev.dogceoy2k.application.data.subBreed.entity.SubBreedsEntity;
import cl.mobdev.dogceoy2k.application.domain.model.BreedDetailModel;
import cl.mobdev.dogceoy2k.application.domain.repository.BreedDetailRepository;
import cl.mobdev.dogceoy2k.common.Mapper;

public class BreedDetailRepositoryImpl implements BreedDetailRepository {
    private final BreedImagesDataSource breedImagesDataSource;
    private final SubBreedsDataSource subBreedsDataSource;
    private final Mapper<BreedDetailModel, String> breedDetailModelStringMapper;

    public BreedDetailRepositoryImpl(BreedImagesDataSource breedImagesDataSource, SubBreedsDataSource subBreedsDataSource, Mapper<BreedDetailModel, String> breedDetailModelStringMapper) {
        this.breedImagesDataSource = breedImagesDataSource;
        this.subBreedsDataSource = subBreedsDataSource;
        this.breedDetailModelStringMapper = breedDetailModelStringMapper;
    }

    @Override
    public BreedDetailModel getDetails(String breed) {
        BreedDetailModel breedDetailModel = this.breedDetailModelStringMapper.reverseMap(breed);
        breedDetailModel.subBreeds = this.subBreedsDataSource.getSubBreeds(breed).message;
        breedDetailModel.images = this.breedImagesDataSource.getImages(breed).message;

        return breedDetailModel;
    }
}
