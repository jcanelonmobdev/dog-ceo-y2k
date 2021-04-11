package cl.mobdev.dogceoy2k.application.data.info.repository;

import cl.mobdev.dogceoy2k.application.data.info.datasource.SubBreedsDataSource;
import cl.mobdev.dogceoy2k.application.data.info.entity.BreedImagesEntity;
import cl.mobdev.dogceoy2k.application.data.info.entity.SubBreedsEntity;
import cl.mobdev.dogceoy2k.application.domain.model.BreedImagesModel;
import cl.mobdev.dogceoy2k.application.domain.model.SubBreedsModel;
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

class SubBreedsRepositoryImplTest {

    private final String BREED_NAME = "bulldog";
    private final String DATA_STATUS = "success";
    private final String DATA_SUBBREED_1 = "french";
    private final String DATA_SUBBREED_2 = "english";
    private final String DATA_SUBBREED_3 = "boston";

    private SubBreedsRepositoryImpl sut;

    private SubBreedsEntity subBreedsEntityMock;
    private SubBreedsModel subBreedsModelMock;

    @Mock
    private SubBreedsDataSource subBreedsDataSourceMock;

    @Mock
    private Mapper<SubBreedsModel, SubBreedsEntity> subBreedsModelSubBreedsEntityMapperMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sut = new SubBreedsRepositoryImpl(subBreedsModelSubBreedsEntityMapperMock, subBreedsDataSourceMock);

        subBreedsEntityMock = new SubBreedsEntity();
        subBreedsEntityMock.status = DATA_STATUS;
        subBreedsEntityMock.message = new ArrayList<>();
        subBreedsEntityMock.message.add(DATA_SUBBREED_1);
        subBreedsEntityMock.message.add(DATA_SUBBREED_2);
        subBreedsEntityMock.message.add(DATA_SUBBREED_3);

        subBreedsModelMock = new SubBreedsModel();
        subBreedsModelMock.subBreed = new ArrayList<>();
        subBreedsModelMock.subBreed.add(DATA_SUBBREED_1);
        subBreedsModelMock.subBreed.add(DATA_SUBBREED_2);
        subBreedsModelMock.subBreed.add(DATA_SUBBREED_3);
    }

    @Test
    public void shouldReturnValidSubBreeds_whenGetSubBreedsIsCalled(){
        when(subBreedsDataSourceMock.getSubBreeds(BREED_NAME)).thenReturn(subBreedsEntityMock);
        when(subBreedsModelSubBreedsEntityMapperMock.reverseMap(subBreedsEntityMock)).thenReturn(subBreedsModelMock);

        SubBreedsModel subBreeds = sut.getSubBreeds(BREED_NAME);

        Assertions.assertEquals(subBreedsModelMock.subBreed.stream().count(), subBreeds.subBreed.stream().count());
        Assertions.assertEquals(subBreedsModelMock.subBreed.stream().findFirst(),subBreeds.subBreed.stream().findFirst()) ;
    }
}