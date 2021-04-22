package cl.mobdev.dogceoy2k.application.data.breed.repository;

import cl.mobdev.dogceoy2k.application.data.images.datasource.BreedImagesDataSource;
import cl.mobdev.dogceoy2k.application.data.images.entity.BreedImagesEntity;
import cl.mobdev.dogceoy2k.application.data.subbreeds.datasource.SubBreedsDataSource;
import cl.mobdev.dogceoy2k.application.data.subbreeds.entity.SubBreedsEntity;
import cl.mobdev.dogceoy2k.application.domain.model.BreedDetailsModel;
import cl.mobdev.dogceoy2k.common.Mapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

class BreedRepositoryImplTest {

    private final String BREED_NAME = "bulldog";
    private final String DATA_STATUS = "success";
    private final String DATA_IMAGES_1 = "https://images.dog.ceo/breeds/bulldog-boston/20200710_175933.jpg";
    private final String DATA_IMAGES_2 = "https://images.dog.ceo/breeds/bulldog-boston/20200710_175944.jpg";
    private final String DATA_IMAGES_3 = "https://images.dog.ceo/breeds/bulldog-boston/n02096585_10380.jpg";

    private final String DATA_SUBBREED_1 = "french";
    private final String DATA_SUBBREED_2 = "english";
    private final String DATA_SUBBREED_3 = "boston";

    private BreedRepositoryImpl sut;
    private SubBreedsEntity subBreedsEntityMock;
    private BreedImagesEntity breedImagesEntityMock;
    private BreedDetailsModel breedDetailsModel;

    @Mock
    private BreedImagesDataSource breedImagesDataSourceMock;

    @Mock
    private SubBreedsDataSource subBreedsDataSourceMock;

    @Mock
    private Mapper<BreedDetailsModel, String> breedDetailModelStringMapperMock;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        sut = new BreedRepositoryImpl(breedImagesDataSourceMock, subBreedsDataSourceMock, breedDetailModelStringMapperMock);

        breedImagesEntityMock = new BreedImagesEntity();
        breedImagesEntityMock.status = DATA_STATUS;
        breedImagesEntityMock.message = new ArrayList<>();
        breedImagesEntityMock.message.add(DATA_IMAGES_1);
        breedImagesEntityMock.message.add(DATA_IMAGES_2);
        breedImagesEntityMock.message.add(DATA_IMAGES_3);

        subBreedsEntityMock = new SubBreedsEntity();
        subBreedsEntityMock.status = DATA_STATUS;
        subBreedsEntityMock.message = new ArrayList<>();
        subBreedsEntityMock.message.add(DATA_SUBBREED_1);
        subBreedsEntityMock.message.add(DATA_SUBBREED_2);
        subBreedsEntityMock.message.add(DATA_SUBBREED_3);

        breedDetailsModel = new BreedDetailsModel();
        breedDetailsModel.breed = BREED_NAME;
    }

    @Test
    void getDetails() {
        when(breedImagesDataSourceMock.getImages(BREED_NAME)).thenReturn(breedImagesEntityMock);
        when(subBreedsDataSourceMock.getSubBreeds(BREED_NAME)).thenReturn(subBreedsEntityMock);
        when(breedDetailModelStringMapperMock.reverseMap(BREED_NAME)).thenReturn(breedDetailsModel);

        BreedDetailsModel breedDetail = sut.getDetails(BREED_NAME);

        Assertions.assertEquals(BREED_NAME, breedDetail.breed);
        Assertions.assertEquals(breedImagesEntityMock.message.stream().count(), breedDetail.images.stream().count());
        Assertions.assertEquals(breedImagesEntityMock.message.stream().findFirst(), breedDetail.images.stream().findFirst());

        Assertions.assertEquals(subBreedsEntityMock.message.stream().count(), breedDetail.subBreeds.stream().count());
        Assertions.assertEquals(subBreedsEntityMock.message.stream().findFirst(), breedDetail.subBreeds.stream().findFirst());


    }
}