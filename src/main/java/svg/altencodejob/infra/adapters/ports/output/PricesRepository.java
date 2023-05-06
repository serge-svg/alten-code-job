package svg.altencodejob.infra.adapters.ports.output;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import svg.altencodejob.domain.Price;


import java.sql.Timestamp;
import java.util.List;

@Repository
public interface PricesRepository extends JpaRepository<Price, Integer> {

    List<Price> findPricesByBrandIdAndProductId(int brandId, int productId);

    @Query(value = "SELECT * FROM PRICES p WHERE brand_id = ?1 and product_id = ?2 and start_date <= ?3 and end_date >= ?3",
            nativeQuery = true)
    List<Price> findBy(Integer brandId,
                       Integer productId,
                       Timestamp appliedDate);
}
