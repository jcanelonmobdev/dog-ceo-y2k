package cl.mobdev.dogceoy2k.application.presentation;

import cl.mobdev.dogceoy2k.application.domain.model.BreedDetailsModel;
import cl.mobdev.dogceoy2k.application.domain.usecase.BreedDetailUseCase;
import cl.mobdev.dogceoy2k.application.presentation.body.DetailsBody;
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

    private BreedDetailsModel breedDetailsModelMock;
    private DetailsBody detailsBodyMock;

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

        detailsBodyMock = new DetailsBody();
        detailsBodyMock.breed = BREED_NAME;

        breedDetailsModelMock = new BreedDetailsModel();
        breedDetailsModelMock.breed = BREED_NAME;
        breedDetailsModelMock.images = new ArrayList<>();
        breedDetailsModelMock.images.add(DATA_IMAGES_1);
        breedDetailsModelMock.images.add(DATA_IMAGES_2);
        breedDetailsModelMock.images.add(DATA_IMAGES_3);
        breedDetailsModelMock.subBreeds = new ArrayList<>();
        breedDetailsModelMock.subBreeds.add(DATA_SUBBREED_1);
        breedDetailsModelMock.subBreeds.add(DATA_SUBBREED_2);
        breedDetailsModelMock.subBreeds.add(DATA_SUBBREED_3);
    }

    @Test
    public void shouldReturnValidBreedModel_whenIsCalled(){
        when(breedDetailUseCaseMock.getBreedDetails(BREED_NAME)).thenReturn(breedDetailsModelMock);

        ResponseEntity<BreedDetailsModel> responseEntity = sut.info(detailsBodyMock);
        BreedDetailsModel breedDetailsModel = responseEntity.getBody();

        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertNotNull(responseEntity.getBody());

        Assertions.assertEquals(BREED_NAME, breedDetailsModel.breed);


    }
}