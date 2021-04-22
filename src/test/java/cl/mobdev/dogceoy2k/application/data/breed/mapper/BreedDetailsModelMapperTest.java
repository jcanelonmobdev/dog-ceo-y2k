package cl.mobdev.dogceoy2k.application.data.breed.mapper;

import cl.mobdev.dogceoy2k.application.domain.model.BreedDetailsModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BreedDetailsModelMapperTest {
    private BreedDetailsModelMapper sut;

    private final String BREED_NAME = "raza";
    private BreedDetailsModel breedDetailsModelMock;


    @BeforeEach
    void setUp() {
        sut = new BreedDetailsModelMapper();
        breedDetailsModelMock = new BreedDetailsModel();
    }

    @Test
    public void shouldReturnNull_whenMapIsCalled(){
        String breedDetail = sut.map(breedDetailsModelMock);
        Assertions.assertNull(breedDetail);
    }

    @Test
    public void shouldReturnValidBreedDetail_whenReverseMapIsCalled(){
        BreedDetailsModel breedDetail = sut.reverseMap(BREED_NAME);

        Assertions.assertEquals(BREED_NAME, breedDetail.breed);
    }
}