package cl.mobdev.dogceoy2k.application.domain.usecase;

import cl.mobdev.dogceoy2k.application.data.info.repository.BreedImagesRepository;
import cl.mobdev.dogceoy2k.application.data.info.repository.BreedInfoRepository;
import cl.mobdev.dogceoy2k.application.data.info.repository.SubBreedsRepository;
import cl.mobdev.dogceoy2k.application.domain.model.BreedImagesModel;
import cl.mobdev.dogceoy2k.application.domain.model.BreedInfoModel;
import cl.mobdev.dogceoy2k.application.domain.model.SubBreedsModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

class BreedInfoUseCaseImplTest {

    private BreedInfoUseCase sut;
    private BreedInfoModel breedInfoModelMock;
    private BreedImagesModel breedImagesModelMock;
    private SubBreedsModel subBreedsModelMock;

    private final String BREED_NAME = "bulldog";

    private final String DATA_IMAGES_1 = "https://images.dog.ceo/breeds/bulldog-boston/20200710_175933.jpg";
    private final String DATA_IMAGES_2 = "https://images.dog.ceo/breeds/bulldog-boston/20200710_175944.jpg";
    private final String DATA_IMAGES_3 = "https://images.dog.ceo/breeds/bulldog-boston/n02096585_10380.jpg";

    private final String DATA_SUBBREED_1 = "french";
    private final String DATA_SUBBREED_2 = "english";
    private final String DATA_SUBBREED_3 = "boston";

    @Mock
    private BreedImagesRepository breedImagesRepositoryMock;

    @Mock
    private SubBreedsRepository subBreedsRepositoryMock;

    @Mock
    private BreedInfoRepository breedInfoRepositoryMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        sut = new BreedInfoUseCaseImpl(breedInfoRepositoryMock);

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

        breedImagesModelMock = new BreedImagesModel();
        breedImagesModelMock.images = new ArrayList<>();
        breedImagesModelMock.images.add(DATA_IMAGES_1);
        breedImagesModelMock.images.add(DATA_IMAGES_2);
        breedImagesModelMock.images.add(DATA_IMAGES_3);

        subBreedsModelMock = new SubBreedsModel();
        subBreedsModelMock.subBreed = new ArrayList<>();
        subBreedsModelMock.subBreed.add(DATA_SUBBREED_1);
        subBreedsModelMock.subBreed.add(DATA_SUBBREED_2);
        subBreedsModelMock.subBreed.add(DATA_SUBBREED_3);
    }

    @Test
    public void shouldReturnValidBreedModel_whereIsCalled(){
        when(breedImagesRepositoryMock.getBreedImages(BREED_NAME)).thenReturn(breedImagesModelMock);
        when(subBreedsRepositoryMock.getSubBreeds(BREED_NAME)).thenReturn(subBreedsModelMock);
        when(breedInfoRepositoryMock.GetBreedInfo(BREED_NAME)).thenReturn(breedInfoModelMock);

        BreedInfoModel breed = sut.getBreedInfo(BREED_NAME);

        Assertions.assertEquals(BREED_NAME, breed.breed);

        Assertions.assertEquals(breedImagesModelMock.images.stream().count(), breed.images.stream().count());
        Assertions.assertEquals(breedImagesModelMock.images.stream().findFirst(), breed.images.stream().findFirst());

        Assertions.assertEquals(subBreedsModelMock.subBreed.stream().count(), breed.subBreed.stream().count());
        Assertions.assertEquals(subBreedsModelMock.subBreed.stream().findFirst(), breed.subBreed.stream().findFirst());
    }
}