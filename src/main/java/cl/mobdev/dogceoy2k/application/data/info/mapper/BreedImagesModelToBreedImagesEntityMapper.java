package cl.mobdev.dogceoy2k.application.data.info.mapper;

import cl.mobdev.dogceoy2k.application.data.info.entity.BreedImagesEntity;
import cl.mobdev.dogceoy2k.application.domain.model.BreedImagesModel;
import cl.mobdev.dogceoy2k.common.Mapper;

public class BreedImagesModelToBreedImagesEntityMapper extends Mapper<BreedImagesModel, BreedImagesEntity> {

    @Override
    public BreedImagesEntity map(BreedImagesModel value) {
        return null;
    }

    @Override
    public BreedImagesModel reverseMap(BreedImagesEntity value) {
        BreedImagesModel breedImage = new BreedImagesModel();
        breedImage.images = value.message;

        return breedImage;
    }
}
