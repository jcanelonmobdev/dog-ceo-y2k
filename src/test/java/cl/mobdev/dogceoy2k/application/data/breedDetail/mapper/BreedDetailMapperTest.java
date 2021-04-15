package cl.mobdev.dogceoy2k.application.data.breedDetail.mapper;

import cl.mobdev.dogceoy2k.application.domain.model.BreedDetailModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

class BreedDetailMapperTest {
    private BreedDetailMapper sut;

    private final String BREED_NAME = "raza";
    private BreedDetailModel breedDetailModelMock;


    @BeforeEach
    void setUp() {
        sut = new BreedDetailMapper();
        breedDetailModelMock = new BreedDetailModel();
    }

    @Test
    public void shouldReturnNull_whenMapIsCalled(){
        String breedDetail = sut.map(breedDetailModelMock);
        Assertions.assertNull(breedDetail);
    }

    @Test
    public void shouldReturnValidBreedDetail_whenReverseMapIsCalled(){
        BreedDetailModel breedDetail = sut.reverseMap(BREED_NAME);

        Assertions.assertEquals(BREED_NAME, breedDetail.breed);
    }
}