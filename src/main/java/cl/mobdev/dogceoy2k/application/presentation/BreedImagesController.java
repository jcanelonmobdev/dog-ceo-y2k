package cl.mobdev.dogceoy2k.application.presentation;

import cl.mobdev.dogceoy2k.application.domain.model.BreedImagesModel;
import cl.mobdev.dogceoy2k.application.presentation.body.BreedImagesBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/v1")
@RestController
public interface BreedImagesController {
    @PostMapping(value = "/images", consumes = "application/json", produces = "application/json")
    ResponseEntity<BreedImagesModel> images(@RequestBody BreedImagesBody breedImagesBody);
}
