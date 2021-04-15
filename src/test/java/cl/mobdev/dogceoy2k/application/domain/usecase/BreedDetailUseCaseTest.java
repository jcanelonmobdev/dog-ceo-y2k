package cl.mobdev.dogceoy2k.application.domain.usecase;

import cl.mobdev.dogceoy2k.application.domain.model.BreedDetailModel;
import cl.mobdev.dogceoy2k.application.domain.repository.BreedDetailRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
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
    private BreedDetailModel breedDetailModelMock;

    @Mock
    private BreedDetailRepository breedDetailRepositoryMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        sut = new BreedDetailUseCase(breedDetailRepositoryMock);

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
    void shouldReturnValidBreedDetailModel_whenGetBreedDetailsIsCalled() {
        when(breedDetailRepositoryMock.getDetails(BREED_NAME)).thenReturn(breedDetailModelMock);

        BreedDetailModel breedDetail = sut.getBreedDetails(BREED_NAME);

        Assertions.assertEquals(breedDetailModelMock.breed, breedDetail.breed);
        Assertions.assertEquals(breedDetailModelMock.subBreeds.stream().count(), breedDetail.subBreeds.stream().count());
        Assertions.assertEquals(breedDetailModelMock.subBreeds.stream().findFirst(), breedDetail.subBreeds.stream().findFirst());

        Assertions.assertEquals(breedDetailModelMock.images.stream().count(), breedDetail.images.stream().count());
        Assertions.assertEquals(breedDetailModelMock.images.stream().findFirst(), breedDetail.images.stream().findFirst());
    }
}