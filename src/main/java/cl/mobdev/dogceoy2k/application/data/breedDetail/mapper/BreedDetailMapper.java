package cl.mobdev.dogceoy2k.application.data.breedDetail.mapper;

import cl.mobdev.dogceoy2k.application.domain.model.BreedDetailModel;
import cl.mobdev.dogceoy2k.common.Mapper;

public class BreedDetailMapper extends Mapper<BreedDetailModel, String> {

    @Override
    public String map(BreedDetailModel value) {
        return null;
    }

    @Override
    public BreedDetailModel reverseMap(String value) {
        BreedDetailModel breedDetailModel = new BreedDetailModel();
        breedDetailModel.breed = value;
        return breedDetailModel;
    }
}
