package cl.mobdev.dogceoy2k.application.data.info.datasource;

import cl.mobdev.dogceoy2k.application.data.subBreed.entity.SubBreedsEntity;
import cl.mobdev.dogceoy2k.application.data.subBreed.datasource.SubBreedsDataSourceImpl;
import cl.mobdev.dogceoy2k.configuration.BreedProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestOperations;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

class SubBreedsDataSourceImplTest {

    private final String BREED_NAME = "bulldog";
    private final String DATA_STATUS = "success";
    private final String DATA_SUBBREED_1 = "french";
    private final String DATA_SUBBREED_2 = "english";
    private final String DATA_SUBBREED_3 = "boston";

    private SubBreedsDataSourceImpl sut;
    private SubBreedsEntity subBreedsEntityMock;

    @Mock
    private RestOperations restOperationsMock;

    @Mock
    private BreedProperties breedPropertiesMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sut = new SubBreedsDataSourceImpl(restOperationsMock, breedPropertiesMock);

        subBreedsEntityMock = new SubBreedsEntity();
        subBreedsEntityMock.status = DATA_STATUS;
        subBreedsEntityMock.message = new ArrayList<>();
        subBreedsEntityMock.message.add(DATA_SUBBREED_1);
        subBreedsEntityMock.message.add(DATA_SUBBREED_2);
        subBreedsEntityMock.message.add(DATA_SUBBREED_3);
    }

    @Test
    public void shouldReturnSubBreedsEntity_whenRequestIsExecuted(){
        when(restOperationsMock.getForObject(
                breedPropertiesMock.getSubBreedsURL(BREED_NAME),
                SubBreedsEntity.class
                )
        ).thenReturn(subBreedsEntityMock);

        SubBreedsEntity subBreedsEntity = sut.getSubBreeds(BREED_NAME);

        Assertions.assertEquals(subBreedsEntityMock.message.stream().count(), subBreedsEntity.message.stream().count());
        Assertions.assertEquals(DATA_STATUS, subBreedsEntity.status);
    }
}