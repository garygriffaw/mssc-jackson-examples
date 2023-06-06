package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;

@ActiveProfiles("snake")
@JsonTest
public class BeerDtoSnakeTest extends BaseTest {

    @Test
    void testSnake() throws JsonProcessingException {
        BeerDto beerDto = getDto();

        String json = objectMapper.writeValueAsString(beerDto);

        System.out.println(json);
    }

    @Test
    void testDeserialize() throws IOException {
        String json = "{\"id\":\"40747bdc-ff36-4c6e-9db9-04af51adef7f\",\"beer_name\":\"BeerName\",\"beer_style\":\"Ale\",\"upc\":1234,\"price\":12.99,\"created_date\":\"2023-06-06T17:16:26.5977081-05:00\",\"last_updated_date\":\"2023-06-06T17:16:26.6007078-05:00\"}";

        BeerDto beerDto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(beerDto);
    }
}
