package svg.altencodejob.infra.adapters.input;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import svg.altencodejob.domain.PriceDTO;
import svg.altencodejob.infra.ports.input.PricesInputPort;

import java.util.List;

@RestController
@RequestMapping("/api/v1/prices/")
public class PricesController {

    private final PricesInputPort pricesInputPort;
    private final PriceMapper priceMapper;

    public PricesController(PricesInputPort pricesInputPort, PriceMapper priceMapper) {
        this.pricesInputPort = pricesInputPort;
        this.priceMapper = priceMapper;
    }

    @GetMapping
    public List<PriceDTO> getAll(){
        var prices = pricesInputPort.getAll();
        return prices.stream().map(priceMapper::map).toList();
    }

    @GetMapping("/by")
    public List<PriceDTO> getPricesByBrandIdAndProductId(
            @RequestParam(name = "brand_id") Integer brandId,
            @RequestParam(name = "product_id") int productId) {
        var prices = pricesInputPort.getPricesByBrandIdAndProductId(brandId, productId);
        return prices.stream().map(priceMapper::map).toList();
    }

    @GetMapping("/bydate")
    public List<PriceDTO> getPricesByBrandIdProductIdAndDate(
            @RequestParam(name = "brand_id") Integer brandId,
            @RequestParam(name = "product_id") int productId,
            @RequestParam(name = "date") String appliedDate) {
        var prices = pricesInputPort.getPricesByBrandIdProductIdAndDate(brandId, productId, appliedDate);
        return prices.stream().map(priceMapper::map).toList();
    }
}