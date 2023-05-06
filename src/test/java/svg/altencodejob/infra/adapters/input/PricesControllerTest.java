package svg.altencodejob.infra.adapters.input;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class PricesControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @LocalServerPort
    int port;

    @ParameterizedTest(name = "For brand {0} and product {1} and applying the date {2}")
    @MethodSource("requestProvider")
    void givenARequestToByDateThenReturnPrices(Integer brandId,
                                               Integer productId,
                                               String appliedDate,
                                               String expectedResult) {
        String request = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("localhost")
                .port(port)
                .path("/api/v1/prices/bydate")
                .queryParam("brand_id", brandId)
                .queryParam("product_id", productId)
                .queryParam("date", appliedDate)
                .build().toUriString();

        ResponseEntity<String> response = restTemplate.getForEntity(request, String.class);
        assertEquals(expectedResult, response.getBody());
    }

    public static Stream<Arguments> requestProvider() {
        return Stream.of(
                Arguments.of(1, 35455, "2020-06-14-10.00.00",
                        "[{\"productId\":35455,\"brandId\":1,\"priceList\":1,\"startDate\":\"2020-06-14-00.00.00\",\"endDate\":\"2020-12-31-23.59.59\",\"price\":\"35.50 EUR\"}]"),
                Arguments.of(1, 35455, "2020-06-14-16.00.00",
                        "[{\"productId\":35455,\"brandId\":1,\"priceList\":1,\"startDate\":\"2020-06-14-00.00.00\",\"endDate\":\"2020-12-31-23.59.59\",\"price\":\"35.50 EUR\"}," +
                                "{\"productId\":35455,\"brandId\":1,\"priceList\":2,\"startDate\":\"2020-06-14-15.00.00\",\"endDate\":\"2020-06-14-18.30.00\",\"price\":\"25.45 EUR\"}]"),
                Arguments.of(1, 35455, "2020-06-14-21.00.00",
                        "[{\"productId\":35455,\"brandId\":1,\"priceList\":1,\"startDate\":\"2020-06-14-00.00.00\",\"endDate\":\"2020-12-31-23.59.59\",\"price\":\"35.50 EUR\"}]"),
                Arguments.of(1, 35455, "2020-06-15-10.00.00",
                        "[{\"productId\":35455,\"brandId\":1,\"priceList\":1,\"startDate\":\"2020-06-14-00.00.00\",\"endDate\":\"2020-12-31-23.59.59\",\"price\":\"35.50 EUR\"}," +
                                "{\"productId\":35455,\"brandId\":1,\"priceList\":3,\"startDate\":\"2020-06-15-00.00.00\",\"endDate\":\"2020-06-15-11.00.00\",\"price\":\"30.50 EUR\"}]"),
                Arguments.of(1, 35455, "2020-06-16-21.00.00",
                        "[{\"productId\":35455,\"brandId\":1,\"priceList\":1,\"startDate\":\"2020-06-14-00.00.00\",\"endDate\":\"2020-12-31-23.59.59\",\"price\":\"35.50 EUR\"}," +
                                "{\"productId\":35455,\"brandId\":1,\"priceList\":4,\"startDate\":\"2020-06-15-16.00.00\",\"endDate\":\"2020-12-31-23.59.59\",\"price\":\"38.95 EUR\"}]")
        );
    }
}
