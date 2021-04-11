package cl.mobdev.dogceoy2k.application.data.info.mapper;

import cl.mobdev.dogceoy2k.application.data.info.entity.SubBreedsEntity;
import cl.mobdev.dogceoy2k.application.domain.model.SubBreedsModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SubBreedsModelToSubBreedsEntityMapperTest {

    private SubBreedsModelToSubBreedsEntityMapper sut;
    private SubBreedsEntity subBreedsEntityMock;
    private final String DATA_STATUS = "success";
    private final String DATA_IMAGES_1 = "https://images.dog.ceo/breeds/bulldog-boston/20200710_175933.jpg";
    private final String DATA_IMAGES_2 = "https://images.dog.ceo/breeds/bulldog-boston/20200710_175944.jpg";
    private final String DATA_IMAGES_3 = "https://images.dog.ceo/breeds/bulldog-boston/n02096585_10380.jpg";

    @BeforeEach
    void setUp() {
        sut = new SubBreedsModelToSubBreedsEntityMapper();

        subBreedsEntityMock = new SubBreedsEntity();
        subBreedsEntityMock.status = DATA_STATUS;
        subBreedsEntityMock.message = new ArrayList<>();
        subBreedsEntityMock.message.add(DATA_IMAGES_1);
        subBreedsEntityMock.message.add(DATA_IMAGES_2);
        subBreedsEntityMock.message.add(DATA_IMAGES_3);
    }

    @Test
    public void shouldReturnValidSubBreeds_whenReverseMapIsCalled(){
        SubBreedsModel subBreeds = sut.reverseMap(subBreedsEntityMock);

        Assertions.assertEquals(subBreedsEntityMock.message.stream().count(), subBreeds.subBreed.stream().count());
    }
}