package cl.mobdev.dogceoy2k.application.data.breed.mapper;

import cl.mobdev.dogceoy2k.application.domain.model.BreedDetailsModel;
import cl.mobdev.dogceoy2k.common.Mapper;

public class BreedDetailsModelMapper extends Mapper<BreedDetailsModel, String> {

    @Override
    public String map(BreedDetailsModel value) {
        throw new UnsupportedOperationException("Should not map from Model to Entity");
    }

    @Override
    public BreedDetailsModel reverseMap(String value) {
        BreedDetailsModel breedDetailsModel = new BreedDetailsModel();
        breedDetailsModel.breed = value;
        return breedDetailsModel;
    }
}
