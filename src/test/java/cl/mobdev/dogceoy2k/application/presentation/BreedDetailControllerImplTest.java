package cl.mobdev.dogceoy2k.application.presentation;

import cl.mobdev.dogceoy2k.application.domain.model.BreedDetailModel;
import cl.mobdev.dogceoy2k.application.domain.usecase.BreedDetailUseCase;
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

    private BreedDetailModel breedDetailModelMock;
    private BreedBody breedBodyMock;

    private final String BREED_NAME = "bulldog";

    @Mock
    private BreedDetailUseCase breedDetailUseCaseMock;

    @BeforeEach
    void setUp() {
        String DATA_IMAGES_1 = "https://images.dog.ceo/breeds/bulldog-boston/20200710_175933.jpg";
        String DATA_IMAGES_2 = "https://images.dog.ceo/breeds/bulldog-boston/20200710_175944.jpg";
        String DATA_IMAGES_3 = "https://images.dog.ceo/breeds/bulldog-boston/n02096585_10380.jpg";

        String DATA_SUBBREED_1 = "french";
        String DATA_SUBBREED_2 = "english";
        String DATA_SUBBREED_3 = "boston";

        MockitoAnnotations.openMocks(this);
        sut = new BreedDetailControllerImpl(breedDetailUseCaseMock);

        breedBodyMock = new BreedBody();
        breedBodyMock.breed = BREED_NAME;

        breedDetailModelMock = new BreedDetailModel();
        breedDetailModelMock.breed = BREED_NAME;
        breedDetailModelMock.images = new ArrayList<>();
        breedDetailModelMock.images.add(DATA_IMAGES_1);
        breedDetailModelMock.images.add(DATA_IMAGES_2);
        breedDetailModelMock.images.add(DATA_IMAGES_3);
        breedDetailModelMock.subBreeds = new ArrayList<>();
        breedDetailModelMock.subBreeds.add(DATA_SUBBREED_1);
        breedDetailModelMock.subBreeds.add(DATA_SUBBREED_2);
        breedDetailModelMock.subBreeds.add(DATA_SUBBREED_3);
    }

    @Test
    public void shouldReturnValidBreedModel_whenIsCalled(){
        when(breedDetailUseCaseMock.getBreedDetails(BREED_NAME)).thenReturn(breedDetailModelMock);

        ResponseEntity<BreedDetailModel> responseEntity = sut.info(breedBodyMock);
        BreedDetailModel breedDetailModel = responseEntity.getBody();

        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertNotNull(responseEntity.getBody());

        Assertions.assertEquals(BREED_NAME, breedDetailModel.breed);


    }
}