package cl.mobdev.dogceoy2k.application.domain.usecase;

import cl.mobdev.dogceoy2k.application.domain.model.BreedInfoModel;

public interface BreedInfoUseCase {
    BreedInfoModel getBreedInfo(String breed);
}
