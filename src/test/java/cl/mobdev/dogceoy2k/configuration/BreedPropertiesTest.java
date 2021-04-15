package cl.mobdev.dogceoy2k.configuration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;

class BreedPropertiesTest {

    private BreedProperties sut;

    private final String DATA_BREED = "bulldog";

    private final String DATA_BASE_URL = "https://dog.ceo/api/";
    private final String DATA_SUBBREEDS = "breed/{breed_name}/list";
    private final String DATA_IMAGES = "breed/{breed_name}/images";

    private final String DATA_SUBBREEDS_FULL_URL = "https://dog.ceo/api/breed/bulldog/list";
    private final String DATA_IMAGES_FULL_URL = "https://dog.ceo/api/breed/bulldog/images";

    @BeforeEach
    void setUp() {
        sut = new BreedProperties();
        ReflectionTestUtils.setField(sut, "baseURL", DATA_BASE_URL);
        ReflectionTestUtils.setField(sut, "subBreedEndPoint", DATA_SUBBREEDS);
        ReflectionTestUtils.setField(sut, "imagesBreedEndPoint", DATA_IMAGES);
    }

    @Test
    void getSubBreedsURL() {
        String actual = sut.getSubBreedsURL(DATA_BREED);

        Assertions.assertEquals(DATA_SUBBREEDS_FULL_URL, actual);
    }

    @Test
    void getBreedImagesURL() {
        String actual = sut.getBreedImagesURL(DATA_BREED);

        Assertions.assertEquals(DATA_IMAGES_FULL_URL, actual);
    }
}