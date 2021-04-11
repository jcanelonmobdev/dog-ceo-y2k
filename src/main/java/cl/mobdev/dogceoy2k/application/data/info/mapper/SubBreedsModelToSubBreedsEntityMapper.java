package cl.mobdev.dogceoy2k.application.data.info.mapper;

import cl.mobdev.dogceoy2k.application.data.info.entity.SubBreedsEntity;
import cl.mobdev.dogceoy2k.application.domain.model.SubBreedsModel;
import cl.mobdev.dogceoy2k.common.Mapper;

public class SubBreedsModelToSubBreedsEntityMapper extends Mapper<SubBreedsModel, SubBreedsEntity> {

    @Override
    public SubBreedsEntity map(SubBreedsModel value) {
        return null;
    }

    @Override
    public SubBreedsModel reverseMap(SubBreedsEntity value) {
        SubBreedsModel subBreeds = new SubBreedsModel();
        subBreeds.subBreed = value.message;

        return subBreeds;
    }
}
