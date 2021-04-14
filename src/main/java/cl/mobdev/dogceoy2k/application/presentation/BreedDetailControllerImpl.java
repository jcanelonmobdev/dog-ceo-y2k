package cl.mobdev.dogceoy2k.application.presentation;

import cl.mobdev.dogceoy2k.application.domain.model.BreedDetailModel;
import cl.mobdev.dogceoy2k.application.domain.usecase.BreedDetailUseCase;
import cl.mobdev.dogceoy2k.application.presentation.body.BreedBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public class BreedDetailControllerImpl implements BreedDetailController {
    private final BreedDetailUseCase breedDetailUseCase;

    public BreedDetailControllerImpl(BreedDetailUseCase breedDetailUseCase){
        this.breedDetailUseCase = breedDetailUseCase;
    }

    @Override
    public ResponseEntity<BreedDetailModel> info(@RequestBody BreedBody breedBody) {
        BreedDetailModel breedModel = this.breedDetailUseCase.getBreedDetails(breedBody.breed);

        return new ResponseEntity<>(breedModel, HttpStatus.OK);
    }
}
