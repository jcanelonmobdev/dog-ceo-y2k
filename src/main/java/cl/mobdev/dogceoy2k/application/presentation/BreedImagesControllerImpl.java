package cl.mobdev.dogceoy2k.application.presentation;

import cl.mobdev.dogceoy2k.application.domain.model.BreedImagesModel;
import cl.mobdev.dogceoy2k.application.domain.usecase.BreedImagesUseCase;
import cl.mobdev.dogceoy2k.application.presentation.body.BreedImagesBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public class BreedImagesControllerImpl implements BreedImagesController {
    private final BreedImagesUseCase breedImagesUseCase;

    public BreedImagesControllerImpl(BreedImagesUseCase breedImagesUseCase){

        this.breedImagesUseCase = breedImagesUseCase;
    }

    @Override
    public ResponseEntity<BreedImagesModel> images(@RequestBody BreedImagesBody breedImagesBody) {
        BreedImagesModel breedImages = this.breedImagesUseCase.getBreedImages(breedImagesBody.breed);

        return new ResponseEntity<>(breedImages, HttpStatus.OK);
    }
}
