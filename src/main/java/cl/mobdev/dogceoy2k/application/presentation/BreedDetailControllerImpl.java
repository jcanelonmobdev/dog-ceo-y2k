package cl.mobdev.dogceoy2k.application.presentation;

import cl.mobdev.dogceoy2k.application.domain.model.BreedInfoModel;
import cl.mobdev.dogceoy2k.application.domain.usecase.BreedInfoUseCase;
import cl.mobdev.dogceoy2k.application.presentation.body.BreedBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public class BreedDetailControllerImpl implements BreedDetailController {
    private final BreedInfoUseCase breedInfoUseCase;

    public BreedDetailControllerImpl(BreedInfoUseCase breedInfoUseCase){

        this.breedInfoUseCase = breedInfoUseCase;
    }

    @Override
    public ResponseEntity<BreedInfoModel> info(@RequestBody BreedBody breedBody) {
        BreedInfoModel breedInfoModel = this.breedInfoUseCase.getBreedInfo(breedBody.breed);
        //BreedModel breedModel = new BreedModel();
        breedInfoModel.breed = breedBody.breed;

        return new ResponseEntity<>(breedInfoModel, HttpStatus.OK);
    }
}
