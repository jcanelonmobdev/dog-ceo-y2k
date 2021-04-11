package cl.mobdev.dogceoy2k.application.data.info.datasource;

import cl.mobdev.dogceoy2k.application.data.info.entity.BreedImagesEntity;
import cl.mobdev.dogceoy2k.configuration.BreedProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestOperations;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

class BreedImagesDataSourceImplTest {

    private final String BREED_NAME = "bulldog";
    private final String DATA_STATUS = "success";
    private final String DATA_SUBBREED_1 = "french";
    private final String DATA_SUBBREED_2 = "english";
    private final String DATA_SUBBREED_3 = "boston";

    private BreedImagesDataSourceImpl sut;
    private BreedImagesEntity breedImagesEntityMock;

    @Mock
    private RestOperations restOperationsMock;

    @Mock
    private BreedProperties breedPropertiesMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sut = new BreedImagesDataSourceImpl(restOperationsMock, breedPropertiesMock);

        breedImagesEntityMock = new BreedImagesEntity();
        breedImagesEntityMock.status = DATA_STATUS;
        breedImagesEntityMock.message = new ArrayList<>();
        breedImagesEntityMock.message.add(DATA_SUBBREED_1);
        breedImagesEntityMock.message.add(DATA_SUBBREED_2);
        breedImagesEntityMock.message.add(DATA_SUBBREED_3);
    }

    @Test
    public void shouldReturnBreedImagesEntity_whenRequestIsExecuted(){
        when(restOperationsMock.getForObject(
                breedPropertiesMock.getBreedImagesURL(BREED_NAME),
                BreedImagesEntity.class
                )
        ).thenReturn(breedImagesEntityMock);

        BreedImagesEntity breedImagesEntity = sut.getImages(BREED_NAME);

        Assertions.assertEquals(breedImagesEntityMock.message.stream().count(), breedImagesEntity.message.stream().count());
        Assertions.assertEquals(DATA_STATUS, breedImagesEntity.status);
    }
}