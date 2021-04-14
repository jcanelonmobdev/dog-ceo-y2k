package cl.mobdev.dogceoy2k.application.data.breedDetail.repository;

import cl.mobdev.dogceoy2k.application.data.breedDetail.mapper.BreedDetailMapper;
import cl.mobdev.dogceoy2k.application.data.breedImage.datasource.BreedImagesDataSource;
import cl.mobdev.dogceoy2k.application.data.breedImage.entity.BreedImagesEntity;
import cl.mobdev.dogceoy2k.application.data.subBreed.datasource.SubBreedsDataSource;
import cl.mobdev.dogceoy2k.application.data.subBreed.entity.SubBreedsEntity;
import cl.mobdev.dogceoy2k.application.domain.model.BreedDetailModel;
import cl.mobdev.dogceoy2k.common.Mapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class BreedDetailRepositoryImplTest {

    private final String BREED_NAME = "bulldog";
    private final String DATA_STATUS = "success";
    private final String DATA_IMAGES_1 = "https://images.dog.ceo/breeds/bulldog-boston/20200710_175933.jpg";
    private final String DATA_IMAGES_2 = "https://images.dog.ceo/breeds/bulldog-boston/20200710_175944.jpg";
    private final String DATA_IMAGES_3 = "https://images.dog.ceo/breeds/bulldog-boston/n02096585_10380.jpg";

    private final String DATA_SUBBREED_1 = "french";
    private final String DATA_SUBBREED_2 = "english";
    private final String DATA_SUBBREED_3 = "boston";

    private BreedDetailRepositoryImpl sut;
    private SubBreedsEntity subBreedsEntityMock;
    private BreedImagesEntity breedImagesEntityMock;
    private BreedDetailModel breedDetailModel;

    @Mock
    private BreedImagesDataSource breedImagesDataSourceMock;

    @Mock
    private SubBreedsDataSource subBreedsDataSourceMock;

    @Mock
    private Mapper<BreedDetailModel, String> breedDetailModelStringMapperMock;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        sut = new BreedDetailRepositoryImpl(breedImagesDataSourceMock, subBreedsDataSourceMock, breedDetailModelStringMapperMock);

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

        breedDetailModel = new BreedDetailModel();
        breedDetailModel.breed = BREED_NAME;
    }

    @Test
    void getDetails() {
        when(breedImagesDataSourceMock.getImages(BREED_NAME)).thenReturn(breedImagesEntityMock);
        when(subBreedsDataSourceMock.getSubBreeds(BREED_NAME)).thenReturn(subBreedsEntityMock);
        when(breedDetailModelStringMapperMock.reverseMap(BREED_NAME)).thenReturn(breedDetailModel);

        BreedDetailModel breedDetail = sut.getDetails(BREED_NAME);

        Assertions.assertEquals(BREED_NAME, breedDetail.breed);
        Assertions.assertEquals(breedImagesEntityMock.message.stream().count(), breedDetail.images.stream().count());
        Assertions.assertEquals(breedImagesEntityMock.message.stream().findFirst(), breedDetail.images.stream().findFirst());

        Assertions.assertEquals(subBreedsEntityMock.message.stream().count(), breedDetail.subBreeds.stream().count());
        Assertions.assertEquals(subBreedsEntityMock.message.stream().findFirst(), breedDetail.subBreeds.stream().findFirst());


    }
}