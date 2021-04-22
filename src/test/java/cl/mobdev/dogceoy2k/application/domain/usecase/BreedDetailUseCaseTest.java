package cl.mobdev.dogceoy2k.application.domain.usecase;

import cl.mobdev.dogceoy2k.application.domain.model.BreedDetailsModel;
import cl.mobdev.dogceoy2k.application.domain.repository.BreedRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

class BreedDetailUseCaseTest {

    private final String BREED_NAME = "bulldog";
    private final String DATA_IMAGES_1 = "https://images.dog.ceo/breeds/bulldog-boston/20200710_175933.jpg";
    private final String DATA_IMAGES_2 = "https://images.dog.ceo/breeds/bulldog-boston/20200710_175944.jpg";
    private final String DATA_IMAGES_3 = "https://images.dog.ceo/breeds/bulldog-boston/n02096585_10380.jpg";

    private final String DATA_SUBBREED_1 = "french";
    private final String DATA_SUBBREED_2 = "english";
    private final String DATA_SUBBREED_3 = "boston";

    private BreedDetailUseCase sut;
    private BreedDetailsModel breedDetailsModelMock;

    @Mock
    private BreedRepository breedRepositoryMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        sut = new BreedDetailUseCase(breedRepositoryMock);

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
    void shouldReturnValidBreedDetailModel_whenGetBreedDetailsIsCalled() {
        when(breedRepositoryMock.getDetails(BREED_NAME)).thenReturn(breedDetailsModelMock);

        BreedDetailsModel breedDetail = sut.getBreedDetails(BREED_NAME);

        Assertions.assertEquals(breedDetailsModelMock.breed, breedDetail.breed);
        Assertions.assertEquals(breedDetailsModelMock.subBreeds.stream().count(), breedDetail.subBreeds.stream().count());
        Assertions.assertEquals(breedDetailsModelMock.subBreeds.stream().findFirst(), breedDetail.subBreeds.stream().findFirst());

        Assertions.assertEquals(breedDetailsModelMock.images.stream().count(), breedDetail.images.stream().count());
        Assertions.assertEquals(breedDetailsModelMock.images.stream().findFirst(), breedDetail.images.stream().findFirst());
    }
}