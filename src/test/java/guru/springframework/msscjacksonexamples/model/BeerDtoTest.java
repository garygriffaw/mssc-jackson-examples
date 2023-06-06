package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@JsonTest
class BeerDtoTest extends BaseTest {

    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto beerDto = getDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);

        System.out.println(jsonString);
    }

    @Test
    void testDeserialize() throws IOException {
        String json = "{\"beerId\":\"4eb81dab-d623-4fbf-970b-f5fe49fd2f1c\",\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":1234,\"price\":12.99,\"createdDate\":\"2023-06-06T17:02:47.4578072-05:00\",\"lastUpdatedDate\":\"2023-06-06T17:02:47.4588088-05:00\"}";

        BeerDto beerDto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(beerDto);
    }
}