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
        String json = "{\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":1234,\"price\":\"12.99\",\"createdDate\":\"2023-06-07T07:02:38.2806942-05:00\",\"lastUpdatedDate\":\"2023-06-07T07:02:38.2816955-05:00\",\"myLocalDate\":\"20230607\",\"beerId\":\"ee6376d9-6b65-4451-ba21-23bc5a03e003\"}";

        BeerDto beerDto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(beerDto);
    }
}