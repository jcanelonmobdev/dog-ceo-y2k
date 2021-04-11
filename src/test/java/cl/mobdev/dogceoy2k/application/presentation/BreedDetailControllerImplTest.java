package cl.mobdev.dogceoy2k.application.presentation;

import cl.mobdev.dogceoy2k.application.domain.model.BreedModel;
import cl.mobdev.dogceoy2k.application.domain.usecase.BreedUseCase;
import cl.mobdev.dogceoy2k.application.presentation.body.BreedBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import static org.mockito.Mockito.when;

class BreedDetailControllerImplTest {

    private BreedDetailController sut;
    private BreedModel breedModelMock;
    private BreedBody breedBody;

    private final String BREED_NAME = "bulldog";




    @Mock
    private BreedUseCase breedUseCaseMock;

    @BeforeEach
    void setUp() {
        // NOTE: Coloque estos atributos como variables para que el IDE no me reclamara (Field can be covered to a local variable)
        String DATA_IMAGES_1 = "https://images.dog.ceo/breeds/bulldog-boston/20200710_175933.jpg";
        String DATA_IMAGES_2 = "https://images.dog.ceo/breeds/bulldog-boston/20200710_175944.jpg";
        String DATA_IMAGES_3 = "https://images.dog.ceo/breeds/bulldog-boston/n02096585_10380.jpg";

        String DATA_SUBBREED_1 = "french";
        String DATA_SUBBREED_2 = "english";
        String DATA_SUBBREED_3 = "boston";

        MockitoAnnotations.openMocks(this);
        sut = new BreedDetailControllerImpl(breedUseCaseMock);

        breedBody = new BreedBody();
        breedBody.breed = BREED_NAME;

        breedModelMock = new BreedModel();
        breedModelMock.breed = BREED_NAME;
        breedModelMock.images = new ArrayList<>();
        breedModelMock.images.add(DATA_IMAGES_1);
        breedModelMock.images.add(DATA_IMAGES_2);
        breedModelMock.images.add(DATA_IMAGES_3);
        breedModelMock.subBreed = new ArrayList<>();
        breedModelMock.subBreed.add(DATA_SUBBREED_1);
        breedModelMock.subBreed.add(DATA_SUBBREED_2);
        breedModelMock.subBreed.add(DATA_SUBBREED_3);
    }

    @Test
    public void shouldReturnValidBreedModel_whenIsCalled(){
        when(breedUseCaseMock.getInfo(BREED_NAME)).thenReturn(breedModelMock);

        ResponseEntity<BreedModel> responseEntity = sut.info(breedBody);

        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertNotNull(responseEntity.getBody());
    }
}