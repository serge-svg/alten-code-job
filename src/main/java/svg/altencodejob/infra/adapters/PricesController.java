package svg.altencodejob.infra.adapters;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import svg.altencodejob.domain.PriceDTO;

import java.util.List;

@RestController
@RequestMapping("/api/v1/prices/")
public class PricesController {

    @GetMapping
    public List<PriceDTO> getAll(){
        return null;
    }

    @GetMapping("/by")
    public List<PriceDTO> getPricesByBrandIdAndProductId(
            @RequestParam(name = "brand_id") Integer brandId,
            @RequestParam(name = "product_id") int productId) {
        return null;
    }

    @GetMapping("/bydate")
    public List<PriceDTO> getPricesByBrandIdProductIdAndDate(
            @RequestParam(name = "brand_id") Integer brandId,
            @RequestParam(name = "product_id") int productId,
            @RequestParam(name = "date") String appliedDate) {
        return null;
    }
}
