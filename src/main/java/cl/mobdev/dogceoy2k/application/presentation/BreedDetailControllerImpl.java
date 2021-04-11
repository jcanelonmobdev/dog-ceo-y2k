package cl.mobdev.dogceoy2k.application.presentation;

import cl.mobdev.dogceoy2k.application.domain.model.BreedModel;
import cl.mobdev.dogceoy2k.application.domain.usecase.BreedUseCase;
import cl.mobdev.dogceoy2k.application.presentation.body.BreedBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public class BreedDetailControllerImpl implements BreedDetailController {
    private final BreedUseCase breedUseCase;

    public BreedDetailControllerImpl(BreedUseCase breedUseCase){

        this.breedUseCase = breedUseCase;
    }

    @Override
    public ResponseEntity<BreedModel> info(@RequestBody BreedBody breedBody) {
        BreedModel breedModel = this.breedUseCase.getInfo(breedBody.breed);
        //BreedModel breedModel = new BreedModel();
        breedModel.breed = breedBody.breed;

        return new ResponseEntity<>(breedModel, HttpStatus.OK);
    }
}
