package cl.mobdev.dogceoy2k.application.presentation;

import cl.mobdev.dogceoy2k.application.domain.model.BreedInfoModel;
import cl.mobdev.dogceoy2k.application.domain.usecase.BreedInfoUseCase;
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
    private BreedInfoModel breedInfoModelMock;
    private BreedBody breedBody;

    private final String BREED_NAME = "bulldog";




    @Mock
    private BreedInfoUseCase breedInfoUseCaseMock;

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
        sut = new BreedDetailControllerImpl(breedInfoUseCaseMock);

        breedBody = new BreedBody();
        breedBody.breed = BREED_NAME;

        breedInfoModelMock = new BreedInfoModel();
        breedInfoModelMock.breed = BREED_NAME;
        breedInfoModelMock.images = new ArrayList<>();
        breedInfoModelMock.images.add(DATA_IMAGES_1);
        breedInfoModelMock.images.add(DATA_IMAGES_2);
        breedInfoModelMock.images.add(DATA_IMAGES_3);
        breedInfoModelMock.subBreed = new ArrayList<>();
        breedInfoModelMock.subBreed.add(DATA_SUBBREED_1);
        breedInfoModelMock.subBreed.add(DATA_SUBBREED_2);
        breedInfoModelMock.subBreed.add(DATA_SUBBREED_3);
    }

    @Test
    public void shouldReturnValidBreedModel_whenIsCalled(){
        when(breedInfoUseCaseMock.getBreedInfo(BREED_NAME)).thenReturn(breedInfoModelMock);

        ResponseEntity<BreedInfoModel> responseEntity = sut.info(breedBody);

        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertNotNull(responseEntity.getBody());
    }
}