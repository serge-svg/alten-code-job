package svg.altencodejob.application;

import svg.altencodejob.domain.Price;
import svg.altencodejob.infra.ports.output.PricesRepository;
import svg.altencodejob.infra.ports.input.PricesInputPort;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PriceService implements PricesInputPort {

    PricesRepository pricesRepository;

    public PriceService(PricesRepository pricesRepository) {
        this.pricesRepository = pricesRepository;
    }

    @Override
    public List<Price> getAll() {
        return pricesRepository.findAll();
    }

    @Override
    public List<Price> getPricesByBrandIdAndProductId(Integer brandId, Integer productId) {
        return pricesRepository.findPricesByBrandIdAndProductId(brandId, productId);
    }

    @Override
    public List<Price> getPricesByBrandIdProductIdAndDate(Integer brandId, Integer productId, String date) {
        return pricesRepository.findBy(brandId, productId, stringToTimestamp(date));
    }

    private Timestamp stringToTimestamp(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        return Timestamp.valueOf(LocalDateTime.parse(date, formatter));
    }
}
