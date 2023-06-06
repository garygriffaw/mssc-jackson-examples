package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;

@ActiveProfiles("kebab")
@JsonTest
public class BeerDtoKebabTest extends BaseTest {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testKebabSerialization() throws JsonProcessingException {
        BeerDto beerDto = getDto();

        String json = objectMapper.writeValueAsString(beerDto);

        System.out.println(json);
    }

    @Test
    void testKebabDeserialization() throws IOException {
        String json = "{\"id\":\"5258767c-e478-4304-9ea1-91479d920bdd\",\"beer-name\":\"BeerName\",\"beer-style\":\"Ale\",\"upc\":1234,\"price\":12.99,\"created-date\":\"2023-06-06T17:37:47.8034923-05:00\",\"last-updated-date\":\"2023-06-06T17:37:47.8055064-05:00\"}";

        BeerDto beerDto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(beerDto);
    }
}
