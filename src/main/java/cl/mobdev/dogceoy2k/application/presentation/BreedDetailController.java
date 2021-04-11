package cl.mobdev.dogceoy2k.application.presentation;

import cl.mobdev.dogceoy2k.application.domain.model.BreedModel;
import cl.mobdev.dogceoy2k.application.presentation.body.BreedBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/v1")
@RestController
public interface BreedDetailController {
    @PostMapping(value = "/info", consumes = "application/json", produces = "application/json")
    ResponseEntity<BreedModel> info(@RequestBody BreedBody breedBody);
}
