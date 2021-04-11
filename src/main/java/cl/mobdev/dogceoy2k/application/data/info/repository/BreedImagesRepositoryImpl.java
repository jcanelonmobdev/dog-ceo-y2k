package cl.mobdev.dogceoy2k.application.data.info.repository;

import cl.mobdev.dogceoy2k.application.data.info.datasource.BreedImagesDataSource;
import cl.mobdev.dogceoy2k.application.data.info.entity.BreedImagesEntity;
import cl.mobdev.dogceoy2k.application.domain.model.BreedImagesModel;
import cl.mobdev.dogceoy2k.common.Mapper;

public class BreedImagesRepositoryImpl implements BreedImagesRepository {

    private final Mapper<BreedImagesModel, BreedImagesEntity> breedImagesModelBreedImagesRepositoryMapper;
    private final BreedImagesDataSource breedImagesDataSource;

    public BreedImagesRepositoryImpl(
            Mapper<BreedImagesModel, BreedImagesEntity> breedImagesModelBreedImagesRepositoryMapper,
            BreedImagesDataSource breedImagesDataSource
    ){
        this.breedImagesModelBreedImagesRepositoryMapper = breedImagesModelBreedImagesRepositoryMapper;
        this.breedImagesDataSource = breedImagesDataSource;
    }

    @Override
    public BreedImagesModel getBreedImages(String breed) {

        BreedImagesEntity breedImagesEntity = this.breedImagesDataSource.getImages(breed);
        return this.breedImagesModelBreedImagesRepositoryMapper.reverseMap(breedImagesEntity);
    }
}
