package svg.altencodejob.infra.ports.output;


import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import svg.altencodejob.domain.Price;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@DataJpaTest
@ExtendWith(SpringExtension.class)
class PricesRepositoryTest implements WithAssertions {

    @Autowired
    PricesRepository pricesRepository;

    @Test
    @DisplayName("Retrieve all")
    void findAll() {
        Iterable<Price> prices = pricesRepository.findAll();
        assertThat(prices).isNotEmpty().hasSize(4);
    }
    @Test
    @DisplayName("Retrieve by brandId And productId")
    void findPricesByBrandIdAndProductId() {
        var brandId = 1;
        var productId = 35455;
        Iterable<Price> prices = pricesRepository.findPricesByBrandIdAndProductId(brandId, productId);
        assertThat(prices).isNotEmpty().hasSize(4);
    }

    @Test
    @DisplayName("Retrieve by brandId And productId and date 2020-06-14-10.00.00")
    void findPricesByBrandIdAndProductIdAndDate_2020_06_14_10_00_00() {
        var brandId = 1;
        var productId = 35455;
        var date = "2020-06-14-10.00.00";
        Iterable<Price> prices = pricesRepository.findBy(brandId, productId, stringToTimestamp(date));
        assertThat(prices).isNotEmpty().hasSize(1);
    }

    @Test
    @DisplayName("Retrieve by brandId And productId and date 2020-06-14-16.00.00")
    void findPricesByBrandIdAndProductIdAndDate_2020_06_14_16_00_00() {
        var brandId = 1;
        var productId = 35455;
        var date = "2020-06-14-16.00.00";
        Iterable<Price> prices = pricesRepository.findBy(brandId, productId, stringToTimestamp(date));
        assertThat(prices).isNotEmpty().hasSize(2);
    }

    @Test
    @DisplayName("Retrieve by brandId And productId and date 2020-06-14-21.00.00")
    void findPricesByBrandIdAndProductIdAndDate_2020_06_14_21_00_00() {
        var brandId = 1;
        var productId = 35455;
        var date = "2020-06-14-21.00.00";
        Iterable<Price> prices = pricesRepository.findBy(brandId, productId, stringToTimestamp(date));
        assertThat(prices).isNotEmpty().hasSize(1);
    }

    @Test
    @DisplayName("Retrieve by brandId And productId and date 2020-06-15-10.00.00")
    void findPricesByBrandIdAndProductIdAndDate_2020_06_15_10_00_00() {
        var brandId = 1;
        var productId = 35455;
        var date = "2020-06-15-10.00.00";
        Iterable<Price> prices = pricesRepository.findBy(brandId, productId, stringToTimestamp(date));
        assertThat(prices).isNotEmpty().hasSize(2);
    }

    @Test
    @DisplayName("Retrieve by brandId And productId and date 2020-06-16-21.00.00")
    void findPricesByBrandIdAndProductIdAndDate_2020_06_16_21_00_00() {
        var brandId = 1;
        var productId = 35455;
        var date = "2020-06-16-21.00.00";
        Iterable<Price> prices = pricesRepository.findBy(brandId, productId, stringToTimestamp(date));
        assertThat(prices).isNotEmpty().hasSize(2);
    }

    private Timestamp stringToTimestamp(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        return Timestamp.valueOf(LocalDateTime.parse(date, formatter));
    }

}
