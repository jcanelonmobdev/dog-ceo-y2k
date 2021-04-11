package cl.mobdev.dogceoy2k.application.data.info.repository;

import cl.mobdev.dogceoy2k.application.data.info.datasource.SubBreedsDataSource;
import cl.mobdev.dogceoy2k.application.data.info.entity.SubBreedsEntity;
import cl.mobdev.dogceoy2k.application.domain.model.SubBreedsModel;
import cl.mobdev.dogceoy2k.common.Mapper;

public class SubBreedsRepositoryImpl implements SubBreedsRepository {

    private final Mapper<SubBreedsModel, SubBreedsEntity> subBreedsModelSubBreedsEntityMapper;
    private final SubBreedsDataSource subBreedsDataSource;

    public SubBreedsRepositoryImpl(
            Mapper<SubBreedsModel, SubBreedsEntity> subBreedsModelSubBreedsEntityMapper,
            SubBreedsDataSource subBreedsDataSource
    ){
        this.subBreedsModelSubBreedsEntityMapper = subBreedsModelSubBreedsEntityMapper;
        this.subBreedsDataSource = subBreedsDataSource;
    }

    @Override
    public SubBreedsModel getSubBreeds(String breed) {

        SubBreedsEntity subBreedsEntity = this.subBreedsDataSource.getSubBreeds(breed);
        return this.subBreedsModelSubBreedsEntityMapper.reverseMap(subBreedsEntity);
    }
}
