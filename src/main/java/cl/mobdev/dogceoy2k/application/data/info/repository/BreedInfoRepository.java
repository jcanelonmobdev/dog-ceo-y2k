package cl.mobdev.dogceoy2k.application.data.info.repository;

import cl.mobdev.dogceoy2k.application.domain.model.BreedInfoModel;

public interface BreedInfoRepository {
    public BreedInfoModel GetBreedInfo(String breed);
}
