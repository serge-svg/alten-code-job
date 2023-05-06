package svg.altencodejob;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import svg.altencodejob.infra.adapters.input.PriceMapper;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Prices API", version = "1.0", description = "Prices API Information"))
public class AltenCodeJobAssessment {
    public static void main(String[] args) {
        SpringApplication.run(AltenCodeJobAssessment.class, args);
    }

    @Bean
    PriceMapper priceMapper() {
        return PriceMapper.INSTANCE;
    }
}