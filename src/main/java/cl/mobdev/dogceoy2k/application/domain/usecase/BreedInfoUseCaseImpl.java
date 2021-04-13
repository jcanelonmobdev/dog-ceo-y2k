package cl.mobdev.dogceoy2k.application.domain.usecase;

import cl.mobdev.dogceoy2k.application.data.info.repository.BreedInfoRepository;
import cl.mobdev.dogceoy2k.application.domain.model.BreedInfoModel;

public class BreedInfoUseCaseImpl implements BreedInfoUseCase {

    private final BreedInfoRepository breedInfoRepository;

    public BreedInfoUseCaseImpl(
            BreedInfoRepository breedInfoRepository
    ){
        this.breedInfoRepository = breedInfoRepository;
    }

    @Override
    public BreedInfoModel getBreedInfo(String breed) {

        return this.breedInfoRepository.GetBreedInfo(breed);
    }
}
