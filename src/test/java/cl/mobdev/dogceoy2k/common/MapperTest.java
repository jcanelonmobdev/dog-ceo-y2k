package cl.mobdev.dogceoy2k.common;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class MapperTest {
    private String DATA_STRING = "1";
    private Integer DATA_INTEGER = 1;

    String stringMock;
    Integer integerMock;
    List<String> listStringMock;
    List<Integer> listIntegerMock;

    @Mock
    Mapper<String, Integer> mapperMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        listStringMock = new ArrayList<>();
        listStringMock.add("1");
        listStringMock.add("2");
        listStringMock.add("3");

        stringMock = DATA_STRING;
        integerMock = DATA_INTEGER;

        listIntegerMock = new ArrayList<>();
        listIntegerMock.add(1);
        listIntegerMock.add(2);
        listIntegerMock.add(3);
    }

    @Test
    void shouldMapperMapMethodIsCalled_thenVerifyBehaviour(){

        when(mapperMock.map(listStringMock)).thenReturn(listIntegerMock);

        doCallRealMethod().when(mapperMock).map(listStringMock);
        mapperMock.map(listStringMock);

        verify(mapperMock, times(1)).map(listStringMock);
    }

    @Test
    void shouldMapperReverseMapMethodIsCalled_thenVerifyBehaviour(){

        when(mapperMock.reverseMap(listIntegerMock)).thenReturn(listStringMock);

        doCallRealMethod().when(mapperMock).reverseMap(listIntegerMock);
        mapperMock.reverseMap(listIntegerMock);

        verify(mapperMock, times(1)).reverseMap(listIntegerMock);
    }
}