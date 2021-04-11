package cl.mobdev.dogceoy2k.application.data.info.mapper;

import cl.mobdev.dogceoy2k.application.data.info.entity.BreedImagesEntity;
import cl.mobdev.dogceoy2k.application.domain.model.BreedImagesModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BreedImagesModelToBreedImagesEntityMapperTest {

    private BreedImagesModelToBreedImagesEntityMapper sut;
    private BreedImagesEntity breedImagesEntityMock;
    private final String DATA_STATUS = "success";
    private final String DATA_SUBBREED_1 = "french";
    private final String DATA_SUBBREED_2 = "english";
    private final String DATA_SUBBREED_3 = "boston";

    @BeforeEach
    void setUp() {
        sut = new BreedImagesModelToBreedImagesEntityMapper();

        breedImagesEntityMock = new BreedImagesEntity();
        breedImagesEntityMock.status = DATA_STATUS;
        breedImagesEntityMock.message = new ArrayList<>();
        breedImagesEntityMock.message.add(DATA_SUBBREED_1);
        breedImagesEntityMock.message.add(DATA_SUBBREED_2);
        breedImagesEntityMock.message.add(DATA_SUBBREED_3);
    }

    @Test
    public void shouldReturnValidBreedImages_whenReverseMapIsCalled(){
        BreedImagesModel breedImages = sut.reverseMap(breedImagesEntityMock);

        Assertions.assertEquals(breedImagesEntityMock.message.stream().count(), breedImages.images.stream().count());
    }
}