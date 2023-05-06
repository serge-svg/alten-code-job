package svg.altencodejob.infra.ports.input;

import org.springframework.stereotype.Component;
import svg.altencodejob.domain.Price;

import java.util.List;

@Component
public interface PricesInputPort {

    List<Price> getAll();

    List<Price> getPricesByBrandIdAndProductId(Integer brandId, Integer productId);

    List<Price> getPricesByBrandIdProductIdAndDate(Integer brandId, Integer productId, String date);
}
